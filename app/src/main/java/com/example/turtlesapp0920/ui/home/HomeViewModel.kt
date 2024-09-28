package com.example.turtlesapp0920.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val characterNames = arrayListOf("donatello")
    val allCharacterNames = arrayListOf("donatello", "leonardo", "michelangelo", "raphael", "splinter", "april")

    fun addRandomCharacter() {
        characterNames.add(allCharacterNames.random())
    }

    fun addCharacter(name: String) {
        characterNames.add(name)
    }

    fun removeCharacter(name: String) {
        characterNames.remove(name)
    }

}