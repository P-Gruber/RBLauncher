package com.example.rblauncher.utils

import android.content.Context
import android.content.pm.LauncherApps
import android.os.UserManager
import android.widget.Toast
import com.example.rblauncher.data.AppModel

fun Context.toast(text: String, duration: Int = Toast.LENGTH_LONG)
{
    Toast.makeText(this, text, duration).show()
}

fun getApps(context: Context): List<AppModel>
{
    val userManager = context.getSystemService(Context.USER_SERVICE) as UserManager
    val launcherApps = context.getSystemService(Context.LAUNCHER_APPS_SERVICE) as LauncherApps
    return userManager.userProfiles.map { user ->
        launcherApps.getActivityList(null, user).map { app ->
            AppModel(
                app.label.toString(),
                app.applicationInfo.packageName,
                app.getIcon(0),
            )
        }
    }.flatten().sortedBy { app ->
        app.label.lowercase()
    }
}