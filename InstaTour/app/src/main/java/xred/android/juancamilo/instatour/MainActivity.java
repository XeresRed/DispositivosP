package xred.android.juancamilo.instatour;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import xred.android.juancamilo.instatour.Modelos.Administrador;

public class MainActivity extends AppCompatActivity {

    EditText identificacion;
    EditText Contraseña;
    Button btnIngresa;
    Toolbar tool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tool =  findViewById(R.id.tool_bar);

        tool.setTitle("InstaTour");

        setSupportActionBar(tool);

        identificacion = findViewById(R.id.editCorreo);
        Contraseña = findViewById(R.id.editContraseña);
        btnIngresa = findViewById(R.id.button);

        btnIngresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Administrador admin = new Administrador();
                admin.SetBd(v.getContext());

                if (admin.login(identificacion.getText().toString(),Contraseña.getText().toString())){
                    Toast.makeText(v.getContext(),"Hola we :)",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(v.getContext(),"Lo siento we :(",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
