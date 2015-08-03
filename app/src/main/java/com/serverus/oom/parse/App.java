package com.serverus.oom.parse;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

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
        ParseObject.registerSubclass(Enquiry.class);
        Parse.initialize(this, YOUR_APPLICATION_ID, YOUR_CLIENT_KEY);
        ParseInstallation.getCurrentInstallation().saveInBackground();


    }
}
