package lina.model

import kotlinx.serialization.Serializable

@Serializable
data class Album (
    val id: Int,
    val userId: Int,
    val title: String
)