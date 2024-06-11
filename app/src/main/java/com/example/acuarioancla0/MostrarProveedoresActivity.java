package com.example.acuarioancla0;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acuarioancla0.adaptadores.ProveedoresAdapter;
import com.example.acuarioancla0.db.DbProveedores;
import com.example.acuarioancla0.entidades.Proveedores;

import java.util.ArrayList;

public class MostrarProveedoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mostrar_proveedores);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerViewProveedores = findViewById(R.id.recyclerViewProveedores);
        recyclerViewProveedores.setLayoutManager(new LinearLayoutManager(this));

        DbProveedores dbProveedores = new DbProveedores(this);
        ArrayList<Proveedores> listaProveedores = dbProveedores.mostrarProveedores();

        ProveedoresAdapter adapter = new ProveedoresAdapter(listaProveedores);
        recyclerViewProveedores.setAdapter(adapter);
    }
}