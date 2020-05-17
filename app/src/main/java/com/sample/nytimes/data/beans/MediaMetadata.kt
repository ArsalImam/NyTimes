package com.sample.nytimes.data.beans

import org.apache.commons.lang.StringUtils
import org.apache.commons.lang.math.NumberUtils

data class MediaMetadata(
    var format: String? = StringUtils.EMPTY,
    var height: Int? = NumberUtils.INTEGER_ZERO,
    var url: String? = StringUtils.EMPTY,
    var width: Int? = NumberUtils.INTEGER_ZERO
)