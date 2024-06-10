package com.example.acuarioancla0.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbProductos extends DbHelper{

    Context context;
    public DbProductos(@Nullable Context context) {
        super(context);
        this.context=context;

    }

    public long insertarProducto(String productName,String productDescription,String productType,String productSellPrice, String productBuyPrice, String productAvailable){
        long id =0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            ContentValues values = new ContentValues();
            values.put("productName", productName);
            values.put("productDescription", productDescription);
            values.put("productType", productType);
            values.put("productSellPrice", productSellPrice);
            values.put("productBuyPrice", productBuyPrice);
            values.put("productAvailable", productAvailable);

            id = db.insert(TABLE_PRODUCTOS, null, values);
        }catch (Exception e){
            e.toString();
        }
        return id;
    }
}
