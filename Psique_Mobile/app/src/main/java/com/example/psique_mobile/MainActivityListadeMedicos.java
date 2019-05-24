package com.example.psique_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityListadeMedicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listade_medicos);

        ListView lista = (ListView) findViewById(R.id.Lista_medicos);
        ArrayAdapter adapter = new MedicosAdapter(this, adcionarMedicos());
        lista.setAdapter(adapter);

    }
    private ArrayList<Medico> adcionarMedicos(){
        ArrayList<Medico> medicos = new ArrayList<Medico>();
        Medico m = new Medico("Dr. Henrique Figueiredo","Psicólogo / Psiquiatra","Recife - PE",R.drawable.ic_menu_camera);

        medicos.add(m);
        m = new Medico("Dr. Edney Soares","Psiquiatra","Olinda - PE",R.drawable.ic_menu_camera);

        medicos.add(m);
        m = new Medico("Dra. Nilziane Ferreira","Psicóloga / Psiquiatra","Jaboatão dos Guararapes - PE",R.drawable.ic_menu_camera);

        medicos.add(m);
        m = new Medico("Dr. Arthur Sales","Psiquiatra","Paulista - PE",R.drawable.ic_menu_camera);

        medicos.add(m);
        m = new Medico("Dra. Andrea Marques","Psicóloga","Caruaru - PE",R.drawable.ic_menu_camera);

        medicos.add(m);

        return medicos;


    }

}
