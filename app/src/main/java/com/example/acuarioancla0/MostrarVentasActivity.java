package com.example.acuarioancla0;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acuarioancla0.adaptadores.VentasAdapter;
import com.example.acuarioancla0.db.DbVentas;
import com.example.acuarioancla0.entidades.Ventas;

import java.util.ArrayList;

public class MostrarVentasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mostrar_ventas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recyclerViewVentas = findViewById(R.id.recyclerViewVentas);
        recyclerViewVentas.setLayoutManager(new LinearLayoutManager(this));

        DbVentas dbVentas = new DbVentas(this);
        ArrayList<Ventas> listaVentas = dbVentas.mostrarVentas();

        VentasAdapter adapter = new VentasAdapter(listaVentas);
        recyclerViewVentas.setAdapter(adapter);

    }
}