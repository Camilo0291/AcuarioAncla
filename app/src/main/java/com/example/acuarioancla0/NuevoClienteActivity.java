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

import com.example.acuarioancla0.db.DbClientes;

public class NuevoClienteActivity extends AppCompatActivity {
    EditText txtCustomerDocumentType,txtCustomerDocumentNumber,txtCustomerName,txtCustomerLastName,txtCustomerEmail;
    Button btnCustomerRegister,btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nuevo_cliente);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtCustomerDocumentType = findViewById(R.id.txtCustomerDocumentType);
        txtCustomerDocumentNumber = findViewById(R.id.txtCustomerDocumentNumber);
        txtCustomerName = findViewById(R.id.txtCustomerName);
        txtCustomerLastName = findViewById(R.id.txtCustomerLastName);
        txtCustomerEmail = findViewById(R.id.txtCustomerEmail);

        btnCustomerRegister = findViewById(R.id.btnCustomerRegister);
        btnGoBack = findViewById(R.id.btnGoBack);

        btnCustomerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbClientes dbCustomers = new DbClientes(NuevoClienteActivity.this);
                long id = dbCustomers.insertarCliente(txtCustomerDocumentType.getText().toString(),txtCustomerDocumentNumber.getText().toString(),
                        txtCustomerName.getText().toString(),txtCustomerLastName.getText().toString(),txtCustomerEmail.getText().toString());
                if(id > 0){
                    Toast.makeText(NuevoClienteActivity.this, "Producto Registrado", Toast.LENGTH_SHORT).show();
                    limpiarCampos();
                }else{
                    Toast.makeText(NuevoClienteActivity.this, "Error al registrar producto", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void limpiarCampos(){

        txtCustomerDocumentType.setText("");
        txtCustomerDocumentNumber.setText("");
        txtCustomerName.setText("");
        txtCustomerLastName.setText("");
        txtCustomerEmail.setText("");
    }
}