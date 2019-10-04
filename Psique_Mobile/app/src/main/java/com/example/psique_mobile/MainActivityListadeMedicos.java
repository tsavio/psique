package com.example.psique_mobile;

import android.app.Activity;
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
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityListadeMedicos extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_medico);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle medico = intent.getExtras();
            if (medico != null) {
                String nome = medico.getString("nome");
                String email = medico.getString("email");
                String cpf = medico.getString("cpf");
                String telefone = medico.getString("telefone");
                String crm = medico.getString("crm");
                String profissão = medico.getString("profissão");

                TextView nomeTV = (TextView) findViewById(R.id.edNome);
                TextView emailTV = (TextView) findViewById(R.id.edEmail);
                TextView cpfTV = (TextView) findViewById(R.id.edCpf);
                TextView telefoneTV = (TextView) findViewById(R.id.edTelefone);
                TextView crmTV = (TextView) findViewById(R.id.edCrm);
                TextView profissãoTV = (TextView) findViewById(R.id.edProfissao);

                nomeTV.setText("Nome:" + nome);
                emailTV.setText("Email:" + email);
                cpfTV.setText("Cpf:" + cpf);
                telefoneTV.setText("Telefone:" + telefone);
                crmTV.setText("Crm:" + crm);
                profissãoTV.setText("Profissão:" + profissão);


            }
        }
    }
}







        //androidx.appcompat.app.ActionBar bar = getSupportActionBar();
      //  bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

      //  final ListView lista = findViewById(R.id.Lista_medicos);
       // final ArrayList<Medico> medicos = adcionarMedicos();
        //final ArrayAdapter adapter = new MedicosAdapter(this, medicos);
       // lista.setAdapter(adapter);

        //lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //@Override
          //  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Medico medico = (Medico) lista.getItemAtPosition(position);

              //  Intent intent =  new Intent(MainActivityListadeMedicos.this,MainActivityVideoChamada.class);
               // intent.putExtra("NomeMedico",medicos.get(position).getNome());
              //  intent.putExtra("ProfissaoMedico",medicos.get(position).getProfissao());
                //intent.putExtra("EnderecoMedico",medicos.get(position).getEndereco());
                //intent.putExtra("imagem",medicos.get(position).getImagem());
                //startActivity(intent);
           //}
        //});

    //}

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
      //  MenuInflater inflater = getMenuInflater();
        //inflater.inflate(R.menu.menu, menu);
        //return super.onCreateOptionsMenu(menu);
   // }

 //   @Override
   // public boolean onOptionsItemSelected(MenuItem item) {
     //   switch (item.getItemId()){
            //case R.id.perfil:
                //Intent intent = new Intent(MainActivityListadeMedicos.this, MainActivityPerfilPaciente.class);
               // startActivity(intent);
             //   break;
           // case R.id.Blog:
                //String url = "https://www.psicologiaviva.com.br/blog/superar-a-depressao/";
                //Intent i = new Intent(Intent.ACTION_VIEW);
                //i.setData(Uri.parse(url));
              //  startActivity(i);

            //    break;
          //  case R.id.Sobre:
                //Sobre
        //        break;
      //      case R.id.Paciente:
    //            Intent intent2 = new Intent(MainActivityListadeMedicos.this, CadastroPaciente.class);
  //              startActivity(intent2);
//                break;

  //              default:
//        }

      //  return super.onOptionsItemSelected(item);
    //}

    //private ArrayList<Medico> adcionarMedicos(){
       // ArrayList<Medico> medicos = new ArrayList<Medico>();
        //Medico m = new Medico("Dr. Henrique Figueiredo","Psicólogo / Psiquiatra","Recife - PE",R.drawable.ic_menu_camera);

        //medicos.add(m);
        //m = new Medico("Dr. Edney Soares","Psiquiatra","Olinda - PE",R.drawable.ic_menu_camera);

        //medicos.add(m);
        //m = new Medico("Dra. Nilziane Ferreira","Psicóloga / Psiquiatra","Jaboatão dos Guararapes - PE",R.drawable.ic_menu_camera);

      // medicos.add(m);
       // m = new Medico("Dr. Arthur Sales","Psiquiatra","Paulista - PE",R.drawable.ic_menu_camera);

     //   medicos.add(m);
     //   m = new Medico("Dra. Andrea Marques","Psicóloga","Caruaru - PE",R.drawable.ic_menu_camera);

       // medicos.add(m);

        //return medicos;


    //}


