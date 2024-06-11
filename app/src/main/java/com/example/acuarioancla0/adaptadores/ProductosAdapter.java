package com.example.acuarioancla0.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acuarioancla0.R;
import com.example.acuarioancla0.entidades.Productos;
import com.example.acuarioancla0.entidades.Productos;

import java.util.ArrayList;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductosViewHolder> {
    ArrayList<Productos> listaProductos;

    public ProductosAdapter(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_producto, parent, false);
        return new ProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductosViewHolder holder, int position) {
        Productos producto = listaProductos.get(position);
        holder.viewProductName.setText("Nombre del producto: " + producto.getProductName());
        holder.viewProductDescription.setText("Descripción: " + producto.getProductDescription());
        holder.viewProductSellPrice.setText("Precio de venta: " + producto.getProductSellPrice());
        holder.viewProductBuyPrice.setText("Precio de compra: " + producto.getProductBuyPrice());
        holder.viewProductAvailable.setText("Disponibles: " + producto.getProductAvailable());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public static class ProductosViewHolder extends RecyclerView.ViewHolder {
        TextView viewProductName, viewProductDescription, viewProductSellPrice, viewProductBuyPrice, viewProductAvailable;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);
            viewProductName = itemView.findViewById(R.id.viewProductName);
            viewProductDescription = itemView.findViewById(R.id.viewProductDescription);
            viewProductSellPrice = itemView.findViewById(R.id.viewProductSellPrice);
            viewProductBuyPrice = itemView.findViewById(R.id.viewProductBuyPrice);
            viewProductAvailable = itemView.findViewById(R.id.viewProductAvailable);
        }
    }
}
