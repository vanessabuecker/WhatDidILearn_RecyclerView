package com.vbuecker.whatdidilearn.database

import androidx.room.TypeConverter
import com.vbuecker.whatdidilearn.entities.UnderstandingLevel

class Converters {
    @TypeConverter
    fun levelToInt(level: UnderstandingLevel): Int {
        return level.ordinal
    }

    @TypeConverter
    fun intToLevel(int: Int): UnderstandingLevel {
        return when (int) {
            UnderstandingLevel.LOW.ordinal -> UnderstandingLevel.LOW
            UnderstandingLevel.MEDIUM.ordinal -> UnderstandingLevel.MEDIUM
            else -> UnderstandingLevel.HIGH
        }
    }

}