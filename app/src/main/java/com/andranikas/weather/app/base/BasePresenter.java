package com.andranikas.weather.app.base;

/**
 * Created by andranikas on 10/18/2017.
 */

public interface BasePresenter<T> {

    /**
     * Binds presenter with a view when resumed. The Presenter will perform initialization here.
     *
     * @param view the view associated with this presenter
     */
    void takeView(T view);

    /**
     * Drops the reference to the view when destroyed
     */
    void dropView();

}
