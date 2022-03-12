package com.sample.nytimes.data.sources.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sample.nytimes.data.beans.FeedCommentPost
import com.sample.nytimes.utils.DatabaseConstants
import java.util.*

@Dao
interface FeedCommentDao {

    @Query("SELECT * FROM ${DatabaseConstants.TABLE_FEEDS_COMMENTS} WHERE createdTime >= :changeLogTime")
    fun getAllLocalComments(changeLogTime: Date): List<FeedCommentPost>

    @Insert
    fun insertAll(vararg users: FeedCommentPost)
}