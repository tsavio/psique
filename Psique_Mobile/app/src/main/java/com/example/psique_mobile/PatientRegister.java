package com.example.psique_mobile;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.psique_mobile.activity.MainDoctorListActivity;
import com.example.psique_mobile.model.Person;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PatientRegister extends AppCompatActivity {
    EditText edNome, edEmail, edCpf, edTelefone;
    ListView list_dados;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databasePessoa;

    private List<Person> listPerson = new ArrayList<Person>();
    private ArrayAdapter<Person> arrayAdapterPessoa;

    Person personSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);
        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

        edNome = findViewById(R.id.edNome);
        edEmail = findViewById(R.id.edEmail);
        edCpf = findViewById(R.id.edCpf);
        edTelefone = findViewById(R.id.edTelefone);
        list_dados = findViewById(R.id.list_dados);

        inicializarFirebase();
        eventoDatabase();

        list_dados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                personSelecionada = (Person)parent.getItemAtPosition(position);
                edNome.setText(personSelecionada.getNome());
                edEmail.setText(personSelecionada.getEmail());
                edCpf.setText(personSelecionada.getCpf());
                edTelefone.setText(personSelecionada.getTelefone());
            }
        });

    }

    private void eventoDatabase() {
        databasePessoa.child("Pessoas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listPerson.clear();
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Person person = objSnapshot.getValue(Person.class);
                    listPerson.add(person);
                }
                arrayAdapterPessoa = new ArrayAdapter<Person>(PatientRegister.this,
                        android.R.layout.simple_list_item_1, listPerson);
                        list_dados.setAdapter(arrayAdapterPessoa);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(PatientRegister.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databasePessoa = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_patient_register,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.novopaciente) {
            Person person = new Person();
            person.setId(UUID.randomUUID().toString());
            person.setNome(edNome.getText().toString());
            person.setEmail(edEmail.getText().toString());
            person.setCpf(edCpf.getText().toString());
            person.setTelefone(edTelefone.getText().toString());
            databasePessoa.child("Pessoas").child(person.getId()).setValue(person);
            Toast.makeText(this, "Paciente Adcionado", Toast.LENGTH_LONG).show();
            ClearTxt();

        }else if (id == R.id.update){
            Person person = new Person();
            person.setId(personSelecionada.getId());
            person.setNome(edNome.getText().toString().trim());
            person.setEmail(edEmail.getText().toString().trim());
            person.setCpf(edCpf.getText().toString().trim());
            person.setTelefone(edTelefone.getText().toString().trim());
            databasePessoa.child("Pessoas").child(person.getId()).setValue(person);
            Toast.makeText(this, "Cadastro Editado com Sucesso", Toast.LENGTH_LONG).show();
            ClearTxt();

        }else if (id == R.id.delete){
            Person person = new Person();
            person.setId(personSelecionada.getId());
            databasePessoa.child("Pessoas").child(person.getId()).removeValue();
            Toast.makeText(this, "Paciente Deletado", Toast.LENGTH_LONG).show();
            ClearTxt();

        }else if (id == R.id.voltar){
            Intent intent = new Intent(getApplicationContext(), MainDoctorListActivity.class);
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
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}