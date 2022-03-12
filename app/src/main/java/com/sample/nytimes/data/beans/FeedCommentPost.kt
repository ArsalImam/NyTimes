package com.sample.nytimes.data.beans

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sample.nytimes.utils.Constants.DELIMITER_CATEGORY
import com.sample.nytimes.utils.DatabaseConstants
import kotlinx.android.parcel.Parcelize
import org.apache.commons.collections4.CollectionUtils
import org.apache.commons.lang.StringUtils
import org.apache.commons.lang.math.NumberUtils
import java.util.*

@Parcelize
@Entity(tableName = DatabaseConstants.TABLE_FEEDS_COMMENTS)
data class FeedCommentPost(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "feedId") var feedId: String? = StringUtils.EMPTY,
    @ColumnInfo(name = "commentText") var commentText: String? = StringUtils.EMPTY,
    @ColumnInfo(name = "createdTime") var createdTime: Date? = Date()
) : Parcelable