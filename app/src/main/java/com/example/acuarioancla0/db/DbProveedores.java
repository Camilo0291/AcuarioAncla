package com.example.acuarioancla0.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

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
}
