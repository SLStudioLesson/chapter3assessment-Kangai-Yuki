package com.recipeapp.ui;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                    displayRecipes();
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private void displayRecipes() {
        try {
            ArrayList<Recipe> recipes = dataHandler.readData(); // データハンドラーからレシピデータを取得
    
            if (recipes.isEmpty()) {
                System.out.println("No recipes available."); // レシピが存在しない場合
            } else {
                System.out.println("Recipes:"); // レシピが存在する場合
                System.out.println("-----------------------------------");
                for (Recipe recipe : recipes) {
                    System.out.println("Recipe Name: " + recipe.getName());
                    
                    // 材料名をカンマ区切りで整形
                    List<String> ingredientNames = new ArrayList<>();
                    for (Ingredient ingredient : recipe.getIngredients()) {
                        ingredientNames.add(ingredient.getName());
                    }
                    System.out.println("Main Ingredients: " + String.join(", ", ingredientNames));
                    System.out.println("-----------------------------------");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage()); // エラーメッセージの表示
        }
    }
}
