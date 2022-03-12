package com.sample.nytimes.data.sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sample.nytimes.data.beans.ChangeLog
import com.sample.nytimes.data.beans.FeedCommentPost
import com.sample.nytimes.utils.DatabaseConstants

@Dao
interface ChangeLogDao {

    @Query("SELECT * FROM ${DatabaseConstants.TABLE_CHANGE_LOG} WHERE name = :tag LIMIT 1")
    fun getChangeLogBy(tag: String): ChangeLog?

    @Update
    fun updateAll(vararg users: ChangeLog)
}