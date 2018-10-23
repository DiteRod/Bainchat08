package com.example.perso.foro;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {
    private static LayoutInflater inflater = null;
    private Context contexto;
    private String[][] datos;
    private String[]Comentarios;
    public Adaptador(Context contexto,String[][] datos){
        this.contexto = contexto;
        this.datos= datos;
        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {

        return datos.length;
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.elemento_lista,null);
        TextView titulo = (TextView)vista.findViewById(R.id.Titulo);
        titulo.setText(datos[i][0]);

        return vista;
    }
}

