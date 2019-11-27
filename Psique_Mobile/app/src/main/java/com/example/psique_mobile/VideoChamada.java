package com.example.psique_mobile;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class VideoChamada extends AppCompatActivity {
    ImageView imageViewFoto;
    RatingBar ratingBar;
    TextView txtNome, txtProfissao,txtTelefone;
    String teste = null;
    Button button_agendamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_chamada);

        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));


        imageViewFoto = (ImageView) findViewById(R.id.imageView);
        txtNome = (TextView)findViewById (R.id.txtNome);
        txtProfissao = (TextView)findViewById (R.id.txtProfissao);
        txtTelefone = (TextView)findViewById (R.id.txtTelefone);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        button_agendamento = (Button)findViewById(R.id.button_agendamento);


//        teste=getIntent().getStringExtra("Name");
//        txtNome.setText("DR:"+ teste);
//        teste=getIntent().getStringExtra("Phone");
//        txtTelefone.setText("Phone:"+ teste);
//        teste=getIntent().getStringExtra("Specialty");
//        txtProfissao.setText("Especialidade:" + teste);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }


        findViewById(R.id.button_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });

        button_agendamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(VideoChamada.this,ListAgendamento.class);
                startActivity(intent);
            }
        });



    }




    private void tirarFoto() {

        String url = "https://hangouts.google.com/hangouts/_/raaystieqjdojcqw26iapnwjvye";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
        chamarAvaliacao();
    }

    private void chamarAvaliacao() {
        AlertDialog.Builder builder = new AlertDialog.Builder(VideoChamada.this);
        View layout= null;
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = inflater.inflate(R.layout.ratingbar, null);
        final RatingBar ratingBar = (RatingBar)layout.findViewById(R.id.ratingBar);
        builder.setTitle("Avalie seu Atendimento");
        builder.setMessage("Dê uma Nota para o seu Médico. Sua Avaliação é muito importante e vai nos ajudar a melhorar nosso serviço .");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Float value = ratingBar.getRating();
                Toast.makeText(VideoChamada.this,"A classificação é : "+value,Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Não, Obrigado", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.setView(layout);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.perfil){
            Intent intent = new Intent(VideoChamada.this, MainActivityPerfilPaciente.class);
            startActivity(intent);
        }
        if (id == R.id.Blog){
            String url = "https://www.psicologiaviva.com.br/blog/superar-a-depressao/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        if (id == R.id.Sobre){
            //sobre
        }
        if (id == R.id.Agendamento){
            Intent intent2 = new Intent(VideoChamada.this, ListAgendamento.class);
                startActivity(intent2);
        }



        return super.onOptionsItemSelected(item);
    }
}
