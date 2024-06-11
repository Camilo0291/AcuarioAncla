package com.example.acuarioancla0.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.acuarioancla0.entidades.Ventas;

import java.util.ArrayList;


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
    public ArrayList<Ventas> mostrarVentas(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ArrayList<Ventas> listaVentas = new ArrayList<>();
        Ventas venta = null;
        Cursor cursorVentas = null;

        cursorVentas = db.rawQuery("SELECT saleId, saleDate, saleTotal, salePayMethod, saleIdUser, saleIdCustomer FROM " + TABLE_VENTAS, null);

        if (cursorVentas.moveToFirst()) {
            do {
                venta = new Ventas();
               venta.setSaleId(cursorVentas.getInt(0));
                venta.setSaleDate(cursorVentas.getString(1));
                venta.setSaleTotal(cursorVentas.getDouble(2));
                venta.setSalePayMethod(cursorVentas.getString(3));
                venta.setSaleIdUser(cursorVentas.getInt(4));
                venta.setSaleIdCustomer(cursorVentas.getInt(5));


                listaVentas.add(venta);
            } while (cursorVentas.moveToNext());
        }
        cursorVentas.close();
        return listaVentas;
    }

}
