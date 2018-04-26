package xred.android.juancamilo.instatour.Modelos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import xred.android.juancamilo.instatour.Conexion.Connection;

public class Usuario {

    private static final String TAG = "error";
    private String Correo;
    private String Nombre;
    private String Contraseña;
    Connection conexion ;
    List<Usuario> usuarios = null;
    
    
    public Usuario(){
        Correo = "";
        Nombre = "";
        Contraseña = "";
    }

    public void SetBd(Context c){
        conexion = new Connection(c, "instatour",null,1);
    }

    public void setNombre(String name){
        Nombre = name;
    }


    public void setContraseña(String pass) {
        Contraseña = pass;
    }

    public void setCorreo(String email) {
        Correo = email;
    }

    public String getNombre(){
        return Nombre;
    }


    public String getContraseña() {
        return Contraseña;
    }

    public String getCorreo() {
        return Correo;
    }

    public List<Usuario> traeUsuario(){

        try{
            SQLiteDatabase db = conexion.getReadableDatabase();
            Cursor cur = db.rawQuery("SELECT *  FROM usuario ",null);

            if(cur.moveToFirst()){
                usuarios = new ArrayList<>();
                do{

                    Usuario persona = new Usuario();

                    persona.setCorreo(cur.getString(0));
                    persona.setNombre(cur.getString(1));
                    persona.setContraseña(cur.getString(2));

                    usuarios.add(persona);


                    Log.v(TAG,"ACTIVIDAD TRAE Nombre " + persona.getNombre() + "\n Contraseña " + persona.getContraseña() + "\n Correo " + persona.getCorreo());

                }while (cur.moveToNext());

            }
            db.close();

        }catch (Exception e){
            Log.e(TAG,"CARGA" + e.getMessage());
        }
        return usuarios;
    }
}
