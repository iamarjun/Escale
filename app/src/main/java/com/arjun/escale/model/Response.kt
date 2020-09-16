package com.arjun.escale.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
    @Json(name = "exhaustiveNbHits")
    val exhaustiveNbHits: Boolean = false,
    @Json(name = "hits")
    val hits: List<Hit> = listOf(),
    @Json(name = "hitsPerPage")
    val hitsPerPage: Int = 0,
    @Json(name = "nbHits")
    val nbHits: Int = 0,
    @Json(name = "nbPages")
    val nbPages: Int = 0,
    @Json(name = "page")
    val page: Int = 0,
    @Json(name = "params")
    val params: String = "",
    @Json(name = "processingTimeMS")
    val processingTimeMS: Int = 0,
    @Json(name = "query")
    val query: String = ""
)