package com.vbuecker.whatdidilearn.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Learned_item")
data class LearnedItem(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    val id: Int = 0,
    @ColumnInfo(name = "item_name")
    var name: String,
    @ColumnInfo(name = "item_description")
    var description: String,
    @ColumnInfo(name = "item_level")
    val understandingLevel: UnderstandingLevel

)