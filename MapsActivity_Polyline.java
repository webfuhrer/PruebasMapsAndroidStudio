package com.example.aplicaciongooglemaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button btn_mostrar;
    private EditText et_latitud;
    private EditText et_longitud;
    private OnMapReadyCallback cb=this;
    private ProgressBar pb;
    private SupportMapFragment mapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mapa);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        btn_mostrar=findViewById(R.id.btn_mostrarpunto);
        pb=findViewById(R.id.pb_carga);
        et_latitud=findViewById(R.id.et_latitud);
        et_longitud=findViewById(R.id.et_longitud);
         mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
         mapFragment.getMapAsync(this);
       /* pb.setVisibility(View.INVISIBLE);
        btn_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapFragment.getMapAsync(cb);
                btn_mostrar.setEnabled(false);
                pb.setVisibility(View.VISIBLE);
            }
        });*/





    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        ArrayList<LatLng> lista=new ArrayList<>();
        lista.add(new LatLng(40.34622242609271, -3.849570496266006));
        lista.add(new LatLng(40.3459914788404, -3.8495481683511628));
        lista.add(new LatLng(40.345867496305054, -3.8495481683511628));
        lista.add(new LatLng(40.345660858239754, -3.8494779949045146));
        lista.add(new LatLng(40.345378857035044, -3.8492706642666876));
        lista.add(new LatLng(40.34515460612465, -3.8490633283089375));
        lista.add(new LatLng(40.34502052261703, -3.8491941449888976));
        PolylineOptions opciones_linea=new PolylineOptions().addAll(lista);
        googleMap.addPolyline(opciones_linea);


        opciones_linea.add(new LatLng(40.34389627348289, -3.8491535466884956));
        googleMap.addPolyline(opciones_linea);
        //pb.setVisibility(View.INVISIBLE);
        /*btn_mostrar.setEnabled(true);
        mMap = googleMap;
        float lat=Float.valueOf(et_latitud.getText().toString());
        float longitud=Float.valueOf(et_longitud.getText().toString());

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lat, longitud);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
    }
}