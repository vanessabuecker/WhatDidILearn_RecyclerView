package com.vbuecker.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vbuecker.whatdidilearn.data.LearnedItemRepository
import com.vbuecker.whatdidilearn.entities.LearnedItem

class RegisterViewModel(private val repository: LearnedItemRepository) : ViewModel() {
    val learnedItem: LiveData<List<LearnedItem>> = repository.learnedItem

}


