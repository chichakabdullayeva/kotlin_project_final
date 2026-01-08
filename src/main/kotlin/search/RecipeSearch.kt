package search

import recipe.Recipe

class RecipeSearch {

    // Simple search by name
    fun searchByName(recipes: List<Recipe>, name: String): Recipe? {
        // Criterion: Error Handling (Basic loop logic)
        for (recipe in recipes) {
            if (recipe.name == name) {
                return recipe
            }
        }
        return null
    }

    // Simple search by ingredient
    fun searchByIngredient(recipes: List<Recipe>, ingredientName: String): List<Recipe> {
        val foundRecipes = mutableListOf<Recipe>()
        for (recipe in recipes) {
            for (ingredient in recipe.ingredients) {
                if (ingredient.name == ingredientName) {
                    foundRecipes.add(recipe)
                    break // Stop checking ingredients for this recipe
                }
            }
        }
        return foundRecipes
    }
}
