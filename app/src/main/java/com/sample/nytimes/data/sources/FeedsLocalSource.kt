package com.sample.nytimes.data.sources

import com.sample.nytimes.data.beans.FeedCommentPost
import com.sample.nytimes.di.LocalModule
import com.sample.nytimes.utils.AppDatabase
import java.util.*

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * network datasource for feeds
 */
class FeedsLocalSource {

    var changeLogTag: String = FeedCommentPost::class.java.name
    var appDatabase: AppDatabase = LocalModule.provideRoom()

    fun postComment(comment: FeedCommentPost) =  appDatabase.feedDao().insertAll(comment)

    fun getSavedComments(): List<FeedCommentPost> {
        appDatabase.apply {
            changeLogDao().getChangeLogBy(changeLogTag)?.let {
                return feedDao().getAllLocalComments(it.changeLogTime)
            }
        }
        return emptyList()
    }
}