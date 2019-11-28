package com.example.psique_mobile;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

import java.util.ArrayList;
import java.util.List;

public class ListAgendamento extends AppCompatActivity {

    ListView list_agendamento;
    Button btn_agendamento;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseAvailabilityTime;


    private List<Agendamento> listAgendamento = new ArrayList<Agendamento>();
    private ArrayAdapter<Agendamento> arrayAdapterAgendamento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_agendamento);

        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));


        inicializaComponentes();
        inicializaFirebase();
        eventoDatabase();
        eventoClick();

    }

    private void eventoClick(){

        btn_agendamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(getApplicationContext(),VideoChamada.class);
                startActivity(intent);
                finish();
            }


        });


    }


    private void eventoDatabase() {
        databaseAvailabilityTime.child("AvailabilityTime").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listAgendamento.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                    Agendamento agendamento = objSnapshot.getValue(Agendamento.class);
                    listAgendamento.add(agendamento);
                }
                arrayAdapterAgendamento = new ArrayAdapter<Agendamento>(ListAgendamento.this,
                        android.R.layout.simple_list_item_1, listAgendamento);
                list_agendamento.setAdapter(arrayAdapterAgendamento);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void inicializaFirebase() {
        FirebaseApp.initializeApp(ListAgendamento.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseAvailabilityTime = firebaseDatabase.getReference();
    }

    private void inicializaComponentes() {
        list_agendamento = (ListView) findViewById(R.id.list_agendamento);
        btn_agendamento = (Button) findViewById(R.id.btn_agendamento);
    }



}
