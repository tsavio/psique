package com.example.psique_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityConsultaMedica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_medica);

        Intent intent = getIntent();
        String parametro = (String) intent.getSerializableExtra("nome");

        TextView nome = (TextView) findViewById(R.id.txtNome);

        nome.setText(parametro);

    }
}