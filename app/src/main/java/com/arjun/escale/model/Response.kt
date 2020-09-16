package com.arjun.escale.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
    @Json(name = "hits")
    val hits: List<Hit> = listOf()
)