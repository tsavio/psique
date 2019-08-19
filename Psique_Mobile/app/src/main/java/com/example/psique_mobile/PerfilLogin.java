package com.example.psique_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.core.view.View;

public class PerfilLogin extends AppCompatActivity {

    private TextView txtIdPerfil, txtEmailPerfil;
    private Button btLogout;

    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_login);

        inicializarComponentes();
        eventoClick();

    }

    private void inicializarComponentes() {
        txtIdPerfil = (TextView) findViewById(R.id.txtIdPerfil);
        txtEmailPerfil = (TextView) findViewById(R.id.txtEmailPerfil);
        btLogout = (Button) findViewById(R.id.btLogout);
    }


    private void eventoClick() {
        btLogout.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Conexao.logOut();
                finish();
            }
        });
    }


        @Override
        protected void onStart () {
            super.onStart();
            auth = Conexao.getFirebaseAuth();
            user = Conexao.getFirebaseUser();
            verificaUser();
        }

        private void verificaUser () {
            if (user == null) {
                finish();
            } else {
                txtEmailPerfil.setText("Email: " + user.getEmail());
                txtIdPerfil.setText("Id: " + user.getUid());
            }
        }
    }
