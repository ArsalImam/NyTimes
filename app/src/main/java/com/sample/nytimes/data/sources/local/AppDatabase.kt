package com.sample.nytimes.utils

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.sample.nytimes.data.beans.ChangeLog
import com.sample.nytimes.data.beans.FeedCommentPost
import com.sample.nytimes.data.sources.local.ChangeLogDao
import com.sample.nytimes.data.sources.local.FeedCommentDao

@Database(entities = [FeedCommentPost::class, ChangeLog::class], version = 1)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun feedDao(): FeedCommentDao
    abstract fun changeLogDao(): ChangeLogDao
}

object DatabaseConstants {
    const val TABLE_CHANGE_LOG = "changeLog"
    const val TABLE_FEEDS_COMMENTS = "feedsComments"
}
