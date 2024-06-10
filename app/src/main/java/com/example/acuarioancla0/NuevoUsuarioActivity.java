package com.example.acuarioancla0;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.acuarioancla0.db.DbUsuarios;


public class NuevoUsuarioActivity extends AppCompatActivity {

    EditText txtUserName, txtUserLastName, txtUserPhone, txtUserUser, txtUserPassword, txtUserEmail, txtRolUser;;
    Button btnUserRegister,btnGoBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nuevo_usuario);
        Intent intent = getIntent();
        String buttonIdentifier = intent.getStringExtra("BUTTON_IDENTIFIER");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtUserName = findViewById(R.id.txtUserName);
        txtUserLastName = findViewById(R.id.txtUserLastName);
        txtUserPhone = findViewById(R.id.txtUserPhone);
        txtUserUser = findViewById(R.id.txtUserUser);
        txtUserPassword = findViewById(R.id.txtUserPassword);
        txtUserEmail = findViewById(R.id.txtUserEmail);
        txtRolUser = findViewById(R.id.txtRolUser);

        btnUserRegister= findViewById(R.id.btnProductRegister);
        btnGoBack = findViewById(R.id.btnGoBack);


        btnUserRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbUsuarios dbUser = new DbUsuarios(NuevoUsuarioActivity.this);
                long id = dbUser.insertarUsuario(txtUserName.getText().toString(), txtUserLastName.getText().toString(), txtUserPhone.getText().toString()
                        , txtUserUser.getText().toString(), txtUserPassword.getText().toString(), txtUserEmail.getText().toString(), txtRolUser.getText().toString());
                if (id > 0) {
                    Toast.makeText(NuevoUsuarioActivity.this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
                    limpiarCampos();
                } else {
                    Toast.makeText(NuevoUsuarioActivity.this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
                }

            }
        }); // <-- Added closing brace here


        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
    }
        });
    }
    public void limpiarCampos(){
        txtUserName.setText("");
        txtUserLastName.setText("");
        txtUserPhone.setText("");
        txtUserUser.setText("");
        txtUserPassword.setText("");
        txtUserEmail.setText("");
        txtRolUser.setText("");
    }
}





