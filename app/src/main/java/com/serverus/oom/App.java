package com.serverus.oom;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by alvinvaldez on 7/6/15.
 */
public class App extends Application {

    public static final String YOUR_APPLICATION_ID = "1vdHx98EkGTrOAqeLqnEcDl9rd3e9dZrKDcQyIzh";
    public static final String YOUR_CLIENT_KEY = "MXhEirVd5kW8jWWEpN5WFSEB8cf5tawckCYG4MOh";

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, YOUR_APPLICATION_ID, YOUR_CLIENT_KEY);
    }
}
