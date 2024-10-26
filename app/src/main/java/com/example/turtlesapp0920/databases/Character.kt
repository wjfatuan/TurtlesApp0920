package com.example.turtlesapp0920.databases

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(
    val name: String,
    val description: String,
    val thumbnail: String,
    val resourceURI: String = "",
    @PrimaryKey(autoGenerate = true) var uid: Int = 0
) {
}