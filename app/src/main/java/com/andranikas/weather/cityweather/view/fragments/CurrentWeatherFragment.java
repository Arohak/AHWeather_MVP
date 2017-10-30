package com.andranikas.weather.cityweather.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andranikas.weather.R;
import com.andranikas.weather.app.base.BaseFragment;
import com.andranikas.weather.data.entities.CurrentWeather;
import com.andranikas.weather.di.ActivityScoped;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by andranikas on 10/19/2017.
 */

@ActivityScoped
public class CurrentWeatherFragment extends BaseFragment {

    @BindView(R.id.sunrise) TextView mSunrise;
    @BindView(R.id.sunset) TextView mSunset;
    @BindView(R.id.clouds) TextView mClouds;
    @BindView(R.id.wind_speed) TextView mWindSpeed;
    @BindView(R.id.humidity) TextView mHumidity;
    @BindView(R.id.pressure) TextView mPressure;

    @Inject
    public CurrentWeatherFragment() {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);
        bindView(view);
        return view;
    }

    public void showCurrentWeather(CurrentWeather currentWeather) {
        mSunrise.setText(getString(R.string.sunrise, currentWeather.getSunrise()));
        mSunset.setText(getString(R.string.sunset, currentWeather.getSunset()));
        mClouds.setText(getString(R.string.clouds, currentWeather.getClouds()));
        mWindSpeed.setText(getString(R.string.wind_speed, currentWeather.getWindSpeed()));
        mHumidity.setText(getString(R.string.humidity, currentWeather.getHumidity()));
        mPressure.setText(getString(R.string.pressure, currentWeather.getPressure()));
    }
}
