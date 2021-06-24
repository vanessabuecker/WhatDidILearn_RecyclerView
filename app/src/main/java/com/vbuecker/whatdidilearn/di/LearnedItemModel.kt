package com.vbuecker.whatdidilearn.di

import com.vbuecker.whatdidilearn.data.LearnedItemRepository
import com.vbuecker.whatdidilearn.database.LearnedItemDataBase
import com.vbuecker.whatdidilearn.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object LearnedItemModel {
    var module = module {
        factory {
            CoroutineScope(Dispatchers.IO)
        }

        single {
            LearnedItemDataBase.getDataBase(context = get(), scope = get())
        }

        single {
            get<LearnedItemDataBase>().learnedItemDao()
        }

        factory {
            LearnedItemRepository(get())
        }

        viewModel { MainViewModel(get()) }
    }

}