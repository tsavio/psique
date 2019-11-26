package com.example.psique_mobile;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityVideoChamada extends AppCompatActivity {
    ImageView imageViewFoto;
    RatingBar ratingBar;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseAvaliacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

        Intent intent = getIntent();


//        String parametro =(String) intent.getSerializableExtra("NomeMedico");
//        TextView nome = findViewById(R.id.txtNome);
//        nome.setText(parametro);

//        String parametro2 =(String) intent.getSerializableExtra("CRM");
//        TextView profissao = findViewById(R.id.txtProfissao);
//        profissao.setText(parametro2);
//
//        String parametro3 =(String) intent.getSerializableExtra("Phone");
//        TextView endereco = findViewById(R.id.txtEndereco);
//        endereco.setText(parametro3);

        inicializarFirebase();



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
        imageViewFoto = findViewById(R.id.imageView);
        findViewById(R.id.button_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });

    }




    private void inicializarFirebase() {
        FirebaseApp.initializeApp(MainActivityVideoChamada.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseAvaliacao = firebaseDatabase.getReference();
    }

    public void tirarFoto(){

        String url = "https://hangouts.google.com/hangouts/_/raaystieqjdojcqw26iapnwjvye";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
        chamarAvaliacao();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imagem = (Bitmap) extras.get("data");
            imageViewFoto.setImageBitmap(imagem);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

public void chamarAvaliacao(){



    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityVideoChamada.this);
    View layout= null;
    LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    layout = inflater.inflate(R.layout.ratingbar, null);
    final RatingBar ratingBar = (RatingBar)layout.findViewById(R.id.ratingBar);
    builder.setTitle("Avalie seu Atendimento");
    builder.setMessage("Dê uma Nota para o seu Médico. Sua Avaliação é muito importante e vai nos ajudar a melhorar nosso serviço .");
    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            Float value = ratingBar.getRating();
            Toast.makeText(MainActivityVideoChamada.this,"A classificação é : "+value,Toast.LENGTH_LONG).show();
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





}
