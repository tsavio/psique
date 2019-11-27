package com.example.psique_mobile;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.psique_mobile.ui.ListAgendamento;


public class MainActivityVideoChamada extends AppCompatActivity {
    ImageView imageViewFoto;
    Button AgendarConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

        Intent intent = getIntent();

        String parametro =(String) intent.getSerializableExtra("NomeMedico");
        TextView nome = findViewById(R.id.txtNome);
        nome.setText(parametro);

        String parametro2 =(String) intent.getSerializableExtra("ProfissaoMedico");
        TextView profissao = findViewById(R.id.txtProfissao);
        profissao.setText(parametro2);

        String parametro3 =(String) intent.getSerializableExtra("EnderecoMedico");
        TextView endereco = findViewById(R.id.txtEndereco);
        endereco.setText(parametro3);



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
        }

        AgendarConsulta = (Button) findViewById(R.id.AgendarConsulta);
        findViewById(R.id.AgendarConsulta).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =  new Intent(MainActivityVideoChamada.this, ListAgendamento.class);
                        startActivity(intent);

                    }
        });



        imageViewFoto = findViewById(R.id.imageView);
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
