package com.example.acuarioancla0.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbCustomers extends DbHelper {
    Context context;
    public DbCustomers(@Nullable Context context) {
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
}
