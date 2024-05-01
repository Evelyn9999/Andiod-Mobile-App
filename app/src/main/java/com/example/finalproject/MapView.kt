package com.example.finalproject

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.*
import com.google.android.gms.maps.model.LatLng

@Composable
fun MapView() {
    val position = LatLng(60.1699, 24.9384)  // Helsinki coordinates
    val cameraPosition = CameraPosition.fromLatLngZoom(position, 10f)  // Properly setting the camera position

    val cameraPositionState = rememberCameraPositionState {
        cameraPosition
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = position),
            title = "Helsinki",
            snippet = "Capital of Finland"
        )
    }
}

