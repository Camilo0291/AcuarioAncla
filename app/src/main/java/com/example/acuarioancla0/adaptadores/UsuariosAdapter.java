package com.example.acuarioancla0.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.acuarioancla0.R;
import com.example.acuarioancla0.entidades.Usuarios;

import java.util.ArrayList;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.UsuariosViewHolder> {
    ArrayList<Usuarios> listaUsuarios;

    public UsuariosAdapter(ArrayList<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @NonNull
    @Override
    public UsuariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_usuario, parent, false);
        return new UsuariosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosViewHolder holder, int position) {
        Usuarios usuario = listaUsuarios.get(position);
        holder.viewCompleteName.setText("Nombre completo: " + usuario.getNombre() + " " + usuario.getApellido());
        holder.viewPhone.setText("Teléfono: " + usuario.getTelefono());
        holder.viewEmail.setText("Correo electrónico: " + usuario.getCorreoElectronico());
        holder.viewRole.setText("Rol: " + usuario.getRol());
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public static class UsuariosViewHolder extends RecyclerView.ViewHolder {
        TextView viewCompleteName, viewPhone, viewEmail, viewRole;

        public UsuariosViewHolder(@NonNull View itemView) {
            super(itemView);
            viewCompleteName = itemView.findViewById(R.id.viewCompleteName);
            viewPhone = itemView.findViewById(R.id.viewPhone);
            viewEmail = itemView.findViewById(R.id.viewEmail);
            viewRole = itemView.findViewById(R.id.viewRole);
        }
    }
}
