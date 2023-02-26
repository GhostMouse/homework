package lina.model

import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    val id: Int,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)