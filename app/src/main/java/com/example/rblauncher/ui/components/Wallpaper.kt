package com.example.rblauncher.ui.components

import android.Manifest
import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.rblauncher.R
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

/**
 * Resolves a Wallpaper Image, by getting it or by setting a default one.
 * */
@SuppressLint("MissingPermission")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Wallpaper(context: Context)
{
    val readExternalStoragePermissionState = rememberPermissionState(
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    val painter = if (readExternalStoragePermissionState.status.isGranted)
    {
        val wallpaperManager = WallpaperManager.getInstance(context)
        val wallpaper = wallpaperManager.drawable
        rememberDrawablePainter(drawable = wallpaper)
    } else
    {
        // TODO: Set default wallpaper on permission denied
        LaunchedEffect("Key1") {
            readExternalStoragePermissionState.launchPermissionRequest()
        }
        painterResource(id = R.drawable.ic_launcher_background)
    }
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}