package com.foodapplication.mainScreen.client;

/**
 * Created by bijaybogati on 11/25/17.
 */

public class MainScreenPresenter implements MainScreenController.Presenter {

    MainScreenController.View view;

    public MainScreenPresenter(MainScreenController.View view) {
        this.view = view;
        view.setPresenter(this);
    }
}
