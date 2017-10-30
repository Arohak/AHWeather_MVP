package com.andranikas.weather.cityweather.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andranikas.weather.R;
import com.andranikas.weather.app.base.BaseFragment;
import com.andranikas.weather.cityweather.view.adapter.DaysAdapter;
import com.andranikas.weather.data.entities.DayTemperature;
import com.andranikas.weather.di.ActivityScoped;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by andranikas on 10/19/2017.
 */

@ActivityScoped
public class ForecastFragment extends BaseFragment {

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    private DaysAdapter mAdapter;

    @Inject
    public ForecastFragment() {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        bindView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new DaysAdapter();

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
    }

    public void showForecast(List<DayTemperature> days) {
        mAdapter.setItems(days);
    }
}