package com.kanahia.maplibreassignment.Activities

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModelProvider
import com.kanahia.maplibreassignment.ViewModel.RootViewModel
import com.kanahia.maplibreassignment.ViewModel.RootViewModelFactory
import com.kanahia.maplibreassignment.api.Repository
import com.kanahia.maplibreassignment.databinding.ActivityMapBinding
import com.mapbox.geojson.Feature
import com.mapbox.geojson.FeatureCollection
import com.mapbox.geojson.LineString
import com.mapbox.geojson.Point
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.IconFactory
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.style.layers.LineLayer
import com.mapbox.mapboxsdk.style.layers.PropertyFactory
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MapActivity : AppCompatActivity() {

    private lateinit var id: String
    private lateinit var mapView: MapView
    private lateinit var binding: ActivityMapBinding
    private var startTime = ""
    private var endTime = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Mapbox.getInstance(this)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        id = intent.getStringExtra("id").toString()
        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync { map ->
            map.cameraPosition = CameraPosition.Builder().target(LatLng(25.539805385300642,84.85399302533725)).zoom(18.0).build()
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiService = retrofit.create(Repository.ApiService::class.java)
        val repository = Repository(apiService, this@MapActivity)
        val viewModel = ViewModelProvider(this, RootViewModelFactory(repository))
            .get(RootViewModel::class.java)
        viewModel.fetchTrack(id)

        val coordinatesList = mutableListOf<Point>()
        viewModel.track.observe(this) { track ->
            startTime = track.features.first().properties.time
            endTime = track.features.last().properties.time
            track.features.forEach { feature ->
                val coordinates = feature.geometry.coordinates
                val time = feature.properties.time
                if (coordinates.size == 2) {
                    val latitude = coordinates[1]
                    val longitude = coordinates[0]
                    coordinatesList.add(Point.fromLngLat(longitude, latitude))
                }
            }

            mapView.getMapAsync {
                it.setStyle("https://demotiles.maplibre.org/style.json") {
                    it.addSource(
                        GeoJsonSource(
                            "line-source",
                            FeatureCollection.fromFeatures(
                                arrayOf<Feature>(
                                    Feature.fromGeometry(
                                        LineString.fromLngLats(coordinatesList)
                                    )
                                )
                            )
                        )
                    )
                    it.addLayer(
                        LineLayer("linelayer", "line-source").withProperties(
                            PropertyFactory.lineWidth(5f),
                            PropertyFactory.lineColor(Color.parseColor("#e55e5e"))
                        )
                    );
                }
                val startLatLng = LatLng(coordinatesList.first().latitude(),coordinatesList.first().longitude())
                val endLatLng = LatLng(coordinatesList.last().latitude(),coordinatesList.last().longitude())
                val markerDrawable = ContextCompat.getDrawable(this,com.kanahia.maplibreassignment.R.drawable.map_default_map_marker)
                val bitmap = markerDrawable!!.toBitmap()
                val icon = IconFactory.getInstance(this)
                    .fromBitmap(bitmap)

                val markerOptions = MarkerOptions()
                    .position(startLatLng)
                    .title(startTime)
                    .icon(icon)
                it.addMarker(markerOptions)
                val markerOptions2 = MarkerOptions()
                    .position(endLatLng)
                    .title(endTime)
                    .icon(icon)
                it.addMarker(markerOptions2)
            }
        }

    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    private companion object{
        const val BASE_URL = "https://envirocar.org/"
    }

}