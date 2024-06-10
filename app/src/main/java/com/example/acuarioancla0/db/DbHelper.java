package com.example.acuarioancla0.db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "acuario_el_ancla.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_USUARIOS = "usuarios";
    public static final String  TABLE_PRODUCTOS = "productos";
    public static final String  TABLE_VENTAS = "ventas";
    public static final String  TABLE_CLIENTES = "clientes";
    public static final String  TABLE_PROVEEDORES = "proveedores";
    public static final String  TABLE_COMPRAS = "compras";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_USUARIOS+ "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "user TEXT NOT NULL," +
                "password TEXT NOT NULL," +
                "correo_electronico TEXT NOT NULL," +
                "rol TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PRODUCTOS + "(" +
                "productId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "productName TEXT NOT NULL," +
                "productDescription TEXT," +
                "productType TEXT," +
                "productSellPrice REAL," +
                "productBuyPrice REAL," +
                "productAvailable INTEGER)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_VENTAS + "(" +
                "saleId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "saleDate TEXT," +
                "saleTotal REAL," +
                "salePayMethod TEXT," +
                "saleIdUser INTEGER," +
                "saleIdCustomer INTEGER)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CLIENTES + "(" +
                "customerId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "documentType TEXT," +
                "documentNumber TEXT," +
                "customerName TEXT NOT NULL," +
                "customerLastName TEXT NOT NULL," +
                "customerEmail TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PROVEEDORES + "(" +
                "providerId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "providerName TEXT NOT NULL," +
                "providerPhone TEXT," +
                "providerEmail TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_COMPRAS + "(" +
                "purchaseId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "purchaseMethodPay TEXT," +
                "purchaseTotal REAL," +
                "purchaseUserId INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_VENTAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PROVEEDORES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPRAS);

        onCreate(sqLiteDatabase);
    }
}
