package com.example.takenote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() ,IWordsinterface{
  lateinit var viewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //Setting the recyclerView
        val rv:RecyclerView = findViewById(R.id.recyclerView)
        rv.layoutManager=LinearLayoutManager(this)
        val adapter= WordAdapter(this,this)
        rv.adapter=adapter


        //setting the viewModel

       viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(WordViewModel::class.java)

        viewModel.allWords.observe(this, Observer {
         list->
            list?.let {
                adapter.updateList(it)
            }
        })



    }

    override fun onclicked(word: Word) {

         viewModel.deleteword(word)
        Toast.makeText(this,"Item deleted",Toast.LENGTH_LONG).show()

    }

    fun submitData(view: View) {
        val wordtxt = findViewById<TextView>(R.id.edittext).text.toString()
        if(wordtxt.isNotEmpty())
        {
            viewModel.insertWord(Word(wordtxt))
            Toast.makeText(this,"Item Inserted",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this,"Enter text first",Toast.LENGTH_LONG).show()

        }


    }


}