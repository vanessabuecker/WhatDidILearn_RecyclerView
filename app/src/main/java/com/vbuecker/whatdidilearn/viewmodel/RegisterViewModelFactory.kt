package com.vbuecker.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vbuecker.whatdidilearn.data.LearnedItemRepository

class RegisterViewModelFactory (private val repository: LearnedItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(repository) as T
        }
        throw IllegalAccessException("ViewModel not found")
    }

}