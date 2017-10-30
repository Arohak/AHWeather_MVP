package com.andranikas.weather.cityweather.view.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.andranikas.weather.R;
import com.andranikas.weather.cityweather.presenter.WeatherContract;
import com.andranikas.weather.cityweather.view.fragments.CityFragment;
import com.andranikas.weather.cityweather.view.fragments.CurrentWeatherFragment;
import com.andranikas.weather.cityweather.view.fragments.ForecastFragment;
import com.andranikas.weather.data.entities.City;
import com.andranikas.weather.data.entities.CurrentWeather;
import com.andranikas.weather.data.entities.DayTemperature;
import com.andranikas.weather.util.ActivityUtils;
import com.andranikas.weather.util.UIUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by andranikas on 10/19/2017.
 */

public class MainActivity extends DaggerAppCompatActivity implements WeatherContract.View {

    private static final String CITY = "Lyon,fr";
    private static final String UNITS = "metric";

    @Inject
    WeatherContract.Presenter mWeatherPresenter;
    @Inject
    Lazy<CurrentWeatherFragment> mCurrentWeatherFragmentProvider;
    @Inject
    Lazy<ForecastFragment> mForecastFragmentProvider;
    @Inject
    Lazy<CityFragment> mCityFragmentProvider;

    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = this::refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        CurrentWeatherFragment currentWeatherFragment =
                (CurrentWeatherFragment) getSupportFragmentManager().findFragmentById(R.id.currentWeatherContentFrame);
        if (currentWeatherFragment == null) {
            currentWeatherFragment = mCurrentWeatherFragmentProvider.get();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), currentWeatherFragment, R.id.currentWeatherContentFrame);
        }

        ForecastFragment forecastFragment =
                (ForecastFragment) getSupportFragmentManager().findFragmentById(R.id.forecastContentFrame);
        if (forecastFragment == null) {
            forecastFragment = mForecastFragmentProvider.get();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), forecastFragment, R.id.forecastContentFrame);
        }

        CityFragment cityFragment =
                (CityFragment) getSupportFragmentManager().findFragmentById(R.id.cityContentFrame);
        if (cityFragment == null) {
            cityFragment = mCityFragmentProvider.get();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), cityFragment, R.id.cityContentFrame);
        }

        mRefresh.setOnRefreshListener(mOnRefreshListener);

        mWeatherPresenter.takeView(this);
        mWeatherPresenter.loadWeatherData(CITY, UNITS);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWeatherPresenter.dropView();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        mRefresh.setRefreshing(active);
    }

    @Override
    public void showCity(City city) {
        CityFragment cityFragment =
                (CityFragment) getSupportFragmentManager().findFragmentById(R.id.cityContentFrame);
        if (cityFragment == null) {
            cityFragment = mCityFragmentProvider.get();
        }

        if (city != null) {
            cityFragment.showCity(city);
        }
    }

    @Override
    public void showCurrentWeather(CurrentWeather currentWeather) {
        CurrentWeatherFragment currentWeatherFragment =
                (CurrentWeatherFragment) getSupportFragmentManager().findFragmentById(R.id.currentWeatherContentFrame);
        if (currentWeatherFragment == null) {
            currentWeatherFragment = mCurrentWeatherFragmentProvider.get();
        }
        if (currentWeather != null) {
            currentWeatherFragment.showCurrentWeather(currentWeather);
        }
    }

    @Override
    public void showForecast(List<DayTemperature> days) {
        ForecastFragment forecastFragment =
                (ForecastFragment) getSupportFragmentManager().findFragmentById(R.id.forecastContentFrame);
        if (forecastFragment == null) {
            forecastFragment = mForecastFragmentProvider.get();
        }
        if (days != null && days.size() > 0) {
            forecastFragment.showForecast(days);
        }
        setLoadingIndicator(false);
    }

    @Override
    public void showLoadingDataError() {
        setLoadingIndicator(false);
        UIUtil.showInfo(mRefresh, R.string.no_internet_connection);
    }

    @Override
    public void showNoDataAvailable() {
        setLoadingIndicator(false);
        UIUtil.showInfo(mRefresh, R.string.no_data_available);
    }

    @Override
    public void refresh() {
        setLoadingIndicator(true);
        mWeatherPresenter.loadWeatherData(CITY, UNITS);
    }
}