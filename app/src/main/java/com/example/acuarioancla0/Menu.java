package com.example.acuarioancla0;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;

import com.example.acuarioancla0.db.DbHelper;


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
                String buttonIdentifier = "";
                if (v.getId() == R.id.btnCustomers) {
                    buttonIdentifier = "Customers";
                } else if (v.getId() == R.id.btnSuppliers) {
                    buttonIdentifier = "Suppliers";
                } else if (v.getId() == R.id.btnSales) {
                    buttonIdentifier = "Sales";
                } else if (v.getId() == R.id.btnShopping) {
                    buttonIdentifier = "Shopping";
                } else if (v.getId() == R.id.btnUsers) {
                    buttonIdentifier = "Users";
                } else if (v.getId() == R.id.btnProducts) {
                    buttonIdentifier = "Products";
                }
                iniciarActividad(Manager.class, buttonIdentifier);
            }
        };

        btnCustomers.setOnClickListener(onClickListener);
        btnSuppliers.setOnClickListener(onClickListener);
        btnSales.setOnClickListener(onClickListener);
        btnShopping.setOnClickListener(onClickListener);
        btnUsers.setOnClickListener(onClickListener);
        btnProducts.setOnClickListener(onClickListener);
    }

    private void iniciarActividad(Class<?> claseDestino, String buttonIdentifier) {
        Intent intent = new Intent(Menu.this, claseDestino);
        intent.putExtra("BUTTON_IDENTIFIER", buttonIdentifier);
        startActivity(intent);
    }
}