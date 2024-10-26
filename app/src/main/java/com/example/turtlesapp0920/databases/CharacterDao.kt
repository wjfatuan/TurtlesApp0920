package com.example.turtlesapp0920.databases

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CharacterDao {
    @Insert
    suspend fun addCharacter(vararg c: Character)
    @Query("SELECT * FROM characters WHERE uid = :id")
    suspend fun findById(id: Int): Character
    @Query("SELECT * FROM characters WHERE name = :name")
    suspend fun findByName(name: String): Character
    @Query("SELECT * FROM characters")
    suspend fun findAll(): List<Character>
    @Update
    suspend fun update(c: Character)
    @Delete
    suspend fun delete(c: Character)
}