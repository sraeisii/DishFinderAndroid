package com.example.benglish.dishfindertest1;

import com.example.benglish.dishfindertest1.models.Ingredient;

import java.util.ArrayList;

public interface IMainActivity {

     ArrayList<Ingredient> selectedIngredients = new ArrayList<>(  );

     ArrayList<Ingredient> getSelectedIngredients();
     void setSelectedIngredients(Ingredient ingredient);
     void removeSelectedIngredient(Ingredient ingredient);
     Boolean isIngredientChecked(Ingredient ingredient);


    void loadDiaryFragment();

    void loadVegetableFragment();

    void loadMeatFragment();

    void loadBeanFragment();

}
