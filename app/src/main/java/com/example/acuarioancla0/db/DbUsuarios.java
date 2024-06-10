package com.example.acuarioancla0.db;
import android.content.ContentValues;
import  android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

}

