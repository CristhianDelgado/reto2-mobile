package com.coreupgrade.senddata;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText TxtNombres, TxtApellidos, TxtDni, TxtDireccion, TxtCelular, TxtCorreo;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Inicializa();
        SendDataActivity();
    }

    public void Inicializa() {
        TxtNombres = findViewById(R.id.TxtNombres);
        TxtApellidos = findViewById(R.id.TxtApellidos);
        TxtDni = findViewById(R.id.TxtDni);
        TxtDireccion = findViewById(R.id.TxtDireccion);
        TxtCelular = findViewById(R.id.TxtCelular);
        TxtCorreo = findViewById(R.id.TxtCorreo);

        fab = findViewById(R.id.fab);
    }

    public void SendDataActivity() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DatosActivity.class);

                String nombres,apellidos,dni,direccion,celular,correo;

                nombres = String.valueOf(TxtNombres.getText());
                apellidos = String.valueOf(TxtApellidos.getText());
                dni = String.valueOf(TxtDni.getText());
                direccion = String.valueOf(TxtDireccion.getText());
                celular = String.valueOf(TxtCelular.getText());
                correo = String.valueOf(TxtCorreo.getText());

                i.putExtra("Nombres",nombres);
                i.putExtra("Apellidos",apellidos);
                i.putExtra("Dni",dni);
                i.putExtra("Direccion",direccion);
                i.putExtra("Celular",celular);
                i.putExtra("Correo",correo);

                startActivity(i);
            }
        });
    }
}