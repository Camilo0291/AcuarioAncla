package com.example.acuarioancla0.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acuarioancla0.R;
import com.example.acuarioancla0.entidades.Compras;

import java.util.ArrayList;

public class ComprasAdapter extends RecyclerView.Adapter<ComprasAdapter.ComprasViewHolder> {
    ArrayList<Compras> listaCompras;

    public ComprasAdapter(ArrayList<Compras> listaCompras) {
        this.listaCompras = listaCompras;
    }

    @NonNull
    @Override
    public ComprasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_compra, parent, false);
        return new ComprasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComprasViewHolder holder, int position) {
        Compras compra = listaCompras.get(position);
        holder.viewPurchaseTotal.setText("Total de compra: " + compra.getPurchaseTotal());
        holder.viewPurchaseMethodPay.setText("Método de pago: " + compra.getPurchaseMethodPay());
        holder.viewPurchaseUserId.setText("ID del usuario que realizó la compra: " + compra.getPurchaseUserId());
    }

    @Override
    public int getItemCount() {
        return listaCompras.size();
    }

    public static class ComprasViewHolder extends RecyclerView.ViewHolder {
        TextView viewPurchaseTotal, viewPurchaseMethodPay, viewPurchaseUserId;

        public ComprasViewHolder(@NonNull View itemView) {
            super(itemView);
            viewPurchaseTotal = itemView.findViewById(R.id.viewPurchaseTotal);
            viewPurchaseMethodPay = itemView.findViewById(R.id.viewPurchaseMethodPay);
            viewPurchaseUserId = itemView.findViewById(R.id.viewPurchaseUserId);
        }
    }
}
