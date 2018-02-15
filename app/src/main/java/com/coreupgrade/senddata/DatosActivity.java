package com.coreupgrade.senddata;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatosActivity extends AppCompatActivity {

    TextView TxtRNombres, TxtRApellidos, TxtRDireccion, TxtRDni, TxtRCelular, TxtRCorreo;
    FloatingActionButton Fbshare;

    List<String> datos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        TxtRNombres = findViewById(R.id.TxtRNombres);
        TxtRApellidos = findViewById(R.id.TxtRApellidos);
        TxtRDni = findViewById(R.id.TxtRDni);
        TxtRDireccion = findViewById(R.id.TxtRDireccion);
        TxtRCelular = findViewById(R.id.TxtRCelular);
        TxtRCorreo = findViewById(R.id.TxtRCorreo);

        Fbshare = findViewById(R.id.Fbshare);

        Intent recibir = getIntent();
        String nombres = "Nombre: "+recibir.getStringExtra("Nombres");
        String apellidos = "Apellido: "+recibir.getStringExtra("Apellidos");
        String dni = "DNI N°: "+recibir.getStringExtra("Dni");
        String direccion = "Domicilio: "+recibir.getStringExtra("Direccion");
        String celular = "Celular: "+recibir.getStringExtra("Celular");
        String correo = "Email: "+recibir.getStringExtra("Correo");

        TxtRApellidos.setText(apellidos);
        TxtRNombres.setText(nombres);
        TxtRDni.setText(dni);
        TxtRDireccion.setText(direccion);
        TxtRCelular.setText(celular);
        TxtRCorreo.setText(correo);

        datos.add(apellidos);
        datos.add(nombres);
        datos.add(dni);
        datos.add(direccion);
        datos.add(celular);
        datos.add(correo);

        Fbshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ishare = new Intent(Intent.ACTION_SEND);
                ishare.setType("text/plain");
                String shareBody = "";
                Iterator iter = datos.iterator();
                while (iter.hasNext())
                    shareBody += iter.next().toString() + "\n";
                String shareSub = "";
                ishare.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                ishare.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(ishare,"Elegir forma de compartir"));
            }
        });
    }
}
