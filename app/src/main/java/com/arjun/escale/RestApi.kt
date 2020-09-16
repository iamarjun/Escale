package com.arjun.escale

import com.arjun.escale.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("search_by_date")
    suspend fun searchRecipe(
        @Query("tags") tags: String,
        @Query("page") page: Int
    ): Response

}