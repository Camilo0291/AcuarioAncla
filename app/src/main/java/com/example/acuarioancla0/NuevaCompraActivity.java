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

import com.example.acuarioancla0.db.DbCompras;
import com.example.acuarioancla0.db.DbProveedores;

public class NuevaCompraActivity extends AppCompatActivity {
    EditText txtPurchaseMethodPay,txtPurchaseTotal,txtPurchaseUserId;
    Button btnPurchaseRegister,btnGoBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nueva_compra);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtPurchaseMethodPay = findViewById(R.id.txtPurchaseMethodPay);
        txtPurchaseTotal = findViewById(R.id.txtPurchaseTotal);
        txtPurchaseUserId = findViewById(R.id.txtPurchaseUserId);

        btnPurchaseRegister = findViewById(R.id.btnPurchaseRegister);
        btnGoBack = findViewById(R.id.btnGoBack);

        btnPurchaseRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DbCompras dbCompras = new DbCompras(NuevaCompraActivity.this);
                long id = dbCompras.insertarCompra(txtPurchaseMethodPay.getText().toString(), txtPurchaseTotal.getText().toString(), txtPurchaseUserId.getText().toString());
                if (id > 0) {
                    Toast.makeText(NuevaCompraActivity.this, "Producto Registrado", Toast.LENGTH_SHORT).show();
                    limpiarCampos();
                } else {
                    Toast.makeText(NuevaCompraActivity.this, "Error al registrar producto", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void limpiarCampos() {
        txtPurchaseMethodPay.setText("");
        txtPurchaseTotal.setText("");
        txtPurchaseUserId.setText("");
    }
}