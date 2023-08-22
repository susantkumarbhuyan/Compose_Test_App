package com.zerocoder.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zerocoder.models.TweetsItem
import com.zerocoder.repo.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val tweetsRepository: TweetsRepository, val savedStateHandle: SavedStateHandle) : ViewModel() {
    val tweets: StateFlow<List<TweetsItem>>
        get() = tweetsRepository.tweets

    init {
        viewModelScope.launch {
           val category = savedStateHandle.get<String>("category")?:"motivation"
            tweetsRepository.getTweets(category)
        }
    }
}