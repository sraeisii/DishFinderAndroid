package com.example.benglish.dishfindertest1.models;

import java.io.Serializable;
import java.util.ArrayList;

public class DishDetail implements Serializable {
    private Integer cookingTime;
    private ArrayList<DietType> dietTypes;
    private ArrayList<Region> regions;
    private MealType mealType;
    private ArrayList<DishIngredient> dishIngredients;
    private int numberOfPeople;
    private String rawRecipe;

    public String getRawRecipe() {
        return rawRecipe;
    }

    public void setRawRecipe(String rawRecipe) {
        this.rawRecipe = rawRecipe;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public ArrayList<DishIngredient> getDishIngredients() {
        return dishIngredients;
    }

    public void setDishIngredients(ArrayList<DishIngredient> dishIngredients) {
        this.dishIngredients = dishIngredients;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public ArrayList<DietType> getDietTypes() {
        return dietTypes;
    }

    public void setDietTypes(ArrayList<DietType> dietTypes) {
        this.dietTypes = dietTypes;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }


}
