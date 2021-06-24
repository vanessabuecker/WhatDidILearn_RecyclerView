package com.vbuecker.whatdidilearn.di

import com.vbuecker.whatdidilearn.database.LearnedItemDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

object LearnedItemModel {
    var module = module {
        factory {
            CoroutineScope(Dispatchers.IO)
        }

        single{
            LearnedItemDataBase.getDataBase(get(),get())
        }
    }

}