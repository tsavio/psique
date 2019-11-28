package com.example.psique_mobile;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class ActivityConsultas extends AppCompatActivity {

    private ListView list_consult;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseConsulta;

    private List<Consulta> listConsult = new ArrayList<Consulta>();
    private ArrayAdapter<Consulta> arrayAdapterConsulta;

    Consulta consultaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

        inicializaComponentes();
        inicializaFirebase();
        eventoDatabase();

        list_consult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ActivityConsultas.this, ActivityConsultaMedica.class);
                String name  = null;

                intent.putExtra("nameDoctor", listConsult.get(position).getDoctorName());
                intent.putExtra("anaAvalie",listConsult.get(position).getAnamnese());

                startActivity(intent);
            }
        });
    }


    private void eventoDatabase() {
        databaseConsulta.child("Consultation").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listConsult.clear();
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Consulta consulta = objSnapshot.getValue(Consulta.class);
//                    if (consulta.getPatientID()== )
                    listConsult.add(consulta);
                }
                arrayAdapterConsulta = new ArrayAdapter<Consulta>(ActivityConsultas.this,
                        android.R.layout.simple_list_item_1,listConsult);
                list_consult.setAdapter(arrayAdapterConsulta);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void inicializaFirebase() {
        FirebaseApp.initializeApp(ActivityConsultas.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseConsulta = firebaseDatabase.getReference();
    }

    private void inicializaComponentes() {

        list_consult = (ListView)findViewById(R.id.lvConsulta);


    }



}
