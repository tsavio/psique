package com.example.psique_mobile.app;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import android.app.Application;

public class FirebaseInit extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        FirebaseApp.initializeApp(this);
    }

}