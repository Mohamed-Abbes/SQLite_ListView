package com.example.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Etudiant> lst;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(List<Etudiant> lst, Context context) {
        this.lst = lst;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Etudiant getItem(int position) {
        return lst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.maquette, parent, false);
        }

        Etudiant etudiant =  getItem(position);

        ((TextView) convertView.findViewById(R.id.nom_maq_id)).setText(etudiant.getNom());
        //Log.d("InsertEtudiant", "Nom: " + etudiant.getNom());
        ((TextView) convertView.findViewById(R.id.pre_maq_id)).setText(etudiant.getPrenom());

        return convertView;
    }
}
