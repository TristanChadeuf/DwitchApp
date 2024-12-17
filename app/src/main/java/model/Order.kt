package model

data class Order (
    val id: Long,
    val documentId: String,
    val placedAt: String,
    val receivedAt: String,
    val cookMessage: String,
    val price: Long,
    val progress: Long,
    val createdAt: String,
    val updatedAt: String,
    val publishedAt: String,
    val ingredients: List<Ingredient>,
    val usersPermissionsUser: UsersPermissionsUser,
    val store: Store
)
