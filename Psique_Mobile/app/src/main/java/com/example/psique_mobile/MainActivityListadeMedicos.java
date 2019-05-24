package com.example.psique_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivityListadeMedicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listade_medicos);

        String[] alunos = {"Daniel", "Ronaldo", "Jeferson", "Felipe"};
        ListView listaMedicos = (ListView) findViewById(R.id.Lista_medicos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);
        listaMedicos.setAdapter(adapter);
    }
}
