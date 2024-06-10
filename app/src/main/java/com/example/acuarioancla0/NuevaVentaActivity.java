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

import com.example.acuarioancla0.db.DbVentas;

public class NuevaVentaActivity extends AppCompatActivity {
    EditText txtSaleDate,txtSaleTotal,txtSalePayMethod,txtSaleIdUser,txtSaleIdCustomer;
    Button btnVentaRegister,btnGoBack;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_nueva_venta);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            txtSaleDate = findViewById(R.id.txtSaleDate);
            txtSaleTotal = findViewById(R.id.txtSaleTotal);
            txtSalePayMethod = findViewById(R.id.txtSalePayMethod);
            txtSaleIdUser = findViewById(R.id.txtSaleIdUser);
            txtSaleIdCustomer = findViewById(R.id.txtSaleIdCustomer);

            btnVentaRegister = findViewById(R.id.btnProviderRegister);
            btnGoBack = findViewById(R.id.btnGoBack);

            btnVentaRegister.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    DbVentas dbVentas = new DbVentas(NuevaVentaActivity.this);
                    long id = dbVentas.insertarVenta(txtSaleDate.getText().toString(),txtSaleTotal.getText().toString(),txtSalePayMethod.getText().toString(),
                            txtSaleIdUser.getText().toString(),txtSaleIdCustomer.getText().toString());
                    if(id > 0){
                        Toast.makeText(NuevaVentaActivity.this, "Producto Registrado", Toast.LENGTH_SHORT).show();
                        limpiarCampos();
                    }else{
                        Toast.makeText(NuevaVentaActivity.this, "Error al registrar producto", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            btnGoBack.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                    finish();
                }
            });
            btnGoBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        }
    public void limpiarCampos(){
        txtSaleDate.setText("");
        txtSaleTotal.setText("");
        txtSalePayMethod.setText("");
        txtSaleIdUser.setText("");
        txtSaleIdCustomer.setText("");
    }
        }
