package com.arjun.escale.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hit(
    @Json(name = "objectID")
    val objectID: String = "",
    @Json(name = "title")
    val title: String = "",
    var isSelected: Boolean = false
)