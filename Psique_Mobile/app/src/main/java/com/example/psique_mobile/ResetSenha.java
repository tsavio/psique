    package com.example.psique_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

    public class ResetSenha extends AppCompatActivity {

    private EditText edtemailreset;
    private Button btnresetregistro;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_senha);
        inicializarComponentes();
        eventoClick();

    }

        private void eventoClick() {
        btnresetregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtemailreset.getText().toString().trim();
                resetSenha(email);
            }
        });
        }

        private void resetSenha(String email) {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(ResetSenha.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            alert("Um E-mail foi enviado para alterar sua senha");
                            finish();
                        }else {
                            alert("Email nao Encontrado");
                        }

                    }
                });
        }


        private void alert(String s) {
            Toast.makeText(ResetSenha.this,s,Toast.LENGTH_SHORT);
        }

        private void inicializarComponentes() {
          edtemailreset = (EditText) findViewById(R.id.edtemailreset);
          btnresetregistro = (Button) findViewById(R.id.btnresetregistro);
        }

        @Override
        protected void onStart() {
            super.onStart();
            auth = Conexao.getFirebaseAuth();
        }
    }

