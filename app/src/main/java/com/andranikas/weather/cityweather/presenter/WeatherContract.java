package com.andranikas.weather.cityweather.presenter;

import com.andranikas.weather.app.base.BasePresenter;
import com.andranikas.weather.app.base.BaseView;
import com.andranikas.weather.data.entities.City;
import com.andranikas.weather.data.entities.CurrentWeather;
import com.andranikas.weather.data.entities.DayTemperature;

import java.util.List;

/**
 * Created by andranikas on 10/19/2017.
 */

public class WeatherContract {

    public interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showCity(final City city);

        void showCurrentWeather(final CurrentWeather currentWeather);

        void showForecast(final List<DayTemperature> days);

        void showLoadingDataError();

        void showNoDataAvailable();

        void refresh();
    }

    public interface Presenter extends BasePresenter<View> {

        void takeView(WeatherContract.View view);

        void dropView();

        void loadWeatherData(final String city, final String units);
    }

}
