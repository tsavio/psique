package com.example.psique_mobile;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityConsultaMedica extends AppCompatActivity {
    ImageView imageViewFoto;
    RatingBar ratingBar;
    TextView txtNameDoctor, txtAnaAvalie;
    String name = null;
    String avalie = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_medica);

        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));


        imageViewFoto = (ImageView) findViewById(R.id.imageView);
        txtNameDoctor = (TextView)findViewById (R.id.nameDoctor);
        txtAnaAvalie = (TextView)findViewById (R.id.anaAvalie);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        name = getIntent().getStringExtra("nameDoctor");
        txtNameDoctor.setText("DR:"+ name );

        avalie = getIntent().getStringExtra("anaAvalie");
        txtAnaAvalie.setText(avalie);

    }
}