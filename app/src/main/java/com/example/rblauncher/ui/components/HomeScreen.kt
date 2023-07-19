package com.example.rblauncher.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen()
{
    Text(text = "Home", color = Color.White, modifier = Modifier.fillMaxSize())
}