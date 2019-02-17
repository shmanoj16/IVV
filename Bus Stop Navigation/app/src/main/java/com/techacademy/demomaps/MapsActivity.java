package com.techacademy.demomaps;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import static android.R.attr.data;
import static android.R.attr.value;

public class MapsActivity extends FragmentActivity{


    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    double lati;
    double longi;

    Location loc;
    TextToSpeech ttobj;
    LocationManager lm;
    String provider;
    String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lm=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Criteria crit=new Criteria();
        provider=lm.getBestProvider(crit,false);
        loc=lm.getLastKnownLocation(provider);
       // lm.requestLocationUpdates(provider,5000,0,this);



        setContentView(R.layout.activity_maps);


        setUpMapIfNeeded();
        ttobj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {

            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    ttobj.setLanguage(Locale.UK);
                    speakout();
                }
            }
        });
       // EditText location_tf = (EditText) findViewById(R.id.TFaddress);
       // String location = location_tf.getText().toString();

        //List<Address> addressList = null;
        /*
        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);


            } catch (IOException e) {
                e.printStackTrace();
            }
*/
        List<Address> addressList = null;
        Geocoder geocoder=new Geocoder(getApplicationContext(),Locale.getDefault());
        try {
            addressList=geocoder.getFromLocation(loc.getLatitude(),loc.getLongitude(),10);
        }
        catch(IOException e) {
        }
            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

            // Toast.makeText(getApplicationContext(), (address.getAddressLine(value)), Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), address.getAddressLine(1), Toast.LENGTH_SHORT).show();
        location=address.getAddressLine(1);
           // ttobj.speak(address.getAddressLine(1), TextToSpeech.QUEUE_FLUSH, null);
            Toast.makeText(this, "OnSearch", Toast.LENGTH_SHORT).show();

        }

    private void speakout() {
        ttobj.speak(location,TextToSpeech.QUEUE_FLUSH,null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(ttobj!=null)
        {
            ttobj.stop();
            ttobj.shutdown();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();


    }



    public void onSearch(View view)
    {
        EditText location_tf = (EditText)findViewById(R.id.TFaddress);
        String location = location_tf.getText().toString();
        List<Address> addressList = null;
        if(location != null || !location.equals(""))
        {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location , 1);


            } catch (IOException e) {
                e.printStackTrace();
            }

            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude() , address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

           // Toast.makeText(getApplicationContext(), (address.getAddressLine(value)), Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), address.getAddressLine(1), Toast.LENGTH_SHORT).show();
            ttobj.speak(address.getAddressLine(1),TextToSpeech.QUEUE_FLUSH,null);
            Toast.makeText(this, "OnSearch", Toast.LENGTH_SHORT).show();

        }
    }

    public void onZoom(View view)
    {
        if(view.getId() == R.id.Bzoomin)
        {
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
        if(view.getId() == R.id.Bzoomout)
        {
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

    public void changeType(View view)
    {
        if(mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL)
        {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
        else
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.


            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {

       // getlManager();
        mMap.addMarker(new MarkerOptions().position(new LatLng(20.5937, 78.9629)).title("Marker"));
        mMap.setMyLocationEnabled(true);

        mMap.animateCamera(CameraUpdateFactory.zoomIn());

        Toast.makeText(this, "setUpMap", Toast.LENGTH_SHORT).show();


        
       // delay();



    }


    /*private void delay() {



                Toast.makeText(MapsActivity.this, "delay", Toast.LENGTH_SHORT).show();

                setUpMap();
    }*/

        





    /*public void getlManager() {

        lManager.requestLocationUpdates("gps", 1, 1, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {


                lati = location.getLatitude();
                longi = location.getLongitude();
                Toast.makeText(MapsActivity.this, "lati,longi", Toast.LENGTH_LONG).show();

                MarkerOptions opt=new MarkerOptions();
                opt.position(new LatLng(lati,longi));
                opt.title(lati+"\n" +longi);

                mMap.addMarker(opt);

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lati,longi),17));

                lManager.removeUpdates(this);

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });

    }*/

}
