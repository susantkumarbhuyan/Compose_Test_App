package com.zerocoder.api

import com.zerocoder.models.TweetsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {

    @GET("/v3/b/64e33f1a9d312622a3946eac?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category:String): Response<List<TweetsItem>>
    //@Headers("X-JSON-Path: tweets..category")
    @GET("/v3/b/64e33f1a9d312622a3946eac?meta=false")
    suspend fun getCategories(@Header("X-JSON-Path") category:String): Response<List<String>>
}