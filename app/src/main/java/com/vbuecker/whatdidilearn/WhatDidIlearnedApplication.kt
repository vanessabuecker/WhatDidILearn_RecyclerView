package com.vbuecker.whatdidilearn

import android.app.Application
import com.vbuecker.whatdidilearn.data.LearnedItemRepository
import com.vbuecker.whatdidilearn.database.LearnedItemDataBase
import com.vbuecker.whatdidilearn.di.LearnedItemModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WhatDidIlearnedApplication : Application() {
    val database by lazy { LearnedItemDataBase.getDataBase(this, CoroutineScope(Dispatchers.IO)) }

    val repository by lazy {
        LearnedItemRepository(database.learnedItemDao())
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WhatDidIlearnedApplication)
            modules(LearnedItemModel.module)
        }
    }

}