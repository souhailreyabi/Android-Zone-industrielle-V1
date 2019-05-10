package com.example.entreprisetanger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListeViewAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private static ArrayList<Entreprise_Manager> e;

    public ListeViewAdapter(Context zone1,ArrayList<Entreprise_Manager> resultat) {
        mInflater=LayoutInflater.from(zone1);
        e=resultat;
    }


    @Override
    public int getCount() {
        return e.size();
    }

    @Override
    public Object getItem(int position) {
        return e.get(position);
    }

    @Override
    public long getItemId(int position) {
        return e.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolde holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.entreprise_view, null);
            holder = new ViewHolde();
            holder.nom = (TextView) convertView.findViewById(R.id.txt_Nom);
            holder.dom = (TextView) convertView.findViewById(R.id.txt_Dom);
            holder.adresse= (TextView) convertView.findViewById(R.id.txt_adr);
            holder.tel= (TextView) convertView.findViewById(R.id.txt_tel);
            holder.id= (TextView) convertView.findViewById(R.id.txt_id);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolde) convertView.getTag();
        }
        holder.nom.setText(e.get(position).getNom());
        holder.dom.setText(e.get(position).getDomaine());
        holder.adresse.setText(e.get(position).getAdresse());
        holder.tel.setText(e.get(position).getTelephone());
        holder.id.setText(e.get(position).getId()+" ");

        return convertView;

    }
}

class ViewHolde{
    TextView nom,adresse,dom,tel,id;

}
