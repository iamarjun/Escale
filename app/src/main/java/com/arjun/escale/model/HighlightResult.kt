package com.arjun.escale.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HighlightResult(
    @Json(name = "author")
    val author: Author = Author(),
    @Json(name = "story_text")
    val storyText: StoryText = StoryText(),
    @Json(name = "title")
    val title: Title = Title(),
    @Json(name = "url")
    val url: Url = Url()
)