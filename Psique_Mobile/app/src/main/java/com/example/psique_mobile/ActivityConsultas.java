package com.example.psique_mobile;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityConsultas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        ListView lista = (ListView) findViewById(R.id.lvConsulta);
        final ArrayList<Consulta> consultas = adcionarConsultas();
        ArrayAdapter adapter = new ConsultaAdapter(this, adcionarConsultas());
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivityConsultas.this, ActivityConsultaMedica.class);

                intent.putExtra("nome", consultas.get(i).getConsultationID());

                startActivity(intent);
            }
        });




    }

    private ArrayList<Consulta> adcionarConsultas(){
        ArrayList<Consulta> consultas = new ArrayList<Consulta>();
            //for (Consulta anArray : consultas){}
        return consultas;
    }
}
