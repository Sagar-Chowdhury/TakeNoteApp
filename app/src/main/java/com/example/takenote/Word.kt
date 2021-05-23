package com.example.takenote

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.*


@Entity(tableName = "word_table")
class Word (@PrimaryKey@ColumnInfo(name="word")val word:String)