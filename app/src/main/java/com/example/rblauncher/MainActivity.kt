package com.example.rblauncher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.example.rblauncher.ui.components.AppDrawerScreen
import com.example.rblauncher.ui.components.HomeScreen
import com.example.rblauncher.ui.components.Wallpaper
import com.example.rblauncher.ui.theme.RBLauncherTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity()
{
    private val appsViewModel: AppsViewModel by viewModels()

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            RBLauncherTheme {
                Wallpaper(this)
            }
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent)
            }
            val pagerState = rememberPagerState(pageCount = { 2 })
            VerticalPager(state = pagerState) { page ->
                if (page == 0) AppDrawerScreen(appsViewModel)
                else HomeScreen()
                /*Text(
                    text = "Page: $page",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontSize = 30.sp
                )*/
            }
        }
    }
}