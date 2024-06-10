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

import com.example.acuarioancla0.db.DbProductos;

public class NuevoProductoActivity extends AppCompatActivity {
    EditText txtProductName,txtProductDescription,txtProductType,txtProductSellPrice,txtProductBuyPrice,txtProductAvailable;
    Button btnProductRegister,btnGoBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nuevo_producto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtProductName = findViewById(R.id.txtProductName);
        txtProductDescription = findViewById(R.id.txtProductDescription);
        txtProductType = findViewById(R.id.txtProductType);
        txtProductSellPrice = findViewById(R.id.txtProductSellPrice);
        txtProductBuyPrice = findViewById(R.id.txtProductBuyPrice);
        txtProductAvailable = findViewById(R.id.txtProductAvailable);

        btnProductRegister = findViewById(R.id.btnProductRegister);
        btnGoBack = findViewById(R.id.btnGoBack);

        btnProductRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbProductos dbProductos = new DbProductos(NuevoProductoActivity.this);
                long id = dbProductos.insertarProducto(txtProductName.getText().toString(),txtProductDescription.getText().toString(),txtProductType.getText().toString(),
                        txtProductSellPrice.getText().toString(),txtProductBuyPrice.getText().toString(),txtProductAvailable.getText().toString());
                if(id > 0){
                    Toast.makeText(NuevoProductoActivity.this, "Producto Registrado", Toast.LENGTH_SHORT).show();
                    limpiarCampos();
                }else{
                    Toast.makeText(NuevoProductoActivity.this, "Error al registrar producto", Toast.LENGTH_SHORT).show();
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
    public void limpiarCampos(){
        txtProductName.setText("");
        txtProductDescription.setText("");
        txtProductType.setText("");
        txtProductSellPrice.setText("");
        txtProductBuyPrice.setText("");
        txtProductAvailable.setText("");
    }
}