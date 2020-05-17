package com.sample.nytimes.generics

import com.sample.nytimes.utils.Callback
import org.apache.commons.lang.StringUtils
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020

 * Generic Retrofit Call Back to receive Network Call response and send that to previous Layer
 */
class GenericNetworkCallback<T, A : BaseResponse<T>>(val callback: Callback<T>) :
    retrofit2.Callback<A> {
    override fun onFailure(call: Call<A>, t: Throwable) {
        t.printStackTrace()
        callback.onError(t.localizedMessage ?: StringUtils.EMPTY)
    }

    override fun onResponse(call: Call<A>, response: Response<A>) {
        //handle success
        if (response.isSuccessful) {
            response.body()?.let {
                if (it.isSuccess) {
                    it.data?.let { it1 -> callback.onResult(it1) }
                } else {
                    it.error?.let { it1 -> callback.onError(it1) }
                }
            }
            return
        }

        //handle failure
        val errorBody = response.errorBody()
        if (errorBody != null) {
            callback.onError(errorBody.string())
            println(errorBody.string())
        } else {
            callback.onError("Something went wrong!")
        }

    }
}