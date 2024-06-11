package com.example.acuarioancla0.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.acuarioancla0.entidades.Clientes;
import com.example.acuarioancla0.entidades.Compras;

import java.util.ArrayList;

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
    public ArrayList<Compras> mostrarCompras(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();


        ArrayList<Compras> listaCompras = new ArrayList<>();
       Compras compra = null;
        Cursor cursorCompras = null;

        cursorCompras = db.rawQuery("SELECT purchaseId, purchaseMethodPay, purchaseTotal, purchaseUserId FROM " + TABLE_COMPRAS, null);

        if (cursorCompras.moveToFirst()) {
            do {
                compra = new Compras();
                compra.setId(cursorCompras.getInt(0));
                compra.setPurchaseMethodPay(cursorCompras.getString(1));
                compra.setPurchaseTotal(cursorCompras.getString(2));
                compra.setPurchaseUserId(cursorCompras.getString(3));

                listaCompras.add(compra);
            } while (cursorCompras.moveToNext());
        }
        cursorCompras.close();
        return listaCompras;
    }
}
