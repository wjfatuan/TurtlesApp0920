package com.example.turtlesapp0920.ui.notifications

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.turtlesapp0920.databases.Character
import com.example.turtlesapp0920.databases.TurtlesDatabase
import com.example.turtlesapp0920.services.Cat
import com.example.turtlesapp0920.services.CatApiService
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.koushikdutta.async.future.FutureCallback
import com.koushikdutta.ion.Ion
import kotlinx.coroutines.launch

class NotificationsViewModel(app: Application) : AndroidViewModel(app) {

    private val _cat = MutableLiveData<String>().apply {
        value = "https://cdn2.thecatapi.com/images/ap4.jpg"
    }
    val cat: LiveData<String> = _cat

    fun loadCats() {
        val service = CatApiService.getInstance()
        viewModelScope.launch {
            val cats = service.search()
            _cat.postValue(cats[0].url)
        }
    }

    fun addCharacter(thumbnail: String) {
        val character = Character("leo","leo description",thumbnail)
        val db = TurtlesDatabase.getInstance(getApplication())
        viewModelScope.launch {
            val dao = db.charactersDao()
            dao.addCharacter(character)
        }

    }
}