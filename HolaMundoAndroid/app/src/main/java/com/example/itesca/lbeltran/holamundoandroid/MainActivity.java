package com.example.itesca.lbeltran.holamundoandroid;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean estado = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);
    }

    public void funcionUno(View v){
        TextView tv_uno = (TextView) findViewById(R.id.tv_uno);
        estado = !estado;
        tv_uno.setAllCaps(estado);
    }
    public void funcionDos(View v){
        Context context = getApplicationContext();
        CharSequence text = "Presionaste boton 2";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void funcionTres(View v){
        CharSequence text = "Presionaste boton 2";
        int duration = Snackbar.LENGTH_LONG;
        Snackbar.make(v,text,duration).show();
    }
}
