package com.example.psique_mobile;

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

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CadastroPaciente extends AppCompatActivity {
    EditText edNome, edEmail, edCpf, edTelefone;
    ListView list_dados;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databasePessoa;

    private List<Pessoa> listPessoa = new ArrayList<Pessoa>();
    private ArrayAdapter<Pessoa> arrayAdapterPessoa;

    Pessoa pessoaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_paciente);
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
                pessoaSelecionada = (Pessoa)parent.getItemAtPosition(position);
                edNome.setText(pessoaSelecionada.getNome());
                edEmail.setText(pessoaSelecionada.getEmail());
                edCpf.setText(pessoaSelecionada.getCpf());
                edTelefone.setText(pessoaSelecionada.getTelefone());
            }
        });

    }

    private void eventoDatabase() {
        databasePessoa.child("Pessoas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listPessoa.clear();
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Pessoa pessoa = objSnapshot.getValue(Pessoa.class);
                    listPessoa.add(pessoa);
                }
                arrayAdapterPessoa = new ArrayAdapter<Pessoa>(CadastroPaciente.this,
                        android.R.layout.simple_list_item_1,listPessoa);
                        list_dados.setAdapter(arrayAdapterPessoa);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(CadastroPaciente.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databasePessoa = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastro_paciente,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.novopaciente) {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(UUID.randomUUID().toString());
            pessoa.setNome(edNome.getText().toString());
            pessoa.setEmail(edEmail.getText().toString());
            pessoa.setCpf(edCpf.getText().toString());
            pessoa.setTelefone(edTelefone.getText().toString());
            databasePessoa.child("Pessoas").child(pessoa.getId()).setValue(pessoa);
            Toast.makeText(this, "Paciente Adcionado", Toast.LENGTH_LONG).show();
            ClearTxt();
        }else if (id == R.id.update){
            Pessoa pessoa = new Pessoa();
            pessoa.setId(pessoaSelecionada.getId());
            pessoa.setNome(edNome.getText().toString().trim());
            pessoa.setEmail(edEmail.getText().toString().trim());
            pessoa.setCpf(edCpf.getText().toString().trim());
            pessoa.setTelefone(edTelefone.getText().toString().trim());
            databasePessoa.child("Pessoas").child(pessoa.getId()).setValue(pessoa);
            Toast.makeText(this, "Cadastro Editado com Sucesso", Toast.LENGTH_LONG).show();
            ClearTxt();
        }else if (id == R.id.delete){
            Pessoa pessoa = new Pessoa();
            pessoa.setId(pessoaSelecionada.getId());
            databasePessoa.child("Pessoas").child(pessoa.getId()).removeValue();
            Toast.makeText(this, "Paciente Deletado", Toast.LENGTH_LONG).show();
            ClearTxt();
        }
        return true;
}

    private void ClearTxt() {
        edNome.setText("");
        edEmail.setText("");
        edCpf.setText("");
        edTelefone.setText("");
    }
}