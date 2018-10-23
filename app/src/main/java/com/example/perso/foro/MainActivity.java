package com.example.perso.foro;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText titulo;
    EditText descripcion;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titulo =(EditText)findViewById(R.id.editText);
        descripcion=(EditText)findViewById(R.id.d4);
    }

    public void GuardarDatos(View view) {
        String Nombre = titulo.getText().toString();
        String Apellido = descripcion.getText().toString();

        BaseHelper basehelper = new BaseHelper(this, "DEMOB", null, 1);
        SQLiteDatabase db01 = basehelper.getWritableDatabase();
        if (db01 != null) {
            ContentValues registronuevo = new ContentValues();
            registronuevo.put("Titulo", Nombre);
            registronuevo.put("Descripcion", Apellido);
            long i = db01.insert("Personas", null, registronuevo);
            if (i > 0) {
                Toast.makeText(this, "Publicado", Toast.LENGTH_SHORT).show();
            }


        }
    }
    public void VerDatos(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }



}
