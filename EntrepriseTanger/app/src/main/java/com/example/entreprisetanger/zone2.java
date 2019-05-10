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


/**
 * A simple {@link Fragment} subclass.
 */
public class zone2 extends Fragment {
Button bt,bt2;
EditText Ed;
DataDatabseConnection cd;
    DataDatabseConnection db;

    public zone2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_zone2, container, false);
        // Inflate the layout for this fragment

        DataDatabseConnection db=new DataDatabseConnection(getContext());
        cd=new DataDatabseConnection(getContext());
        ArrayList<Entreprise_Manager> data=db.ListeZone2();
        ListView lv = (ListView) v.findViewById(R.id.Freezoneliste);
        lv.setAdapter(new ListeViewAdapter(getActivity(), data));
        bt=v.findViewById(R.id.btn_ajouter);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragment= getActivity().getSupportFragmentManager().beginTransaction();

                ajouter_entreprise s =new ajouter_entreprise();
                fragment.replace(R.id.containt_main,s,s.getTag()).commit();
            }
        });
        bt2=v.findViewById(R.id.btn_supprimer);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder bd=new AlertDialog.Builder(getContext());
                LayoutInflater mInflater = getLayoutInflater();
                View vv=mInflater.inflate(R.layout.diagl_supp, null);
                bd.setView(vv);
                final AlertDialog dialog=bd.create();
                dialog.show();
                Ed=(EditText)vv.findViewById(R.id.id_edit);
                Button vb=(Button)vv.findViewById(R.id.bt_valider);
                Button vbb=(Button)vv.findViewById(R.id.bt_F);

                vb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(Ed.getText().toString().isEmpty()){
                            Toast.makeText(getContext(),"Remplissez les champs",Toast.LENGTH_LONG).show();
                        }else{
                            cd.Supprimer_Entreprise(Ed.getText().toString());
                            FragmentTransaction fragment= getActivity().getSupportFragmentManager().beginTransaction();
                            zone2 s =new zone2();
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
