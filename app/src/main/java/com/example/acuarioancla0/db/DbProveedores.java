package com.example.acuarioancla0.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.acuarioancla0.entidades.Proveedores;

import java.util.ArrayList;

public class DbProveedores extends DbHelper{
    Context context;
    public DbProveedores(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarProveedor(String providerName,String providerPhone,String providerEmail){
        long id =0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            ContentValues values = new ContentValues();
            values.put("providerName", providerName);
            values.put("providerPhone", providerPhone);
            values.put("providerEmail", providerEmail);


            id = db.insert(TABLE_PROVEEDORES, null, values);
        }catch (Exception e){
            e.toString();
        }
        return id;
    }
    public ArrayList<Proveedores> mostrarProveedores(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ArrayList<Proveedores> listaProveedores = new ArrayList<>();
        Proveedores proveedor = null;
        Cursor cursorProveedores = null;

        cursorProveedores = db.rawQuery("SELECT providerId, providerName, providerPhone, providerEmail FROM " + TABLE_PROVEEDORES, null);

        if (cursorProveedores.moveToFirst()) {
            do {
                proveedor = new Proveedores();
                proveedor.setProviderId(cursorProveedores.getInt(0));
                proveedor.setProviderName(cursorProveedores.getString(1));
                proveedor.setProviderPhone(cursorProveedores.getString(2));
                proveedor.setProviderEmail(cursorProveedores.getString(3));

                listaProveedores.add(proveedor);
            } while (cursorProveedores.moveToNext());
        }
        cursorProveedores.close();
        return listaProveedores;
    }

}
