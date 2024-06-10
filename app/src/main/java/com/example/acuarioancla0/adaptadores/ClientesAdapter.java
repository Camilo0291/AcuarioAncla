package com.example.acuarioancla0.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acuarioancla0.R;
import com.example.acuarioancla0.entidades.Clientes;

import java.util.ArrayList;

public class ClientesAdapter extends RecyclerView.Adapter<ClientesAdapter.ClientesViewHolder>{
ArrayList<Clientes> listaClientes;
public ClientesAdapter(ArrayList<Clientes> listaClientes) {
    this.listaClientes = listaClientes;
}
    @NonNull
    @Override
    public ClientesAdapter.ClientesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_cliente, parent, false);

        return new ClientesViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ClientesViewHolder holder, int position) {
        Clientes cliente = listaClientes.get(position);
        holder.viewCustomerName.setText( "Nombre: "+cliente.getCustomerName() + " " + cliente.getCustomerLastName());
        holder.viewDocumentNumber.setText("Número de documento: "+cliente.getDocumentNumber());
        holder.viewCustomerEmail.setText("Email: "+cliente.getCustomerEmail());
    }

    @Override
    public int getItemCount() {
        return listaClientes.size();

    }

    public class ClientesViewHolder extends RecyclerView.ViewHolder {

    TextView viewDocumentNumber,viewCustomerName,viewCustomerEmail;
        public ClientesViewHolder(@NonNull View itemView) {
            super(itemView);

            viewDocumentNumber = itemView.findViewById(R.id.viewDocumentNumber);
            viewCustomerName = itemView.findViewById(R.id.viewCustomerName);
            viewCustomerEmail = itemView.findViewById(R.id.viewCustomerEmail);
        }
    }
}
