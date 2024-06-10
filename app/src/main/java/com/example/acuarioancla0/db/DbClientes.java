package com.example.acuarioancla0.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.acuarioancla0.entidades.Clientes;

import java.util.ArrayList;

public class DbClientes extends DbHelper {
    Context context;
    public DbClientes(@Nullable Context context) {
        super(context);
        this.context=context;

    }

    public long insertarCliente(String documentType,String documentNumber,String customerName,String customerLastName, String customerEmail){
        long id =0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            ContentValues values = new ContentValues();
            values.put("documentType", documentType);
            values.put("documentNumber", documentNumber);
            values.put("customerName", customerName);
            values.put("customerLastName", customerLastName);
            values.put("customerEmail", customerEmail);


            id = db.insert(TABLE_CLIENTES, null, values);
        }catch (Exception e){
            e.toString();
        }
        return id;
    }
    public ArrayList<Clientes> mostrarContactos(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();


        ArrayList<Clientes> listaClientes = new ArrayList<>();
        Clientes cliente = null;
        Cursor cursorClientes = null;

        cursorClientes = db.rawQuery("SELECT customerId, customerName, customerLastName, customerEmail, documentNumber FROM " + TABLE_CLIENTES, null);

        if (cursorClientes.moveToFirst()) {
            do {
                cliente = new Clientes();
                cliente.setId(cursorClientes.getInt(0));
                cliente.setCustomerName(cursorClientes.getString(1));
                cliente.setCustomerLastName(cursorClientes.getString(2));
                cliente.setCustomerEmail(cursorClientes.getString(3));
                cliente.setDocumentNumber(cursorClientes.getString(4));
                listaClientes.add(cliente);
            } while (cursorClientes.moveToNext());
        }
        cursorClientes.close();
        return listaClientes;
    }
}
