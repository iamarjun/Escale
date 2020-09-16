package com.arjun.escale.repository

import androidx.paging.PagingSource
import com.arjun.escale.RestApi
import com.arjun.escale.model.Hit
import retrofit2.HttpException
import java.io.IOException

class HitPagingSource(private val tags: String, private val restApi: RestApi) :
    PagingSource<Int, Hit>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hit> {
        val position = params.key ?: PAGE

        return try {
            val response = restApi.getHits(tags, position)
            val list = response.hits

            LoadResult.Page(
                data = list,
                prevKey = if (position == PAGE) null else position - 1,
                nextKey = if (list.isEmpty()) null else position + 1
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val PAGE = 1
    }
}