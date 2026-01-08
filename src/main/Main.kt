import model.Ingredient
import model.RecipeType
import recipe.BakingRecipe
import recipe.NonVegetarianRecipe
import recipe.VegetarianRecipe
import recipe.Recipe
import search.RecipeSearch
import java.util.Scanner

fun main() {
    // Create ingredients (Criterion: Data Class)
    val cheese = Ingredient("Cheese")
    val flour = Ingredient("Flour")
    val meat = Ingredient("Meat")

    // Create recipes (Criterion: Inheritance)
    val pizza = VegetarianRecipe("Pizza", listOf(cheese, flour), "Bake at 400F")
    val burger = NonVegetarianRecipe("Burger", listOf(meat, flour), "Grill it")
    val cake = BakingRecipe("Cake", listOf(flour), "Mix and bake")

    val allRecipes = listOf(pizza, burger, cake)
    val searcher = RecipeSearch()
    val scanner = Scanner(System.`in`)

    var running = true

    // Criterion: Menu (While loop)
    while (running) {
        println("\n--- Simple Cooking App ---")
        println("1. List Recipes")
        println("2. Search by Name")
        println("3. Search by Ingredient")
        println("4. Exit")
        print("Choose: ")

        // Criterion: Error Handling (Try-Catch)
        try {
            val input = scanner.next()
            val choice = input.toInt()

            when (choice) {
                1 -> {
                    for (r in allRecipes) {
                        r.display()
                        // Criterion: Polymorphism
                        if (r is recipe.CookingMethod) {
                            println("Time: ${r.getCookingTime()}")
                        }
                    }
                }
                2 -> {
                    print("Enter Name: ")
                    val name = scanner.next()
                    val result = searcher.searchByName(allRecipes, name)
                    if (result != null) {
                        println("Found: ${result.name}")
                    } else {
                        println("Not found.")
                    }
                }
                3 -> {
                    print("Enter Ingredient: ")
                    val ing = scanner.next()
                    val results = searcher.searchByIngredient(allRecipes, ing)
                    for (r in results) {
                        println("Found: ${r.name}")
                    }
                }
                4 -> running = false
                else -> println("Invalid number")
            }
        } catch (e: Exception) {
            println("Error: Please enter a valid number.")
        }
    }
}
