package com.example.acuarioancla0.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class DbVentas extends DbHelper {
    Context context;
    public DbVentas(Context context) {
        super(context);
        this.context = context;
    }
    public long insertarVenta(String saleDate,String saleTotal,String salePayMethod,String saleIdUser, String saleIdCustomer){
        long id =0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            ContentValues values = new ContentValues();
            values.put("saleDate", saleDate);
            values.put("saleTotal", saleTotal);
            values.put("salePayMethod", salePayMethod);
            values.put("saleIdUser", saleIdUser);
            values.put("saleIdCustomer", saleIdCustomer);


            id = db.insert(TABLE_VENTAS, null, values);
        }catch (Exception e){
            e.toString();
        }
        return id;
    }

}
