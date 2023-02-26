package lina.model

import kotlinx.serialization.Serializable

@Serializable
data class AlbumInput (
    val userId: Int,
    val title: String
)
