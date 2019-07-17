package com.example.benglish.dishfindertest1.Data;

import com.example.benglish.dishfindertest1.models.Dish;
import com.example.benglish.dishfindertest1.models.Ingredient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DishFinderAPI {

    String BASE_URL="http://10.0.2.2:9100/api/";

    @GET("ingredient/getByIngredientType")
    Call<ArrayList<Ingredient>> getIngredient(@Query( "ingredientType" ) String ingredientType);

    interface GetIngredientCallback{
        void onResponse(ArrayList<Ingredient> ingredients);
        void onFailure(String cause);
    }

    @POST("dish/getDishesByIngredients")
    Call<ArrayList<Dish>> getDishByIngredients(@Body ArrayList<Integer> includedIngredientIds);

    interface getDishByIngredientsCallback{

        void onResponse(ArrayList<Dish> dishes);
        void onFailure(String cause);
    }

}
