package com.example.finalproject

import android.os.Bundle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions

@Composable
fun MapView(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val mapView = remember {
        MapView(context).apply {
            onCreate(Bundle())
        }
    }
    val cameraPosition = LatLng(61.49911, 23.78712) // Tampere, Finland

    LaunchedEffect(mapView) {
        mapView.getMapAsync { googleMap ->
            googleMap.addMarker(MarkerOptions().position(cameraPosition).title("Tampere"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cameraPosition, 10f))
        }
    }

    DisposableEffect(mapView) {
        onDispose {
            mapView.onPause()
            mapView.onDestroy()
        }
    }

    AndroidView(
        modifier = modifier,
        factory = { mapView },
        update = { mapView.onResume() }
    )
}
