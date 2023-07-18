package com.example.rblauncher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.rblauncher.ui.components.Wallpaper
import com.example.rblauncher.ui.theme.RBLauncherTheme


class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            RBLauncherTheme {
                Wallpaper(this)
            }
        }
    }
}