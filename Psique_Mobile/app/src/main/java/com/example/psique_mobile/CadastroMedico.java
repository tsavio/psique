package com.example.psique_mobile;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
import java.util.UUID;

public class CadastroMedico extends AppCompatActivity {

    EditText edNome,edSpecialty, edCpf,edCrp, edEmail, edTelefone ;
    ListView list_dados_medico;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseMedico;

    private List<Doctor> listMedico = new ArrayList<Doctor>();
    private ArrayAdapter<Doctor> arrayAdapterDoctor;


    Doctor doctorSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_medico);
        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

        edNome = findViewById(R.id.edNome);
        edSpecialty = findViewById(R.id.edSpecialty);
        edCpf = findViewById(R.id.edCpf);
        edCrp = findViewById(R.id.edCrp);
        edEmail = findViewById(R.id.edEmail);
        edTelefone = findViewById(R.id.edTelefone);

        list_dados_medico = findViewById(R.id.list_dados_medico);

        inicializarFirebase();
        eventoDatabase();

        list_dados_medico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                doctorSelecionado = (Doctor) parent.getItemAtPosition(position);

                edSpecialty.setText(doctorSelecionado.getSpecialty());
                edCrp.setText(doctorSelecionado.getCrp());
                edCpf.setText(doctorSelecionado.getCpf());
                edEmail.setText(doctorSelecionado.getEmail());
                edNome.setText(doctorSelecionado.getName());
                edTelefone.setText(doctorSelecionado.getPhone());
            }
        });
    }



    private void eventoDatabase() {
        databaseMedico.child("Doctor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listMedico.clear();
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Doctor doctor = objSnapshot.getValue(Doctor.class);
                    listMedico.add(doctor);
                }
                arrayAdapterDoctor = new ArrayAdapter<Doctor>(CadastroMedico.this,
                        android.R.layout.simple_list_item_1,listMedico);
                list_dados_medico.setAdapter(arrayAdapterDoctor);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(CadastroMedico.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseMedico = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastro_medico,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.newmedico) {
            Doctor doctor = new Doctor();
            doctor.setId(UUID.randomUUID().toString());
            doctor.setName(edNome.getText().toString());
            doctor.setSpecialty(edSpecialty.getText().toString());
            doctor.setCpf(edCpf.getText().toString());
            doctor.setCrp(edCrp.getText().toString());
            doctor.setEmail(edEmail.getText().toString());
            doctor.setPhone(edTelefone.getText().toString());

            databaseMedico.child("Doctor").child(doctor.getId()).setValue(doctor);
            Toast.makeText(this, "Medico Adcionado", Toast.LENGTH_LONG).show();
            ClearTxt();
        }else if (id == R.id.update){
            Doctor doctor = new Doctor();
            doctor.setId(doctorSelecionado.getId());
            doctor.setName(edNome.getText().toString().trim());
            doctor.setSpecialty(edSpecialty.getText().toString().trim());
            doctor.setCpf(edCpf.getText().toString().trim());
            doctor.setCrp(edCrp.getText().toString().trim());
            doctor.setEmail(edEmail.getText().toString().trim());
            doctor.setPhone(edTelefone.getText().toString().trim());
            databaseMedico.child("Doctor").child(doctor.getId()).setValue(doctor);
            Toast.makeText(this, "Cadastro Editado com Sucesso", Toast.LENGTH_LONG).show();
            ClearTxt();
        }else if (id == R.id.delete){
            Doctor doctor = new Doctor();
            doctor.setId(doctorSelecionado.getId());
            databaseMedico.child("Doctor").child(doctor.getId()).removeValue();
            Toast.makeText(this, "Medico Deletado", Toast.LENGTH_LONG).show();
            ClearTxt();
        }else if (id == R.id.voltar) {
            Intent intent = new Intent(getApplicationContext(), MainActivityListadeMedicos.class);
            startActivity(intent);
            finish();
        }
        return true;
    }

    private void ClearTxt() {
        edNome.setText("");
        edEmail.setText("");
        edCpf.setText("");
        edTelefone.setText("");
        edCrp.setText("");
        edSpecialty.setText("");
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}
