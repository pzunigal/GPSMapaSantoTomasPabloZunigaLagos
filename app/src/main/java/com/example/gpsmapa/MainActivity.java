package com.example.gpsmapa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    EditText txtLongi, txtLati; //declaramos e iniciamos las variables
    GoogleMap mMap; //Objeto google maps que sirve para interactuar con el mapa

    private VideoView videito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videito = findViewById(R.id.videoView);

        String videoURL = "https://drive.google.com/uc?id=1Yb5OC8fBaHSgfUofPVi1dKsEb6PbY9DJ&export=download";

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videito);
        videito.setMediaController(mediaController);

        videito.setVideoURI(Uri.parse(videoURL));

        videito.start();

        txtLati=findViewById(R.id.txtLatitud);
        txtLongi=findViewById(R.id.txtLongitud);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap=googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng Chile = new LatLng(-35.675247, -71.542969);
        mMap.addMarker(new MarkerOptions().position(Chile).title("Chile <3"));

        LatLng SantoArica = new LatLng(-18.478, -70.312);
        mMap.addMarker(new MarkerOptions().position(SantoArica).title("Santo Tomas Arica"));

        LatLng SantoIquique = new LatLng(-20.220, -70.143);
        mMap.addMarker(new MarkerOptions().position(SantoIquique).title("Santo Tomas Iquique"));

        LatLng SantoAntofa = new LatLng(-23.652,-70.395);
        mMap.addMarker(new MarkerOptions().position(SantoAntofa).title("Santo Tomas Antofagasta"));

        LatLng SantoSerena = new LatLng(-29.902, -71.251);
        mMap.addMarker(new MarkerOptions().position(SantoSerena).title("Santo Tomas La Serena"));

        LatLng SantoVina = new LatLng(-33.024, -71.552);
        mMap.addMarker(new MarkerOptions().position(SantoVina).title("Santo Tomas Viña del Mar"));

        LatLng SantoSantiago = new LatLng(-33.437,-70.650);
        mMap.addMarker(new MarkerOptions().position(SantoSantiago).title("Santo Tomas Santiago"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SantoArica));

        LatLng SantoTalca = new LatLng(-35.426, -71.655);
        mMap.addMarker(new MarkerOptions().position(SantoTalca).title("Santo Tomas Talca"));

        LatLng SantoConce = new LatLng(36.820, -73.044);
        mMap.addMarker(new MarkerOptions().position(SantoConce).title("Santo Tomas Concepcion"));

        LatLng SantoAnge = new LatLng(-37.464,-72.353);
        mMap.addMarker(new MarkerOptions().position(SantoAnge).title("Santo Tomas Los Angeles"));

        LatLng SantoTemu = new LatLng(-38.735, -72.590);
        mMap.addMarker(new MarkerOptions().position(SantoTemu).title("Santo Tomas Temuco"));

        LatLng SantoValdi = new LatLng(-39.817, -73.245);
        mMap.addMarker(new MarkerOptions().position(SantoValdi).title("Santo Tomas Valdivia"));

        LatLng SantoOsorno = new LatLng(-40.574, -73.131);
        mMap.addMarker(new MarkerOptions().position(SantoOsorno).title("Santo Tomas Osorno"));

        LatLng SantoPuerto = new LatLng(-41.471, -72.936);
        mMap.addMarker(new MarkerOptions().position(SantoPuerto).title("Santo Tomas PuertoMontt"));
    }

    @Override //Utilizan este metodo para manejar los eventos del click largo en el mapa
    public void onMapClick(@NonNull LatLng latLng) {
        txtLati.setText(""+latLng.latitude);
        txtLongi.setText(""+latLng.longitude);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtLati.setText(""+latLng.latitude);
        txtLongi.setText(""+latLng.longitude);
    }
}