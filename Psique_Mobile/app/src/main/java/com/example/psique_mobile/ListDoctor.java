package com.example.psique_mobile;

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

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListDoctor extends AppCompatActivity {

    private ListView list_doctor;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseMedico;

    private List<Doctor> listDoctor = new ArrayList<Doctor>();
    private ArrayAdapter<Doctor> arrayAdapterDoctor;

    Doctor doctorSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_doctor);

        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

        inicializaComponentes();
        inicializaFirebase();
        eventoDatabase();

        list_doctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListDoctor.this, VideoChamada.class);
                intent.putExtra("Name",String.valueOf(position));
                intent.putExtra("Phone",String.valueOf(position));
                intent.putExtra("Specialty",String.valueOf(position));

                startActivity(intent);
            }
        });
    }


    private void eventoDatabase() {
        databaseMedico.child("Doctor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listDoctor.clear();
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Doctor doctor = objSnapshot.getValue(Doctor.class);
                    listDoctor.add(doctor);
                }
                arrayAdapterDoctor = new ArrayAdapter<Doctor>(ListDoctor.this,
                        android.R.layout.simple_list_item_1,listDoctor);
                list_doctor.setAdapter(arrayAdapterDoctor);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void inicializaFirebase() {
        FirebaseApp.initializeApp(ListDoctor.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseMedico = firebaseDatabase.getReference();
    }

    private void inicializaComponentes() {

        list_doctor = (ListView)findViewById(R.id.list_doctor);


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.perfil:
//                Intent intent = new Intent(ListDoctor.this, MainActivityPerfilPaciente.class);
//                startActivity(intent);
//                break;
//            case R.id.Blog:
//                String url = "https://www.psicologiaviva.com.br/blog/superar-a-depressao/";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//
//                break;
//            case R.id.Sobre:
//                //Sobre
//                break;
//            case R.id.Paciente:
//                Intent intent2 = new Intent(ListDoctor.this, CadastroPaciente.class);
//                startActivity(intent2);
//                break;
//            case R.id.Medico:
//                Intent intent3 = new Intent (ListDoctor.this, CadastroMedico.class);
//                startActivity(intent3);
//                break;
//
//            default:
//        }
//
//        return super.onOptionsItemSelected(item);
//    }



}
