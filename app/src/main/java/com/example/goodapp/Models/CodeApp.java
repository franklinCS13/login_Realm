package com.example.goodapp.Models;


import android.app.Application;
import io.realm.Realm;
import io.realm.RealmConfiguration;


public class CodeApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration codeConfig = new RealmConfiguration.Builder()
                .name("codeapp.realm")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(codeConfig);
    }
}
