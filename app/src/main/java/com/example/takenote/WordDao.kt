package com.example.takenote

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {


    @Query("SELECT * FROM word_table  ")
    fun getAlphetizedWords():LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Delete
    suspend fun deleteAll(word: Word)












}