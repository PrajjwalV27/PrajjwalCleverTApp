package com.prajjwal.cleverapp;

import android.app.Application;
import android.app.NotificationManager;

import com.clevertap.android.sdk.ActivityLifecycleCallback;
import com.clevertap.android.sdk.CleverTapAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        ActivityLifecycleCallback.register(this);
        super.onCreate();
        // each of the below mentioned fields are optional
        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
        profileUpdate.put("Name", "James Bond");
        profileUpdate.put("Identity", 61026032);
        profileUpdate.put("Email", "mynameisbond@gmail.com");
        profileUpdate.put("Phone", "+14155551234");
        profileUpdate.put("Gender", "M");
        profileUpdate.put("DOB", new Date());
        ArrayList<String> stuff = new ArrayList<String>();
        stuff.add("bag");
        stuff.add("shoes");
        profileUpdate.put("MyStuff", stuff);
        String[] otherStuff = {"Jeans", "Perfume"};
        profileUpdate.put("MyStuff", otherStuff);

        CleverTapAPI clevertapDefaultInstance = null;
        clevertapDefaultInstance.onUserLogin(profileUpdate);

        clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        CleverTapAPI.createNotificationChannel(getApplicationContext(), "Got",
                "Got It Scussess", "Got It Scussess",
                NotificationManager.IMPORTANCE_MAX, true);
    }
}
