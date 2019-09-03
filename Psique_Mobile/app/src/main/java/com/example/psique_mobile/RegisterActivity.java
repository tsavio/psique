package com.example.psique_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtemailregistro,edtpasswordregistro;
    private Button btnregistro,btnvoltarlogin;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        androidx.appcompat.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0e9cf3")));

        inicializarComponentes();
        eventoClick();
    }

    private void eventoClick() {
        btnvoltarlogin.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });
        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtemailregistro.getText().toString().trim();
                String password = edtpasswordregistro.getText().toString().trim();
                criaUser(email,password);
            }
        });
    }

    private void criaUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            alert("Usuario Cadastrdo com Sucesso!");
                            Intent intent = new Intent(RegisterActivity.this, Login.class);
                            startActivity(intent);
                            finish();
                        } else {
                            alert("Usuário Já Cadastrado");

                        }
                    }
                });
    }
     private void alert(String msg){
         Toast.makeText(RegisterActivity.this,msg,Toast.LENGTH_SHORT).show();
     }

    private void inicializarComponentes() {
        edtemailregistro = (EditText) findViewById(R.id.edtemailreset);
        edtpasswordregistro = (EditText) findViewById(R.id.edtpasswordreset);
        btnregistro = (Button) findViewById(R.id.btnresetregistro);
        btnvoltarlogin = (Button) findViewById(R.id.btnvoltarlogin);
       // auth = FirebaseAuth.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();

    }
}
