package com.example.entreprisetanger;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


public class location extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    MapView mapView;
    View mview;
    ArrayList<Entreprise_Manager> z1,z2;
    Geocoder geocoder;
    List<Address> listadresse;
    Address ad;
    double lat,lng;

    public location() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview=inflater.inflate(R.layout.fragment_location, container, false);
        return  mview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) mview.findViewById(R.id.map);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        DataDatabseConnection connection=new DataDatabseConnection(getContext());
        z2=connection.ListeZone2();
        z1=connection.ListeZone1();

        LatLng wd=null;


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(35.720953, -5.908806);
       // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        for(Entreprise_Manager E:z2){
             wd = new LatLng(Double.parseDouble(E.getLatitude()), Double.parseDouble(E.getLongitude()));
            mMap.addMarker(new MarkerOptions().position(wd).title(E.getNom()+"Domaine:"+E.getDomaine()+"Telephone:"+E.getTelephone()).snippet("Latitude :"+E.getLongitude()+"Longitude :"+E.getLongitude()));
        }
        for(Entreprise_Manager E:z1){
            wd = new LatLng(Double.parseDouble(E.getLatitude()), Double.parseDouble(E.getLongitude()));
            mMap.addMarker(new MarkerOptions().position(wd).title(E.getNom()+"Domaine:"+E.getDomaine()+"Telephone:"+E.getTelephone()).snippet("Latitude :"+E.getLongitude()+"Longitude :"+E.getLongitude()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        }

            CameraPosition cdep = CameraPosition.builder().target(sydney).zoom(10).bearing(0).tilt(45).build();

            mMap.setBuildingsEnabled(true);
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cdep));


       
    }
}
