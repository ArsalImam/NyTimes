package com.sample.nytimes.data.beans

import org.apache.commons.lang.StringUtils
import org.apache.commons.lang.math.NumberUtils

data class Feed(
    var `abstract`: String? = StringUtils.EMPTY,
    var adx_keywords: String? = StringUtils.EMPTY,
    var asset_id: Long? = NumberUtils.LONG_ZERO,
    var byline: String? = StringUtils.EMPTY,
    var column: Any? = Any(),
    var des_facet: List<String>? = listOf(),
    var eta_id: Int? = NumberUtils.INTEGER_ZERO,
    var geo_facet: List<Any>? = listOf(),
    var id: Long? =  NumberUtils.LONG_ZERO,
    var media: List<Media>? = listOf(),
    var nytdsection: String? = StringUtils.EMPTY,
    var org_facet: List<Any>? = listOf(),
    var per_facet: List<Any>? = listOf(),
    var published_date: String? = StringUtils.EMPTY,
    var section: String? = StringUtils.EMPTY,
    var source: String? = StringUtils.EMPTY,
    var subsection: String? = StringUtils.EMPTY,
    var title: String? = StringUtils.EMPTY,
    var type: String? = StringUtils.EMPTY,
    var updated: String? = StringUtils.EMPTY,
    var uri: String? = StringUtils.EMPTY,
    var url: String? = StringUtils.EMPTY
)