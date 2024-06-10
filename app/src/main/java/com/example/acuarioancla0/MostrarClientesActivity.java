package com.example.acuarioancla0;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acuarioancla0.adaptadores.ClientesAdapter;
import com.example.acuarioancla0.db.DbClientes;
import com.example.acuarioancla0.entidades.Clientes;

import java.util.ArrayList;

public class MostrarClientesActivity extends AppCompatActivity {
RecyclerView recyclerViewClientes;
ArrayList<Clientes> listaClientes;
DbClientes dbClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mostrar_clientes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerViewClientes = findViewById(R.id.recyclerViewClientes);
        recyclerViewClientes.setLayoutManager(new LinearLayoutManager(this));

        dbClientes = new DbClientes(this);
        listaClientes = dbClientes.mostrarContactos();

        ClientesAdapter adapter = new ClientesAdapter(listaClientes);
        recyclerViewClientes.setAdapter(adapter);

    }
}