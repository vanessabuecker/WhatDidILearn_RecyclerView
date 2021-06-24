package com.vbuecker.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vbuecker.whatdidilearn.data.LearnedItemRepository

class ViewModelFactory(private val repository: LearnedItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalAccessException("ViewModel desconhecida")
    }

}