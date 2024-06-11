package com.example.acuarioancla0.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acuarioancla0.R;
import com.example.acuarioancla0.entidades.Proveedores;

import java.util.ArrayList;

public class ProveedoresAdapter extends RecyclerView.Adapter<ProveedoresAdapter.ProveedoresViewHolder> {
    ArrayList<Proveedores> listaProveedores;

    public ProveedoresAdapter(ArrayList<Proveedores> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    @NonNull
    @Override
    public ProveedoresViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_proveedores, parent, false);
        return new ProveedoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProveedoresViewHolder holder, int position) {
        Proveedores proveedor = listaProveedores.get(position);
        holder.viewProviderName.setText("Nombre del proveedor: " + proveedor.getProviderName());
        holder.viewProviderPhone.setText("Teléfono: " + proveedor.getProviderPhone());
        holder.viewProviderEmail.setText("Correo electrónico: " + proveedor.getProviderEmail());
    }

    @Override
    public int getItemCount() {
        return listaProveedores.size();
    }

    public static class ProveedoresViewHolder extends RecyclerView.ViewHolder {
        TextView viewProviderName, viewProviderPhone, viewProviderEmail;

        public ProveedoresViewHolder(@NonNull View itemView) {
            super(itemView);
            viewProviderName = itemView.findViewById(R.id.viewProviderName);
            viewProviderPhone = itemView.findViewById(R.id.viewProviderPhone);
            viewProviderEmail = itemView.findViewById(R.id.viewProviderEmail);
        }
    }
}
