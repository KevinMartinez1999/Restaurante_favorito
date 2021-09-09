package com.m99dev.restaurantefavorito

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.m99dev.restaurantefavorito.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private var listPlaces: ArrayList<LatLng> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val medellin = LatLng(6.247809443271876, -75.56611745925339)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(medellin, 15F))

        listPlaces.add(LatLng(6.339247350115879, -75.54430497558165))
        listPlaces.add(LatLng(6.268649490979573, -75.56546951229097))
        listPlaces.add(LatLng(6.264178505557715, -75.56729721878243))
        listPlaces.add(LatLng(6.253403996889194, -75.56675874268448))
        listPlaces.add(LatLng(6.246691777096592, -75.5667295066495))
        listPlaces.add(LatLng(6.252020492182749, -75.58518189465134))
        listPlaces.add(LatLng(6.24480447559214, -75.59537633041424))
        listPlaces.add(LatLng(6.233822246540332, -75.57327773053585))
        listPlaces.add(LatLng(6.232977510938995, -75.60417821904664))
        listPlaces.add(LatLng(6.232752396314998, -75.60446323776175))
        listPlaces.add(LatLng(6.197575250793848, -75.55768805709475))
        listPlaces.add(LatLng(6.199343876258062, -75.57369405631815))
        listPlaces.add(LatLng(6.196654863444374, -75.57443441861007))
        listPlaces.add(LatLng(6.18709922754902, -75.58237949676851))
        listPlaces.add(LatLng(6.179080919883636, -75.58807158203916))
        listPlaces.add(LatLng(6.171549982313694, -75.61049892324671))
        listPlaces.add(LatLng(6.160284569137553, -75.60452728337609))

        val lista = resources.getStringArray(R.array.names)
        for (i in 0 until listPlaces.size) {
            mMap.addMarker(
                MarkerOptions()
                    .position(listPlaces[i])
                    .title(lista[i + 1])
                    .snippet("Restaurante")
            )
        }

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        mMap.isMyLocationEnabled = true
    }
}