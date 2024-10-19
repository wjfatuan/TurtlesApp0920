package com.example.turtlesapp0920.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    val characterName: MutableLiveData<String> = MutableLiveData("donatello")

    fun changeCharacterName(name: String) {
        characterName.postValue(name)
        viewModelScope.launch {
            // llamo una funcion suspend
        }
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            // llamo una funcion suspend
        }
    }

}
