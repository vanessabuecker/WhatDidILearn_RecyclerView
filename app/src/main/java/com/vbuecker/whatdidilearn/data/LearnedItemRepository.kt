package com.vbuecker.whatdidilearn.data

import androidx.lifecycle.LiveData
import com.vbuecker.whatdidilearn.database.LearnedItemDao
import com.vbuecker.whatdidilearn.entities.LearnedItem

class LearnedItemRepository (private val dao: LearnedItemDao ){
val learnedItem: LiveData<List<LearnedItem>> = dao.getAll()

    fun addNewItem(item: LearnedItem){
        dao.insert(item)
    }
}