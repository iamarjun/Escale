package com.arjun.escale.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Author(
    @Json(name = "matchLevel")
    val matchLevel: String = "",
    @Json(name = "matchedWords")
    val matchedWords: List<Any> = listOf(),
    @Json(name = "value")
    val value: String = ""
)