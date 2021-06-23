package com.vbuecker.whatdidilearn

import android.app.Application
import com.vbuecker.whatdidilearn.data.LearnedItemRepository
import com.vbuecker.whatdidilearn.database.LearnedItemDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class WhatDidIlearnedApplication : Application() {
    val database by lazy { LearnedItemDataBase.getDataBase(this, CoroutineScope(Dispatchers.IO)) }

    val repository by lazy {
        LearnedItemRepository(database.learnedItemDao())
    }

}