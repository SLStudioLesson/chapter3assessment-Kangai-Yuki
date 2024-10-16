package com.recipeapp.model;

public class Ingredient {
    private String name;  // 材料の名前

    // コンストラクタ
    public Ingredient(String name) {
        this.name = name;
    }

    // nameフィールドを返すメソッド
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name; // Ingredientを文字列として表示できるようにする
    }
}
