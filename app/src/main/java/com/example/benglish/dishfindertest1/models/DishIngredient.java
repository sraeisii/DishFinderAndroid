package com.example.benglish.dishfindertest1.models;

import java.io.Serializable;

public class DishIngredient implements Serializable {
    private String ingredientTitle;
    private int dishIngredientId;
    private float quantity;
    private UnitType unitType;
    private String imageBinary;

    public String getImageBinary() {
        return imageBinary;
    }

    public void setImageBinary(String imageBinary) {
        this.imageBinary = imageBinary;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public String getIngredientTitle() {
        return ingredientTitle;
    }

    public void setIngredientTitle(String ingredientTitle) {
        this.ingredientTitle = ingredientTitle;
    }

    public int getDishIngredientId() {
        return dishIngredientId;
    }

    public void setDishIngredientId(int dishIngredientId) {
        this.dishIngredientId = dishIngredientId;
    }
}
