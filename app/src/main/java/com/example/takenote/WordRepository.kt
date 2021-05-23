package com.example.takenote

import androidx.lifecycle.LiveData

class WordRepository (private val wordDao: WordDao){

    val allWords: LiveData<List<Word>> = wordDao.getAlphetizedWords()

    suspend fun insert(word: Word)
    {
        wordDao.insert(word)
    }

    suspend fun delete(word: Word)
    {
        wordDao.deleteAll(word)

    }






}