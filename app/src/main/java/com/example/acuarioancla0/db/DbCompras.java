package com.example.acuarioancla0.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbCompras extends  DbHelper{
Context context;
    public DbCompras(@Nullable Context context) {

        super(context);
        this.context = context;
    }
    public long insertarCompra(String purchaseMethodPay,String purchaseTotal,String purchaseUserId){
        long id =0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            ContentValues values = new ContentValues();
            values.put("purchaseMethodPay", purchaseMethodPay);
            values.put("purchaseTotal", purchaseTotal);
            values.put("purchaseUserId", purchaseUserId);


            id = db.insert(TABLE_COMPRAS, null, values);
        }catch (Exception e){
            e.toString();
        }
        return id;
    }
}
