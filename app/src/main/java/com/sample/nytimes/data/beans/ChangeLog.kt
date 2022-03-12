package com.sample.nytimes.data.beans

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sample.nytimes.utils.DatabaseConstants
import java.util.*

@Entity(tableName = DatabaseConstants.TABLE_CHANGE_LOG)
data class ChangeLog(
    @PrimaryKey val name: String,
    @ColumnInfo(name = "changeLogTime") val changeLogTime: Date
)