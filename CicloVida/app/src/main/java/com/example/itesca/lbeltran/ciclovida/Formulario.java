package com.example.itesca.lbeltran.ciclovida;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Formulario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                EditText etNombre = findViewById(R.id.et_nombre);
                EditText etApellido = findViewById(R.id.et_apellido);
                EditText etEdad = findViewById(R.id.et_edad);
                getIntent().putExtra("Nombre",etNombre.getText().toString());
                getIntent().putExtra("Apellido",etApellido.getText().toString());
                getIntent().putExtra("Edad",Integer.valueOf(etEdad.getText().toString()));
                setResult(Formulario.RESULT_OK,getIntent());
                finish();
            }
        });
        EditText etNombre = findViewById(R.id.et_nombre);
        EditText etApellido = findViewById(R.id.et_apellido);
        EditText etEdad = findViewById(R.id.et_edad);
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("Nombre");
        String apellido = extras.getString("Apellido");
        int edad = extras.getInt("Edad");
        etNombre.setText(nombre);
        etApellido.setText(apellido);
        etEdad.setText(String.valueOf(edad));
    }

}
