package xred.android.juancamilo.instatour.Modelos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import xred.android.juancamilo.instatour.Conexion.Connection;

public class Administrador {
    private static final String TAG = "error";
    String Id;
    String Correo;
    String tipo;
    String Contraseña;
    Connection conexion ;


    public Administrador(){
        Id = "";
        Correo = "";
        tipo = "";
        Contraseña = "";
    }

    public void SetBd(Context c){
        conexion = new Connection(c, "instatour",null,1);
    }

    public void SetDataAdmin(String id,String Email, String Name, String pass){
        Id = id;
        Correo = Email;
        tipo = Name;
        Contraseña = pass;
    }

    public boolean login(String id, String pass){
        boolean log = false;

        try{
            SQLiteDatabase db = conexion.getReadableDatabase();
            Cursor cur = db.rawQuery("SELECT id,CorreoU , Tipo , Contraseña FROM Admin WHERE CorreoU = '" + id +"' AND Contraseña = '" + pass + "'",null);

            if(cur.moveToFirst()){

                log = true;
                Id =cur.getString(0);
                Correo = cur.getString(1);
                tipo = cur.getString(2);
                Contraseña = cur.getString(3);

            }
            db.close();

        }catch (Exception e){
            Log.e(TAG,"CARGA" + e.getMessage());
        }
        return log;
    }

    public void registro (String id, String email, String password, String tipo){
        SQLiteDatabase db = conexion.getWritableDatabase();
        Log.e(TAG,"lOS DATOS SON: " + id + " - " + email+ " - " + password + " - "+ tipo);
        final String query = "INSERT INTO Admin (id,CorreoU , Tipo , Contraseña ) VALUES ('" + id + "', '" + email+ "', '"+ tipo +"', '"+ password +"' )";
        db.execSQL(query);
        db.close();

    }


}
