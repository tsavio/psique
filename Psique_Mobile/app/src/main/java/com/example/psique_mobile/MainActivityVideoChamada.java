package com.example.psique_mobile;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import static com.example.psique_mobile.R.drawable.foto_medico;

public class MainActivityVideoChamada extends AppCompatActivity {
    ImageView imageViewFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

        Intent intent = getIntent();

        String parametro =(String) intent.getSerializableExtra("NomeMedico");
        TextView nome = (TextView) findViewById(R.id.txtNome);
        nome.setText(parametro);

        String parametro2 =(String) intent.getSerializableExtra("ProfissaoMedico");
        TextView profissao = (TextView) findViewById(R.id.txtProfissao);
        profissao.setText(parametro2);

        String parametro3 =(String) intent.getSerializableExtra("EnderecoMedico");
        TextView endereco = (TextView) findViewById(R.id.txtEndereco);
        endereco.setText(parametro3);



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }
        imageViewFoto = (ImageView) findViewById(R.id.imageView);
        findViewById(R.id.button_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });

    }
    public void tirarFoto(){

        String url = "https://hangouts.google.com/hangouts/_/raaystieqjdojcqw26iapnwjvye";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
       // Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
       // startActivityForResult(intent, 1);
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
}

