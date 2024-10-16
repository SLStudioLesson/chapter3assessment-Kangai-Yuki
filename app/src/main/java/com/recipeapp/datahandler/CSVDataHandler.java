package com.recipeapp.datahandler;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVDataHandler implements DataHandler {
    private String filePath; // レシピデータを格納するCSVファイルのパス

    // デフォルトコンストラクタ
    public CSVDataHandler() {
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    // 引数を持つコンストラクタ
    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getMode() {
        return "CSV";
    }

    @Override
    public ArrayList<Recipe> readData() throws IOException {
        ArrayList<Recipe> recipes = new ArrayList<>(); // レシピのリストを作成
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // カンマで分割
                String name = parts[0]; // レシピ名
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    ingredients.add(new Ingredient(parts[i].trim())); // 材料をリストに追加
                }
                recipes.add(new Recipe(name, ingredients)); // Recipeオブジェクトをリストに追加
            }
        }
        return recipes; // レシピのリストを返す
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(recipe.getName()); // レシピ名を書き込み
            for (Ingredient ingredient : recipe.getIngredients()) {
                bw.write("," + ingredient.getName()); // 材料を書き込み
            }
            bw.newLine(); // 次の行に移動
        }
    }

    @Override
    public ArrayList<Recipe> searchData(String keyword) throws IOException {
        // 後の実装で処理を追加
        return null;
    }
}

