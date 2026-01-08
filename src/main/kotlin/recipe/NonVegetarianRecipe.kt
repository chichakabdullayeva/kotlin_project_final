package recipe

import model.Ingredient

// Criterion: Inheritance (Child Class)
class NonVegetarianRecipe(
    name: String,
    ingredients: List<Ingredient>,
    instructions: String
) : Recipe(name, ingredients, instructions)
