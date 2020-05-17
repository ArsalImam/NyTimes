package com.sample.nytimes.utils

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 */
object ApiConstants {
    object Request {
        const val PAGE = "page"
        const val API_KEY = "api-key"
    }

    const val LIST_FEEDS = "/svc/mostpopular/v2/viewed/{page}.json"
}