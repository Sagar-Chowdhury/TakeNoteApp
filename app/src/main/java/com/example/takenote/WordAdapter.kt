 package com.example.takenote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

 class WordAdapter(private val context:Context, private val listener : IWordsinterface):RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    val allWords = ArrayList<Word>()

    class WordViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val textView =itemView.findViewById<TextView>(R.id.edittext)
        val delete = itemView.findViewById<ImageView>(R.id.delbutton)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val viewHolder = WordViewHolder(LayoutInflater.from(context).inflate(R.layout.sample_item,parent,false))

        viewHolder.delete.setOnClickListener {
            listener.onclicked(allWords[viewHolder.adapterPosition])
        }


        return viewHolder



    }



    override fun getItemCount(): Int {
      return allWords.size
    }

     override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
         val currWord = allWords[position]

         holder.itemView.findViewById<TextView>(R.id.textView).text=currWord.word
     }

     fun updateList(newList: List<Word>)
     {
         allWords.clear()
         allWords.addAll(newList)

      notifyDataSetChanged()
     }


 }

interface IWordsinterface
{
    fun onclicked(word: Word)

}