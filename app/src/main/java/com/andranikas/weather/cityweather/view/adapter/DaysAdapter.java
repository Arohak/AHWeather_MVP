package com.andranikas.weather.cityweather.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andranikas.weather.R;
import com.andranikas.weather.data.entities.DayTemperature;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andranikas on 10/24/2017.
 */

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DayViewHolder> {

    private List<DayTemperature> mDataSource;

    public DaysAdapter() {
        mDataSource = new ArrayList<>();
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent, false);
        return new DayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DayViewHolder holder, int position) {
        final DayTemperature dayTemperature = mDataSource.get(position);
        holder.bind(dayTemperature);
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    public void setItems(List<DayTemperature> items) {
        mDataSource.clear();
        mDataSource.addAll(items);
        notifyDataSetChanged();
    }

    static class DayViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.dayName) TextView mName;
        @BindView(R.id.minTemp) TextView mMinTemp;
        @BindView(R.id.maxTemp) TextView mMaxTemp;

        DayViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(final DayTemperature dayTemperature) {
            mName.setText(dayTemperature.getDay());
            mMinTemp.setText(dayTemperature.getRoundedMinTemperature());
            mMaxTemp.setText(dayTemperature.getRoundedMaxTemperature());
        }
    }
}
