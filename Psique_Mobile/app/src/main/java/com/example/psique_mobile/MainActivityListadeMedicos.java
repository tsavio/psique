package com.example.psique_mobile;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivityListadeMedicos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listade_medicos);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

        final ListView lista = (ListView) findViewById(R.id.Lista_medicos);
        final ArrayList<Medico> medicos = adcionarMedicos();
        final ArrayAdapter adapter = new MedicosAdapter(this, medicos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Medico medico = (Medico) lista.getItemAtPosition(position);

                Intent intent =  new Intent(MainActivityListadeMedicos.this,MainActivityVideoChamada.class);
                intent.putExtra("NomeMedico",medicos.get(position).getNome());
                intent.putExtra("ProfissaoMedico",medicos.get(position).getProfissao());
                intent.putExtra("EnderecoMedico",medicos.get(position).getEndereco());
                intent.putExtra("imagem",medicos.get(position).getImagem());
                startActivity(intent);
            }
        });

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
                Intent intent = new Intent(MainActivityListadeMedicos.this, MainActivityPerfilPaciente.class);
                startActivity(intent);
                break;
            case R.id.Blog:
                //blog
                break;
            case R.id.Sobre:
                //Sobre
                break;
                default:
        }






        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Medico> adcionarMedicos(){
        ArrayList<Medico> medicos = new ArrayList<Medico>();
        Medico m = new Medico("Dr. Henrique Figueiredo","Psicólogo / Psiquiatra","Recife - PE",R.drawable.ic_menu_camera);

        medicos.add(m);
        m = new Medico("Dr. Edney Soares","Psiquiatra","Olinda - PE",R.drawable.ic_menu_camera);

        medicos.add(m);
        m = new Medico("Dra. Nilziane Ferreira","Psicóloga / Psiquiatra","Jaboatão dos Guararapes - PE",R.drawable.ic_menu_camera);

        medicos.add(m);
        m = new Medico("Dr. Arthur Sales","Psiquiatra","Paulista - PE",R.drawable.ic_menu_camera);

        medicos.add(m);
        m = new Medico("Dra. Andrea Marques","Psicóloga","Caruaru - PE",R.drawable.ic_menu_camera);

        medicos.add(m);

        return medicos;


    }

}
