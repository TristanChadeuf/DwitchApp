package model

data class Ingredient (
    val id: Long,
    val documentId: String,
    val name: String,
    val description: String,
    val isVegan: Boolean? = null,
    val isSpicy: Boolean? = null,
    val kind: String,
    val createdAt: String,
    val updatedAt: String,
    val publishedAt: String

)
{
    fun getEmoji(): String {
        val ingredientKind = IngredientKind.fromString(kind)
        return ingredientKind.emoji
    }


    fun getColor(): String {
        val ingredientKind = IngredientKind.fromString(kind)
        return ingredientKind.color
    }
}

enum class IngredientKind(val emoji: String, val color: String) {
    MAIN("🍖", "#FA5252"),
    TOPPING("🥗", "#37B24D"),
    BREAD("🍞", "#E8590C"),
    SAUCE("🧂", "#F59F00"),
    UNKNOWN("❓", "#364FC7");

    companion object {
        // Retrieve the enum constant from a string (safe handling)
        fun fromString(kind: String?): IngredientKind {
            return values().find { it.name.equals(kind, ignoreCase = true) } ?: UNKNOWN
        }
    }
}


