package com.example.acuarioancla0;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    Button btnCustomers, btnSuppliers, btnSales, btnShopping, btnUsers, btnProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        btnCustomers = findViewById(R.id.btnCustomers);
        btnSuppliers = findViewById(R.id.btnSuppliers);
        btnSales = findViewById(R.id.btnSales);
        btnShopping = findViewById(R.id.btnShopping);
        btnUsers = findViewById(R.id.btnUsers);
        btnProducts = findViewById(R.id.btnProducts);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarActividad(manager.class);
            }
        };

        btnCustomers.setOnClickListener(onClickListener);
        btnSuppliers.setOnClickListener(onClickListener);
        btnSales.setOnClickListener(onClickListener);
        btnShopping.setOnClickListener(onClickListener);
        btnUsers.setOnClickListener(onClickListener);
        btnProducts.setOnClickListener(onClickListener);
    }

    private void iniciarActividad(Class<?> claseDestino) {
        Intent intent = new Intent(Menu.this, claseDestino);
        startActivity(intent);
    }
}
