package com.andranikas.weather.cityweather.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andranikas.weather.R;
import com.andranikas.weather.app.base.BaseFragment;
import com.andranikas.weather.data.entities.City;
import com.andranikas.weather.util.UIUtil;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by andranikas on 10/23/2017.
 */

public class CityFragment extends BaseFragment {

    @BindView(R.id.city_name) TextView mCityName;
    @BindView(R.id.city_weather_description) TextView mCityWeatherDescription;
    @BindView(R.id.city_current_temperature) TextView mCityCurrentTemperature;
    @BindView(R.id.city_current_weather_icon) ImageView mCityWeatherIcon;

    @Inject
    public CityFragment() {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container, false);
        bindView(view);
        return view;
    }

    public void showCity(City city) {
        mCityName.setText(city.getName());
        mCityWeatherDescription.setText(city.getDescription());
        mCityCurrentTemperature.setText(getString(R.string.temperature, city.getTemperature()));
        UIUtil.displayImageAsynchronously(city.getConditionIconPath(), mCityWeatherIcon);
    }
}
