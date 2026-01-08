package recipe

import model.Ingredient

// Criterion: Inheritance (Abstract Parent)
abstract class Recipe(
    val name: String,
    val ingredients: List<Ingredient>,
    val instructions: String
) {
    // Just a helper to print details
    open fun display() {
        println("Recipe: $name")
        println("Instructions: $instructions")
    }
}
