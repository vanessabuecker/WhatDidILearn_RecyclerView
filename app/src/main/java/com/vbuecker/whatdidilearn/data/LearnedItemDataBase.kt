package com.vbuecker.whatdidilearn.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [LearnedItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)

abstract class LearnedItemDataBase : RoomDatabase() {

    abstract fun learnedItemDao(): LearnedItemDao

    companion object {
        @Volatile
        var INSTANCE: LearnedItemDataBase? = null

        fun getDataBase(context: Context): LearnedItemDataBase {
            return INSTANCE ?: synchronized(this) {
                val database = Room.databaseBuilder(
                    context.applicationContext,
                    LearnedItemDataBase::class.java,
                    "learned_item_database"
                ).build()

                INSTANCE = database
                database
            }
        }

        fun getAll(): List<LearnedItem> {

            return listOf(
                LearnedItem(
                    name = "Kotlin",
                    description = "Linguagem kotlin para Android",
                    understandingLevel = UnderstandingLevel.MEDIUM
                ),
                LearnedItem(
                    name = "RecyclerView",
                    description = "Listas em Android",
                    understandingLevel = UnderstandingLevel.MEDIUM
                ),
                LearnedItem(
                    name = "DataClass",
                    description = "Kotlin data Class",
                    understandingLevel = UnderstandingLevel.HIGH
                ),
                LearnedItem(
                    name = "Life Cycle",
                    description = "Ciclo de vida de uma aplicação Android",
                    understandingLevel = UnderstandingLevel.HIGH
                ),
                LearnedItem(
                    name = "Intent",
                    description = "Como usar intents",
                    understandingLevel = UnderstandingLevel.MEDIUM
                ),
                LearnedItem(
                    name = "Services",
                    description = "Service em  Android",
                    understandingLevel = UnderstandingLevel.MEDIUM
                ),
                LearnedItem(
                    name = "Content Provider",
                    description = "Dados com Contenct Provider",
                    understandingLevel = UnderstandingLevel.LOW
                ),
            )
        }
    }

}

