package com.sample.nytimes.utils

import androidx.room.TypeConverter
import java.util.*

class DateTypeConverter {
    @TypeConverter
    fun fromDate(date: Date?): Long? = date?.let { it.time } ?: kotlin.run { null }

    @TypeConverter
    fun toDate(timestamp: Long?): Date? = timestamp?.let { Date(timestamp) } ?: kotlin.run { null }
}