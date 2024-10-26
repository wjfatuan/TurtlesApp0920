package com.example.turtlesapp0920.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Character::class), version = 1)
abstract class TurtlesDatabase: RoomDatabase() {

    abstract fun charactersDao(): CharacterDao

    companion object {
        const val DATABASE_NAME = "turtles.db"
        fun getInstance(context: Context): TurtlesDatabase {
            return Room.databaseBuilder(
                context,
                TurtlesDatabase::class.java,
                DATABASE_NAME
            ).build()
        }
    }


}
