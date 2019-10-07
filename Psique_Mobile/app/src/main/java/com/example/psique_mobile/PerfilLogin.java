package com.example.psique_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PerfilLogin extends AppCompatActivity {

    private TextView txtIdPerfil, txtEmailPerfil;
    private Button btLogout;

    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_login);

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
                Connection.logOut();
                finish();
            }
        });
    }


        @Override
        protected void onStart () {
            super.onStart();
            auth = Connection.getFirebaseAuth();
            user = Connection.getFirebaseUser();
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
