package com.example.rblauncher

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rblauncher.data.AppModel
import com.example.rblauncher.utils.getApps
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppsViewModel(application: Application) : AndroidViewModel(application)
{
    private val appContext by lazy { application.applicationContext }

    private val _apps = MutableLiveData<List<AppModel>>()

    val apps: LiveData<List<AppModel>> = _apps

    fun loadApps()
    {
        CoroutineScope(Dispatchers.IO).launch {
            _apps.postValue(getApps(appContext))
        }
    }
}