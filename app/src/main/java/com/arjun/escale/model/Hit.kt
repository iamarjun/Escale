package com.arjun.escale.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hit(
    @Json(name = "author")
    val author: String = "",
    @Json(name = "comment_text")
    val commentText: Any? = null,
    @Json(name = "created_at")
    val createdAt: String = "",
    @Json(name = "created_at_i")
    val createdAtI: Int = 0,
    @Json(name = "_highlightResult")
    val highlightResult: HighlightResult = HighlightResult(),
    @Json(name = "num_comments")
    val numComments: Int = 0,
    @Json(name = "objectID")
    val objectID: String = "",
    @Json(name = "parent_id")
    val parentId: Any? = null,
    @Json(name = "points")
    val points: Int = 0,
    @Json(name = "story_id")
    val storyId: Any? = null,
    @Json(name = "story_text")
    val storyText: Any? = null,
    @Json(name = "story_title")
    val storyTitle: Any? = null,
    @Json(name = "story_url")
    val storyUrl: Any? = null,
    @Json(name = "_tags")
    val tags: List<String> = listOf(),
    @Json(name = "title")
    val title: String = "",
    @Json(name = "url")
    val url: String? = null
)