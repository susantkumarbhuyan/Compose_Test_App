package com.zerocoder.repo

import com.zerocoder.api.TweetsyAPI
import com.zerocoder.models.TweetsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsRepository @Inject constructor(val tweetsyAPI: TweetsyAPI) {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<TweetsItem>>(emptyList())
    val tweets: StateFlow<List<TweetsItem>>
        get() = _tweets

    suspend fun getCategories() {
        val response = tweetsyAPI.getCategories("tweets..category")
        _categories.emit(response.body()!!)
    }

    suspend fun getTweets(category: String) {
        val response = tweetsyAPI.getTweets("tweets[?(@.category==\"$category\")]")
        _tweets.emit(response.body()!!)
    }

}