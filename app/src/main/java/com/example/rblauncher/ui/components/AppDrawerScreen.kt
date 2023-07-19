package com.example.rblauncher.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.rblauncher.AppsViewModel
import com.example.rblauncher.data.AppModel
import com.google.accompanist.drawablepainter.rememberDrawablePainter

@Composable
fun AppDrawerScreen(appsViewModel: AppsViewModel)
{
    val apps = appsViewModel.apps.observeAsState()
    LaunchedEffect(key1 = Unit) {
        appsViewModel.loadApps()
    }
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 64.dp),
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.Center,
    ) {
        apps.value?.forEach { app ->
            item {
                App(app)
            }
        }
    }
}

@Composable
fun App(app: AppModel)
{
    Column(modifier = Modifier.clickable { /* TODO: Open the app */ }) {
        Icon(painter = rememberDrawablePainter(drawable = app.icon), contentDescription = app.label)
        Text(text = app.label, color = Color.White)
    }
}