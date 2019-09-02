package com.example.benglish.dishfindertest1.Data;

import com.example.benglish.dishfindertest1.models.Dish;
import com.example.benglish.dishfindertest1.models.Ingredient;
import com.example.benglish.dishfindertest1.models.IngredientIdList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DishFinderAPI {

//    String BASE_URL="http://10.0.2.2:9100/api/";
    String BASE_URL="http://192.168.1.183:9100/api/";

    @GET("ingredient/getByIngredientType")
    Call<ArrayList<Ingredient>> getIngredient(@Query( "ingredientType" ) String ingredientType);

    interface GetIngredientCallback{
        void onResponse(ArrayList<Ingredient> ingredients);
        void onFailure(String cause);
    }

    @POST("dish/getDishesByIngredients")
    Call<ArrayList<Dish>> getDishByIngredients(@Body IngredientIdList includedIngredientIds);

    interface getDishByIngredientsCallback{

        void onResponse(ArrayList<Dish> dishes);
        void onFailure(String cause);
    }

    @POST("dish/getDishById")
    Call<Dish> getDishById (@Body Dish dish);

    interface  getDishByIdCallback{

        void onResponse(Dish dishes);
        void onFailure(String cause);
    }

}
