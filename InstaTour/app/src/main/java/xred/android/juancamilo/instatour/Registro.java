package xred.android.juancamilo.instatour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class Registro extends AppCompatActivity {

    EditText identificacion;
    EditText CorreoE;
    Spinner tipo;
    EditText Contraseña;
    Button btnRegistra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        tipo = (Spinner)findViewById(R.id.tipo_spinner);

      ArrayAdapter<CharSequence>  Adapter = ArrayAdapter.createFromResource(this,R.array.tipo, android.R.layout.simple_spinner_item);
      tipo.setAdapter(Adapter);
    }
}
