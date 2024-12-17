package model

data class Store (
    val id: Long,
    val documentId: String,
    val name: String,
    val isOpen: Boolean,
    val city: String,
    val zipCode: String,
    val createdAt: String,
    val updatedAt: String,
    val publishedAt: String

)