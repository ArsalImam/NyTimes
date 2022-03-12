package com.sample.nytimes.utils

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * api constants for the app
 */
object ApiConstants {
    object Request {
        const val PAGE = "page"
        const val API_KEY = "api-key"
        const val STATUS_SUCCESS = "OK"
    }

    object ErrorMessage {
        const val SOMETHING_WENT_WRONGE = "Something went wrong!"
    }

    const val LIST_FEEDS = "/svc/mostpopular/v2/viewed/{page}.json"
    const val POST_COMMENTS = "/feed/comments"

}