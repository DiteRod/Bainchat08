package com.example.perso.foro;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Descripcion extends AppCompatActivity {
    TextView descripcion;
    TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);
        TextView descripcion = (TextView)findViewById(R.id.textView);
        TextView titulo = (TextView)findViewById(R.id.cTitulo);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if(b!=null){
            descripcion.setText(b.getString("IMG"));
            titulo.setText(b.getString("INO"));
        }



    }
}




