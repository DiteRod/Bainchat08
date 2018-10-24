package com.example.perso.foro;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {
    String[][] arreglo;
    ListView Lista;
    protected Object mActionMode;
    public int selectedItem = -1;
    int cantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);/*hola*/
        setContentView(R.layout.activity_main2);
        Lista = (ListView) findViewById(R.id.lista);
        cargar();
        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(),Descripcion.class);
                visorDetalles.putExtra("IMG",arreglo[position][1]);
                visorDetalles.putExtra("INO",arreglo[position][0]);
                startActivity(visorDetalles);
            }
        });

    }

    public void cargar() {
        BaseHelper basehelper = new BaseHelper(this, "DEMOB", null, 1);
        SQLiteDatabase db01 = basehelper.getReadableDatabase();
        if (db01 != null) {
            Cursor c = db01.rawQuery("select * from Personas", null);
            cantidad = c.getCount();
            int i = 0;
            arreglo = new String[cantidad][2];
            if (c.moveToFirst()) {
                do {
                    arreglo[i][0]= c.getString(0);
                    arreglo[i][1]= c.getString(1);
                    i++;
                } while (c.moveToNext());
            }
            Lista.setAdapter(new Adaptador(this,arreglo));
        }
    }
}
