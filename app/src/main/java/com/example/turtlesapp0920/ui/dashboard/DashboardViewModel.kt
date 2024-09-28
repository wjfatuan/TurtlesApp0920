package com.example.turtlesapp0920.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    var characterName: String = "donatello"

    fun changeCharacterName(name: String) {
        characterName = name
    }

}