package com.udacity.stockhawk.timber;

import android.app.Application;

import com.udacity.stockhawk.BuildConfig;

import timber.log.Timber;

public class StockHawkApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.uprootAll();
            Timber.plant(new Timber.DebugTree());
        }
    }
}
