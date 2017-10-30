package com.andranikas.weather.util;

import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ImageView;

import com.andranikas.weather.app.network.GlideApp;

/**
 * Created by andranikas on 10/23/2017.
 */

public final class UIUtil {

    private UIUtil() {
    }

    public static void displayImageAsynchronously(String imagePath, ImageView into) {
        GlideApp.with(into.getContext()).load(imagePath).into(into);
    }

    public static void showInfo(View view, @StringRes int resId) {
        Snackbar.make(view, resId, Snackbar.LENGTH_SHORT).show();
    }
}
