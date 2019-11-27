package com.example.psique_mobile.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.psique_mobile.Agendamento;
import com.example.psique_mobile.ListDoctor;
import com.example.psique_mobile.MainActivityVideoChamada;
import com.example.psique_mobile.R;
import com.example.psique_mobile.VideoChamada;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListAgendamento extends AppCompatActivity {

    private ListView list_agendamento;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseAvailabilityTime;

    private List<Agendamento> listAgendamento = new ArrayList<Agendamento>();
    private ArrayAdapter<Agendamento> arrayAdapterAgendamento;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

        inicializaComponentes();
        inicializaFirebase();
        eventoDatabase();

        list_agendamento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id) {
                Intent intent = new Intent(ListAgendamento.this, MainActivityVideoChamada.class);
                intent.putExtra("Nome",String.valueOf(position));
                intent.putExtra("Data",String.valueOf(position));
                intent.putExtra("Hora",String.valueOf(position));

                startActivity(intent);
            }
        });



    }



    private void  eventoDatabase(){

        databaseAvailabilityTime.child("Agendamento").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listAgendamento.clear();
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Agendamento agendamento = objSnapshot.getValue(Agendamento.class);
                    listAgendamento.add(agendamento);
                }
                arrayAdapterAgendamento = new ArrayAdapter<Agendamento>(ListAgendamento.this,
                        android.R.layout.simple_list_item_1,listAgendamento);
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
        firebaseDatabase.setPersistenceEnabled(true);
        databaseAvailabilityTime = firebaseDatabase.getReference();
    }

    private void inicializaComponentes() {


        list_agendamento = (ListView)findViewById(R.id.list_agendamento);

    }
}
