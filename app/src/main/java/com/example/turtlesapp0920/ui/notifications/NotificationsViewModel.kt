package com.example.turtlesapp0920.ui.notifications

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonArray
import com.koushikdutta.async.future.FutureCallback
import com.koushikdutta.ion.Ion

class NotificationsViewModel(app: Application) : AndroidViewModel(app) {

    private val CATS_URL = "https://api.thecatapi.com/v1/images/search?limit=10"

    private val _cat = MutableLiveData<String>().apply {
        value = "https://cdn2.thecatapi.com/images/ap4.jpg"
    }
    val cat: LiveData<String> = _cat

    fun loadCats() {
        Ion.with(getApplication() as Context)
            .load(CATS_URL)
            .asJsonArray()
            .setCallback(object : FutureCallback<JsonArray?> {
                override fun onCompleted(e: Exception?, result: JsonArray?) {
                    if(result!=null && result.size()>0)
                        _cat.value = result.get(0).asJsonObject.get("url").asString
                }
            })

    }
}