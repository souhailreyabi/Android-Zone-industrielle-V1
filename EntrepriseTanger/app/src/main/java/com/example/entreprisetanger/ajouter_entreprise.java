package com.example.entreprisetanger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class ajouter_entreprise extends Fragment {
    Button bt;
    DataDatabseConnection db;
    Entreprise_Manager E;
    EditText E1,E2,E3,E4,E5,E6;
    String nom,adr,tel,dom;


    String zone ;
    public ajouter_entreprise() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View c= inflater.inflate(R.layout.fragment_ajouter_entreprise, container, false);
        bt=c.findViewById(R.id.button_ajout);
        E1= c.findViewById(R.id.editText_nom);
        E2=c.findViewById(R.id.editText_dom);
        E3=c.findViewById(R.id.editText_adr);
        E4=c.findViewById(R.id.editText_tel);
        E5=c.findViewById(R.id.txt_Lat);
        E6=c.findViewById(R.id.txt_lng);
        final Spinner spinner=(Spinner)c.findViewById(R.id.spinner2);
        ArrayList<String> data=new ArrayList<>();
        data.add("Gzenaya");
        data.add("freezone");
        ArrayAdapter<String> spin=new ArrayAdapter<String>(c.getContext(),android.R.layout.simple_spinner_item,data);
        spinner.setAdapter(spin);



        db=new DataDatabseConnection(c.getContext());
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
Boolean c=db.isdouble(E5.getText().toString(),E6.getText().toString());
               if(c==true){
                   db.Ajouter_Entreprise(E1.getText().toString(),E2.getText().toString(),E4.getText().toString(),spinner.getSelectedItem().toString(),E3.getText().toString(),E5.getText().toString(),E6.getText().toString());
                   Toast.makeText(getContext(),"Succes",Toast.LENGTH_LONG).show();
                   E1.setText("");
                   E2.setText("");
                   E3.setText("");
                   E4.setText("");
                   E5.setText("");
                   E6.setText("");

               }else
               {
                   Toast.makeText(getContext(),"Lat et Lng doitre Etre double ",Toast.LENGTH_LONG).show();
                   E5.setText("");
                   E6.setText("");
               }

                }

            });

        return c;
    }
}
