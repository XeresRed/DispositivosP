package xred.android.juancamilo.instatour;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import xred.android.juancamilo.instatour.Conexion.Connection;
import xred.android.juancamilo.instatour.Modelos.Administrador;

public class Registro extends AppCompatActivity {

    EditText identificacion;
    EditText CorreoE;
    Spinner Tipo;
    EditText Contraseña;
    Button btnRegistra;
    Connection conexion ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Tipo = (Spinner)findViewById(R.id.tipo_spinner);

      ArrayAdapter<CharSequence>  Adapter = ArrayAdapter.createFromResource(this,R.array.tipo, android.R.layout.simple_spinner_item);
      Tipo.setAdapter(Adapter);

        btnRegistra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Administrador admin = new Administrador();

                String id = identificacion.getText().toString();
                String email = CorreoE.getText().toString();
                String password = Contraseña.getText().toString();

                admin.registro(id, email,password);

                Toast.makeText(v.getContext(),"Usuario Registrado",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
