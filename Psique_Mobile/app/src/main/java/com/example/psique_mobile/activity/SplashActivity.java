package com.example.psique_mobile.activity;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.psique_mobile.MainLogin;
import com.example.psique_mobile.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //getSupportActionBar().hide();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
<<<<<<< Updated upstream:Psique_Mobile/app/src/main/java/com/example/psique_mobile/activity/SplashActivity.java
                startActivity(new Intent(getBaseContext(), MainLogin.class));
=======
                startActivity(new Intent(getBaseContext(), LoginPrincipal.class));
>>>>>>> Stashed changes:Psique_Mobile/app/src/main/java/com/example/psique_mobile/SplashActivity.java
                finish();
            }
        },2000);

    }
}
