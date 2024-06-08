package com.example.acuarioancla0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registro extends AppCompatActivity {

    Button btnRegister;
    EditText txtEmailRegister, txtPassRegister, txtConfirmPass;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();
        txtEmailRegister = findViewById(R.id.txtEmailRegister);
        txtPassRegister = findViewById(R.id.txtPassRegister);
        txtConfirmPass = findViewById(R.id.txtConfirmPass);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmailRegister.getText().toString().trim();
                String password = txtPassRegister.getText().toString().trim();
                String confirmPassword = txtConfirmPass.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(Registro.this, "Por favor ingrese todos los datos", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(email, password, confirmPassword);
                }
            }
        });
    }

    private void loginUser(String email, String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            Toast.makeText(Registro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(Registro.this, Menu.class));
                            Toast.makeText(Registro.this, "BIENVENIDO", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Registro.this, "Error al iniciar sesión: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

