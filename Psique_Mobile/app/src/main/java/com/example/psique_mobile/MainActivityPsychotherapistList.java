package com.example.psique_mobile;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivityPsychotherapistList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_psychotherapist_list);

        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

        final ListView lista = findViewById(R.id.Lista_medicos);
        final ArrayList<Psychotherapist> psychotherapists = new ArrayList<>();
        final ArrayAdapter adapter = new PsychotherapistsAdapter(this, psychotherapists);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Psychotherapist medico = (Psychotherapist) lista.getItemAtPosition(position);

                Intent intent =  new Intent(MainActivityPsychotherapistList.this, MainActivityVideoCall.class);
                intent.putExtra("NomeMedico", psychotherapists.get(position).getNome());
                intent.putExtra("ProfissaoMedico", psychotherapists.get(position).getProfissao());
                //intent.putExtra("EnderecoMedico",psychotherapists.get(position).getEndereco());
                //intent.putExtra("imagem",psychotherapists.get(position).getImagem());
                startActivity(intent);
            }
        });

    }

    private boolean adcionarMedicos() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.perfil:
                Intent intent = new Intent(MainActivityPsychotherapistList.this, MainActivityPatientProfile.class);
                startActivity(intent);
                break;
            case R.id.Blog:
                String url = "https://www.psicologiaviva.com.br/blog/superar-a-depressao/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

                break;
            case R.id.Sobre:
                //Sobre
                break;
            case R.id.Paciente:
                Intent intent2 = new Intent(MainActivityPsychotherapistList.this, PatientRegister.class);
                startActivity(intent2);
                break;

                default:
        }

        return super.onOptionsItemSelected(item);
    }

    //private ArrayList<Psychotherapist> adcionarMedicos(){
      //  ArrayList<Psychotherapist> medicos = new ArrayList<Psychotherapist>();
        //Psychotherapist m = new Psychotherapist("Dr. Henrique Figueiredo","Psicólogo / Psiquiatra","Recife - PE",R.drawable.ic_menu_camera);

//        medicos.add(m);
//        m = new Psychotherapist("Dr. Edney Soares","Psiquiatra","Olinda - PE",R.drawable.ic_menu_camera);

//        medicos.add(m);
//        m = new Psychotherapist("Dra. Nilziane Ferreira","Psicóloga / Psiquiatra","Jaboatão dos Guararapes - PE",R.drawable.ic_menu_camera);

//        medicos.add(m);
//        m = new Psychotherapist("Dr. Arthur Sales","Psiquiatra","Paulista - PE",R.drawable.ic_menu_camera);

//        medicos.add(m);
//        m = new Psychotherapist("Dra. Andrea Marques","Psicóloga","Caruaru - PE",R.drawable.ic_menu_camera);

//        medicos.add(m);

//        return medicos;


    //}

}
