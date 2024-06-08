package com.example.acuarioancla0;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class manager extends AppCompatActivity {

    Button btnGoBack;
    TextView txtTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manager);
        btnGoBack = findViewById(R.id.btnGoBack);
        txtTitle = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String buttonIdentifier = intent.getStringExtra("BUTTON_IDENTIFIER");


         //Boton para regresar al menú
        btnGoBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent2 = new Intent(manager.this, Menu.class);
                startActivity(intent2);
            }
        });

      // Identifica cual fue el valor del boton que se presiono
        if (buttonIdentifier != null) {
            switch (buttonIdentifier) {
                case "Customers":
                    txtTitle.setText("Gestionar Clientes");
                    break;
                case "Suppliers":
                    txtTitle.setText("Gestationar Proveedores");
                    break;
                case "Sales":
                    txtTitle.setText("Gestationar Ventas");
                    break;
                case "Shopping":
                    txtTitle.setText("Gestationar Compras");
                    break;
                case "Users":
                    txtTitle.setText("Gestationar Usuarios");
                    break;
                case "Products":
                    txtTitle.setText("Gestationar Productos");
                    break;
            }//fin switch


        }//fin if
    }//fin OnCreate


}
