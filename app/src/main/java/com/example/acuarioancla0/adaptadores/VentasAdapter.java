package com.example.acuarioancla0.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acuarioancla0.R;
import com.example.acuarioancla0.entidades.Ventas;

import java.util.ArrayList;

public class VentasAdapter extends RecyclerView.Adapter<VentasAdapter.VentasViewHolder> {
    ArrayList<Ventas> listaVentas;

    public VentasAdapter(ArrayList<Ventas> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @NonNull
    @Override
    public VentasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_venta, parent, false);
        return new VentasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VentasViewHolder holder, int position) {
        Ventas venta = listaVentas.get(position);
        holder.viewSaleDate.setText("Fecha de venta: " + venta.getSaleDate());
        holder.viewSaleTotal.setText("Total de venta: " + venta.getSaleTotal());
        holder.viewSalePayMethod.setText("Método de pago: " + venta.getSalePayMethod());
        holder.viewSaleIdUser.setText("ID de usuario: " + venta.getSaleIdUser());
        holder.viewSaleIdCustomer.setText("ID de cliente: " + venta.getSaleIdCustomer());
    }

    @Override
    public int getItemCount() {
        return listaVentas.size();
    }

    public static class VentasViewHolder extends RecyclerView.ViewHolder {
        TextView viewSaleDate, viewSaleTotal, viewSalePayMethod, viewSaleIdUser, viewSaleIdCustomer;

        public VentasViewHolder(@NonNull View itemView) {
            super(itemView);
            viewSaleDate = itemView.findViewById(R.id.viewSaleDate);
            viewSaleTotal = itemView.findViewById(R.id.viewSaleTotal);
            viewSalePayMethod = itemView.findViewById(R.id.viewSalePayMethod);
            viewSaleIdUser = itemView.findViewById(R.id.viewSaleIdUser);
            viewSaleIdCustomer = itemView.findViewById(R.id.viewSaleIdCustomer);
        }
    }
}