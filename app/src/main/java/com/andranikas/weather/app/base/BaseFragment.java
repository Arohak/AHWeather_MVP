package com.andranikas.weather.app.base;

import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

/**
 * Created by andranikas on 10/20/2017.
 */

public abstract class BaseFragment extends DaggerFragment {

    protected Unbinder mUnbinder;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null)
            mUnbinder.unbind();
    }

    protected void bindView(View view) {
        mUnbinder = ButterKnife.bind(this, view);
    }
}
