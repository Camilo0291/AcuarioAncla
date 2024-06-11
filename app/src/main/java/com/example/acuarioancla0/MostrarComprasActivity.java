package com.example.acuarioancla0;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acuarioancla0.adaptadores.ComprasAdapter;
import com.example.acuarioancla0.db.DbCompras;
import com.example.acuarioancla0.entidades.Compras;

import java.util.ArrayList;

public class MostrarComprasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mostrar_compras);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerViewCompras = findViewById(R.id.recyclerViewCompras);
        recyclerViewCompras.setLayoutManager(new LinearLayoutManager(this));

        DbCompras dbCompras = new DbCompras(this);
        ArrayList<Compras> listaCompras = dbCompras.mostrarCompras();

        ComprasAdapter adapter = new ComprasAdapter(listaCompras);
        recyclerViewCompras.setAdapter(adapter);
    }
}