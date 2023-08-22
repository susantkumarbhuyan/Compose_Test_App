package com.zerocoder.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zerocoder.repo.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CategoryViewModel @Inject constructor(val tweetsRepository: TweetsRepository) : ViewModel() {
    val categories: StateFlow<List<String>>
        get() = tweetsRepository.categories

    init {
        viewModelScope.launch {
            tweetsRepository.getCategories()
        }
    }
}