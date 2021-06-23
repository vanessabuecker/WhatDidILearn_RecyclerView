package com.vbuecker.whatdidilearn

import android.app.Application
import com.vbuecker.whatdidilearn.data.LearnedItemDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class WhatDidIlearnedApplication: Application() {
    val database by lazy { LearnedItemDataBase.getDataBase(this, CoroutineScope(Dispatchers.IO))

    }

}