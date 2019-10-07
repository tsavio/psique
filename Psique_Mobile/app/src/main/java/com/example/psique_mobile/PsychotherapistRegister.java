package com.example.psique_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PsychotherapistRegister extends AppCompatActivity {
    EditText edNome, edEmail, edCpf, edTelefone, edCrp, edProfissao;
    ListView list_dados_medico;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseMedico;

    private List<Medico> listMedico = new ArrayList<Medico>();
    private ArrayAdapter<Medico> arrayAdapterMedico;
    public static final int CONSTANTE_CADASTRO_MEDICO = 1;

    Medico medicoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychotherapist_register);
        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

        edNome = findViewById(R.id.edNome);
        edEmail = findViewById(R.id.edEmail);
        edCpf = findViewById(R.id.edCpf);
        edTelefone = findViewById(R.id.edTelefone);
        edCrp = findViewById(R.id.edCrp);
        edProfissao = findViewById(R.id.edProfissao);
        list_dados_medico = findViewById(R.id.list_dados_medico);

        inicializarFirebase();
        eventoDatabase();

        list_dados_medico.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                medicoSelecionado = (Medico) parent.getItemAtPosition(position);
                edProfissao.setText(medicoSelecionado.getProfissao());
                edCrp.setText(medicoSelecionado.getCrp());
                edCpf.setText(medicoSelecionado.getCpf());
                edEmail.setText(medicoSelecionado.getEmail());
                edNome.setText(medicoSelecionado.getNome());
                edTelefone.setText(medicoSelecionado.getTelefone());
            }

        });
    }



    private void eventoDatabase() {
        databaseMedico.child("Medico").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listMedico.clear();
                for (DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Medico medico = objSnapshot.getValue(Medico.class);
                    listMedico.add(medico);
                }
                arrayAdapterMedico = new ArrayAdapter<Medico>(PsychotherapistRegister.this,
                        android.R.layout.simple_list_item_1,listMedico);
                list_dados_medico.setAdapter(arrayAdapterMedico);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(PsychotherapistRegister.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseMedico = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_psychotherapist_register,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.novomedico) {
            Medico medico1 = new Medico();
           Bundle medico = new Bundle();
            medico1.setId(UUID.randomUUID().toString());
            medico.putString("nome",edNome.getText().toString());
            medico.putString("email",edEmail.getText().toString());
            medico.putString("cpf",edCpf.getText().toString());
            medico.putString("telefone",edTelefone.getText().toString());
            medico.putString("crp",edCrp.getText().toString());
            medico.putString("profissao",edProfissao.getText().toString());
            databaseMedico.child("Medico").child(medico1.getId()).setValue(medico);
            Intent intent = new Intent(this, MainActivityPsychotherapistList.class);
intent.putExtras(medico);
startActivityForResult(intent, CONSTANTE_CADASTRO_MEDICO);


            Toast.makeText(this, "Medico Adcionado", Toast.LENGTH_LONG).show();
            ClearTxt();
        }else if (id == R.id.update){
            Medico medico = new Medico();
            medico.setId(medicoSelecionado.getId());
            medico.setNome(edNome.getText().toString().trim());
            medico.setEmail(edEmail.getText().toString().trim());
            medico.setCpf(edCpf.getText().toString().trim());
            medico.setTelefone(edTelefone.getText().toString().trim());
            medico.setCrp(edCrp.getText().toString().trim());
            medico.setProfissao(edProfissao.getText().toString().trim());
            databaseMedico.child("Medico").child(medico.getId()).setValue(medico);
            Toast.makeText(this, "Cadastro Editado com Sucesso", Toast.LENGTH_LONG).show();
            ClearTxt();
        }else if (id == R.id.delete){
            Medico medico = new Medico();
            medico.setId(medicoSelecionado.getId());
            databaseMedico.child("Medico").child(medico.getId()).removeValue();
            Toast.makeText(this, "Medico Deletado", Toast.LENGTH_LONG).show();
            ClearTxt();
        }
        return true;
    }

    private void ClearTxt() {
        edNome.setText("");
        edEmail.setText("");
        edCpf.setText("");
        edTelefone.setText("");
        edCrp.setText("");
        edProfissao.setText("");
    }
}
