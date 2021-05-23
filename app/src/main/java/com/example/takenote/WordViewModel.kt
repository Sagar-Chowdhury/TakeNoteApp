package com.example.takenote

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application):AndroidViewModel(application) {

    private val repository:WordRepository
   var allWords:LiveData<List<Word>>


  init {

      val dao = WordRoomDatabase.getDatabase(application).wordDao()
       repository=WordRepository(dao)
      allWords=repository.allWords


  }


    fun deleteword(word:Word)=viewModelScope.launch(Dispatchers.IO) {
       repository.delete(word)
    }

    fun insertWord(word: Word)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }



}
//class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return WordViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}