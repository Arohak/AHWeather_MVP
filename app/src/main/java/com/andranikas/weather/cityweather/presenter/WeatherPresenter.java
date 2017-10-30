package com.andranikas.weather.cityweather.presenter;

import com.andranikas.weather.data.entities.City;
import com.andranikas.weather.data.entities.CurrentWeather;
import com.andranikas.weather.data.entities.DayTemperature;
import com.andranikas.weather.data.entities.Forecast;
import com.andranikas.weather.data.entities.Weather;
import com.andranikas.weather.data.entities.WeatherCondition;
import com.andranikas.weather.data.source.WeatherRepository;
import com.andranikas.weather.di.ActivityScoped;
import com.andranikas.weather.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subscribers.DisposableSubscriber;

import static com.andranikas.weather.util.Constants.ICON_BASE_URL;

/**
 * Created by andranikas on 10/19/2017.
 */

@ActivityScoped
public class WeatherPresenter implements WeatherContract.Presenter {

    private static final String API_KEY = "d9e55cac1a14a4b4eb81a6017b3cff2f";

    private final WeatherRepository mWeatherRepository;
    @Nullable
    private WeatherContract.View mView;
    private CompositeDisposable mDisposable;

    @Inject
    WeatherPresenter(WeatherRepository weatherRepository) {
        mWeatherRepository = weatherRepository;

        mDisposable = new CompositeDisposable();
    }

    @Override
    public void takeView(WeatherContract.View view) {
        mView = view;
    }

    @Override
    public void dropView() {
        mDisposable.clear();
        mView = null;
    }

    @Override
    public void loadWeatherData(String city, String units) {
        mDisposable.add(mWeatherRepository.getCurrentWeather(API_KEY, city, units)
                .subscribeWith(new DisposableSubscriber<Weather>() {
                    @Override
                    public void onNext(Weather weather) {
                        if (weather != null) {
                            mWeatherRepository.saveCurrentWeather(weather);
                            if (mView != null) {
                                final City city = mapToCity(weather);
                                final CurrentWeather currentWeather = mapToCurrentWeather(weather);
                                mView.showCity(city);
                                mView.showCurrentWeather(currentWeather);
                            }
                        } else if (mView != null) {
                            mView.showNoDataAvailable();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (mView != null) {
                            mView.showLoadingDataError();
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                }));

        mDisposable.add(mWeatherRepository.getForecast(API_KEY, city, units)
                .subscribeWith(new DisposableSubscriber<Forecast>() {
                    @Override
                    public void onNext(Forecast forecast) {
                        if (forecast != null) {
                            mWeatherRepository.saveForecast(forecast, city);
                            if (mView != null) {
                                final List<DayTemperature> days = mapToDays(forecast);
                                mView.showForecast(days);
                            }
                        } else if (mView != null) {
                            mView.showNoDataAvailable();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mView != null) {
                            mView.showLoadingDataError();
                        }
                    }

                    @Override
                    public void onComplete() {
                    }
                }));
    }

    @NonNull
    private City mapToCity(Weather weather) {
        WeatherCondition condition = weather.getConditions().get(0);
        return new City(weather.getName(), condition.getGroupedCondition() + " - " + condition.getDescription(), Math.round(weather.getTemperature().getCurrentTemperature()), ICON_BASE_URL + condition.getIcon() + ".png");
    }

    @NonNull
    private CurrentWeather mapToCurrentWeather(Weather weather) {
        return new CurrentWeather(DateUtil.amPmTimeFromUTCSeconds(weather.getSun().getSunrise()),
                DateUtil.amPmTimeFromUTCSeconds(weather.getSun().getSunset()),
                weather.getCloud().getCloudiness(),
                weather.getWind().getSpeed(),
                weather.getTemperature().getHumidity(),
                weather.getTemperature().getPressure());
    }

    @NonNull
    private List<DayTemperature> mapToDays(Forecast forecast) {
        return groupDays(forecast.getWeathers());
    }

    @NonNull
    private List<DayTemperature> groupDays(List<Weather> weathers) {
        List<DayTemperature> dayTemperatures = new ArrayList<>();

        Flowable.fromIterable(weathers).forEach(weather -> {
            Flowable<DayTemperature> result = Flowable.fromIterable(dayTemperatures).filter(dayTemperature -> DateUtil.dayFromUTCSeconds(dayTemperature.getDateTimeInMillis()) == DateUtil.dayFromUTCSeconds(weather.getDateTimeInMillis()));
            if (result.count().blockingGet() == 0) {
                DayTemperature dayTemperature = new DayTemperature(weather.getTemperature().getMinTemperature(), weather.getTemperature().getMaxTemperature(), weather.getDateTimeInMillis(), DateUtil.dayNameFromUTCSeconds(weather.getDateTimeInMillis()));
                dayTemperatures.add(dayTemperature);
            } else {
                DayTemperature dayTemperature = result.blockingSingle();
                int index = dayTemperatures.indexOf(dayTemperature);
                if (weather.getTemperature().getMinTemperature() < dayTemperature.getMin()) {
                    dayTemperature.setMin(weather.getTemperature().getMinTemperature());
                    dayTemperatures.set(index, dayTemperature);
                }

                if (weather.getTemperature().getMaxTemperature() > dayTemperature.getMax()) {
                    dayTemperature.setMax(weather.getTemperature().getMaxTemperature());
                    dayTemperatures.set(index, dayTemperature);
                }
            }
        });

        return dayTemperatures;
    }
}
