package com.sample.nytimes.data.beans

import org.apache.commons.lang.StringUtils
import org.apache.commons.lang.math.NumberUtils

data class Media(
    var approved_for_syndication: Int? = NumberUtils.INTEGER_ZERO,
    var caption: String? = StringUtils.EMPTY,
    var copyright: String? = StringUtils.EMPTY,
    var `media-metadata`: List<MediaMetadata>? = listOf(),
    var subtype: String? = StringUtils.EMPTY,
    var type: String? = StringUtils.EMPTY
)