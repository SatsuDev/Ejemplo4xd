package com.utp.ejemplo4;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng arequipa1 = new LatLng(-16.399099, -71.537525);
        LatLng arequipa2 = new LatLng(-16.398266, -71.537204);
        LatLng arequipa3 = new LatLng(-16.399366, -71.536728);
        LatLng arequipa4 = new LatLng(-16.398594, -71.536357);
        mMap.addMarker(new MarkerOptions().position(arequipa1).title("Marker in Arequipa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arequipa1,16));

        mMap.addMarker(new MarkerOptions().position(arequipa2).title("Marker in Arequipa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arequipa2,16));

        mMap.addMarker(new MarkerOptions().position(arequipa3).title("Marker in Arequipa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arequipa3,16));

        mMap.addMarker(new MarkerOptions().position(arequipa4).title("Marker in Arequipa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(arequipa4,16));

        PolylineOptions route = new PolylineOptions();
        route.add(new LatLng(-16.399099, -71.537525));
        route.add(new LatLng(-16.398266, -71.537204));
        route.add(new LatLng(-16.399366, -71.536728));
        route.add(new LatLng(-16.398594, -71.536357));
        mMap.addPolyline(route);
    }
    public boolean checkpermissions()
    {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }else{
            return false;
        }
    }
}
