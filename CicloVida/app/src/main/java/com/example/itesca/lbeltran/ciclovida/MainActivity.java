package com.example.itesca.lbeltran.ciclovida;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Información","onCreate()");
        final SwipeRefreshLayout swipeLista = findViewById(R.id.swipe_lista);
        swipeLista.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                String chavo[] = getResources().getStringArray(R.array.roberto_gomez);
                ListView listView = findViewById(R.id.lstv_lista1);
                listView.setAdapter(new ArrayAdapter<String>(
                        MainActivity.this,
                        android.R.layout.simple_list_item_1,chavo));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Log.i("Información","presionaste "+String.valueOf(position));
                    }
                });
                swipeLista.setRefreshing(false);
            }
        });
    }

    public void funcionUno(View view){
        Log.i("Información","Presionaste Botón 1");
        Intent intent = new Intent(MainActivity.this, Formulario.class);
        intent.putExtra("Nombre","José Luis");
        intent.putExtra("Apellido","BelMar");
        intent.putExtra("Edad",40);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        TextView tv1= findViewById(R.id.tv_tv1);
        TextView tv2= findViewById(R.id.tv_tv2);
        TextView tv3= findViewById(R.id.tv_tv3);
        if(requestCode == 1 && resultCode == MainActivity.RESULT_OK){
            String strNombre = data.getExtras().getString("Nombre");
            String strApellido = data.getExtras().getString("Apellido");
            int intEdad = data.getExtras().getInt("Edad");
            String strEdad = String.valueOf(intEdad);
            tv1.setText(strNombre);
            tv2.setText(strApellido);
            tv3.setText(strEdad);
        }
        else if(requestCode == 1 && resultCode == MainActivity.RESULT_CANCELED){
            tv1.setText("Resultado Cancelado");
            tv2.setText("Resultado Cancelado");
            tv3.setText("Resultado Cancelado");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Información","onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Información","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Información","onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Información","onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Información","onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Información","onRestart()");
    }
}
