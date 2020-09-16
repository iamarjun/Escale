package com.arjun.escale.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.arjun.escale.RestApi
import com.arjun.escale.model.Hit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HitRepository @Inject constructor(private val restApi: RestApi) {
    fun getHits(): Flow<PagingData<Hit>> = Pager(
        config = PagingConfig(pageSize = 30),
        pagingSourceFactory = { HitPagingSource("story", restApi) }
    ).flow
}