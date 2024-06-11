package com.example.acuarioancla0;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Manager extends AppCompatActivity {

    Button btnGoBack,btnAnadir,btnMostrar;;
    TextView txtTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manager);
        btnGoBack = findViewById(R.id.btnGoBack);
        txtTitle = findViewById(R.id.textView2);
        btnAnadir = findViewById(R.id.btnAnadir);
        btnMostrar = findViewById(R.id.btnMostrar);
        Intent intent = getIntent();
        String buttonIdentifier = intent.getStringExtra("BUTTON_IDENTIFIER");

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (buttonIdentifier) {
                    case "Customers":
                        Intent intent8 = new Intent(Manager.this, MostrarClientesActivity.class);
                        startActivity(intent8);
                        break;
                    case "Suppliers":
                        Intent intent13 = new Intent(Manager.this, MostrarProveedoresActivity.class);
                        startActivity(intent13);
                        break;
                    case "Sales":
                        Intent intent12 = new Intent(Manager.this, MostrarVentasActivity.class);
                        startActivity(intent12);
                        break;
                    case "Shopping":
                        Intent intent9 = new Intent(Manager.this, MostrarComprasActivity.class);
                        startActivity(intent9);
                        break;
                    case "Users":
                        Intent intent10 = new Intent(Manager.this, MostrarUsuariosActivity.class);
                        startActivity(intent10);
                        break;
                    case "Products":
                        Intent intent11 = new Intent(Manager.this, MostrarProductosActivity.class);
                        startActivity(intent11);
                        break;
                }
            }
                                      });

        // Boton para añadir un registro

        btnAnadir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               switch (buttonIdentifier) {
                   case "Customers":
                       Intent intent2 = new Intent(Manager.this, NuevoClienteActivity.class);
                       startActivity(intent2);
                       break;
                   case "Suppliers":
                        Intent intent3 = new Intent(Manager.this, NuevoProveedorActivity.class);
                        startActivity(intent3);
                        break;
                    case "Sales":
                        Intent intent4 = new Intent(Manager.this, NuevaVentaActivity.class);
                        startActivity(intent4);
                        break;
                    case "Shopping":
                        Intent intent5 = new Intent(Manager.this, NuevaCompraActivity.class);
                        startActivity(intent5);
                        break;
                        case "Users":
                          Intent intent6 = new Intent(Manager.this, NuevoUsuarioActivity.class);
                          startActivity(intent6);
                        break;
                        case "Products":
                        Intent intent7 = new Intent(Manager.this, NuevoProductoActivity.class);
                        startActivity(intent7);
                        break;
               }
            }
            });






         //Boton para regresar al menú
        btnGoBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent2 = new Intent(Manager.this, Menu.class);
                startActivity(intent2);
                finish();
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
protected void onSavedInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    if (savedInstanceState != null) {
        txtTitle.setText(savedInstanceState.getString("TITLE"));
    }
}
protected void onRestoreInsanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null) {

            txtTitle.setText(savedInstanceState.getString("TITLE"));
        }
}

}
