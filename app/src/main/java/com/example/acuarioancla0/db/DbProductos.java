package com.example.acuarioancla0.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.acuarioancla0.entidades.Productos;
import com.example.acuarioancla0.entidades.Usuarios;

import java.util.ArrayList;

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
    public ArrayList<Productos> mostrarProductos(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();


        ArrayList<Productos> listaProductos = new ArrayList<>();
        Productos producto = null;
        Cursor cursorProducto = null;

        cursorProducto = db.rawQuery("SELECT productId, productName, productDescription, productSellPrice, productBuyPrice,productAvailable FROM " + TABLE_PRODUCTOS, null);

        if (cursorProducto.moveToFirst()) {
            do {
                producto = new Productos();
                producto.setProductId(cursorProducto.getInt(0));
                producto.setProductName(cursorProducto.getString(1));
                producto.setProductDescription(cursorProducto.getString(2));
                producto.setProductSellPrice(cursorProducto.getString(3));
                producto.setProductBuyPrice(cursorProducto.getString(4));
                producto.setProductAvailable(cursorProducto.getInt(5));

                listaProductos.add(producto);
            } while (cursorProducto.moveToNext());
        }
        cursorProducto.close();
        return listaProductos;
    }
}
