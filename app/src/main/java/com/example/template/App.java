package com.example.template;

import android.app.Application;

import com.example.template.di.AppComponent;
import com.example.template.di.DaggerAppComponent;
import com.example.template.di.StorageModule;


public class App extends Application {
    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .storageModule(new StorageModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
