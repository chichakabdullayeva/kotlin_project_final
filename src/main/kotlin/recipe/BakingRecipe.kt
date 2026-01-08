package recipe

import model.Ingredient

// Criterion: Inheritance & Polymorphism
class BakingRecipe(
    name: String,
    ingredients: List<Ingredient>,
    instructions: String
) : Recipe(name, ingredients, instructions), CookingMethod {

    // Criterion: Polymorphism (Different logic)
    override fun getCookingTime(): String {
        return "45 minutes in the oven"
    }
}
