package com.example.acuarioancla0.db;
import android.content.ContentValues;
import  android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.acuarioancla0.entidades.Compras;
import com.example.acuarioancla0.entidades.Usuarios;

import java.util.ArrayList;

public class DbUsuarios extends DbHelper{
    Context context;
public DbUsuarios(Context context){
    super(context);
    this.context=context;
}
public long insertarUsuario(String nombre,String apellido,String telefono,String correo_electronico, String user, String password, String rol){
  long id =0;
   try {
       DbHelper dbHelper = new DbHelper(context);
       SQLiteDatabase db = dbHelper.getReadableDatabase();

       ContentValues values = new ContentValues();
       values.put("nombre", nombre);
       values.put("apellido", apellido);
       values.put("telefono", telefono);
       values.put("correo_electronico", correo_electronico);
       values.put("user", user);
       values.put("password", password);
       values.put("rol", rol);

        id = db.insert(TABLE_USUARIOS, null, values);
   }catch (Exception e){
       e.toString();
   }
    return id;
}
    public ArrayList<Usuarios> mostrarUsuarios(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();


        ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
        Usuarios usuario = null;
        Cursor cursorUsuarios = null;

        cursorUsuarios = db.rawQuery("SELECT id, nombre, apellido, telefono, correo_electronico,rol FROM " + TABLE_USUARIOS, null);

        if (cursorUsuarios.moveToFirst()) {
            do {
                usuario = new Usuarios();
                usuario.setId(cursorUsuarios.getInt(0));
                usuario.setNombre(cursorUsuarios.getString(1));
                usuario.setApellido(cursorUsuarios.getString(2));
                usuario.setTelefono(cursorUsuarios.getString(3));
                usuario.setCorreoElectronico(cursorUsuarios.getString(4));
                usuario.setRol(cursorUsuarios.getString(5));

                listaUsuarios.add(usuario);
            } while (cursorUsuarios.moveToNext());
        }
        cursorUsuarios.close();
        return listaUsuarios;
    }

}

