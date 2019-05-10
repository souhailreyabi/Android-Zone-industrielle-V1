package com.example.entreprisetanger;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class zone1 extends Fragment {

Button bt,bt2;
int id;
Entreprise_Manager d;
DataDatabseConnection cd;
    EditText Ed;
    public zone1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v=  inflater.inflate(R.layout.fragment_zone1, container, false);

        DataDatabseConnection db=new DataDatabseConnection(getContext());
          cd=new DataDatabseConnection(getContext());
        ArrayList<Entreprise_Manager> data;
        data = db.ListeZone1();
        ListView lv = (ListView) v.findViewById(R.id.listviewid);
        lv.setAdapter(new ListeViewAdapter(getActivity(), data));
        bt=v.findViewById(R.id.btn_ajout);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragment= getActivity().getSupportFragmentManager().beginTransaction();
                ajouter_entreprise s =new ajouter_entreprise();
                fragment.replace(R.id.containt_main,s,s.getTag()).commit();
            }
        });
        bt2=v.findViewById(R.id.btn_supp);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder bd=new AlertDialog.Builder(getContext());
                LayoutInflater mInflater = getLayoutInflater();
                View vv=mInflater.inflate(R.layout.diaglog_supp, null);
                bd.setView(vv);
                final AlertDialog dialog=bd.create();
                dialog.show();
                 Ed=(EditText)vv.findViewById(R.id.id_ed);
                Button vb=(Button)vv.findViewById(R.id.bt_val);
                Button vbb=(Button)vv.findViewById(R.id.bt_Fermer);

                    vb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(Ed.getText().toString().isEmpty()){
                                Toast.makeText(getContext(),"Remplissez les champs",Toast.LENGTH_LONG).show();
                            }else{
                            cd.Supprimer_Entreprise(Ed.getText().toString());
                                FragmentTransaction fragment= getActivity().getSupportFragmentManager().beginTransaction();
                                zone1 s =new zone1();
                                fragment.replace(R.id.containt_main,s,s.getTag()).commit();
                            }
                        }
                    });


                vbb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }
        });

        return v;
    }
}

