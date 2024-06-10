package com.example.acuarioancla0;

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

import com.example.acuarioancla0.db.DbProveedores;
import com.example.acuarioancla0.db.DbVentas;

public class NuevoProveedorActivity extends AppCompatActivity {
    EditText txtProviderName,txtProviderPhone,txtProviderEmail;
    Button btnProviderRegister,btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nuevo_proveedor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtProviderName = findViewById(R.id.txtProviderName);
        txtProviderPhone = findViewById(R.id.txtProviderPhone);
        txtProviderEmail = findViewById(R.id.txtProviderEmail);

        btnProviderRegister = findViewById(R.id.btnProviderRegister);
        btnGoBack = findViewById(R.id.btnGoBack);

        btnProviderRegister.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbProveedores dbProveedores = new DbProveedores(NuevoProveedorActivity.this);
                long id = dbProveedores.insertarProveedor(txtProviderName.getText().toString(),txtProviderPhone.getText().toString(),
                        txtProviderEmail.getText().toString());
                if(id > 0){
                    Toast.makeText(NuevoProveedorActivity.this, "Producto Registrado", Toast.LENGTH_SHORT).show();
                    limpiarCampos();
                }else{
                    Toast.makeText(NuevoProveedorActivity.this, "Error al registrar producto", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnGoBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
    });
        }
    public void limpiarCampos(){
        txtProviderName.setText("");
        txtProviderPhone.setText("");
        txtProviderEmail.setText("");
    }
}