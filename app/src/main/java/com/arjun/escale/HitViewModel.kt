package com.arjun.escale

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.arjun.escale.model.Hit
import com.arjun.escale.repository.HitRepository
import kotlinx.coroutines.flow.Flow

class HitViewModel @ViewModelInject constructor(private val repository: HitRepository) :
    ViewModel() {

    val hits: Flow<PagingData<Hit>>
        get() = repository.getHits()
            .cachedIn(viewModelScope)
}