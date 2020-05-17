package com.sample.nytimes.generics

import org.apache.commons.lang.StringUtils

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 */
open class BaseResponse<T> {
    val error: String? = StringUtils.EMPTY
    val status: String? = StringUtils.EMPTY
    val data: T? = null

    val isSuccess
        get() = StringUtils.equals(status, "OK")
}