package com.example.benglish.dishfindertest1.Data;

import android.util.Log;

import com.example.benglish.dishfindertest1.models.Dish;
import com.example.benglish.dishfindertest1.models.IngredientIdList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetDishByIngredientsController {

    private DishFinderAPI.getDishByIngredientsCallback getDishByIngredientsCallback;

    public GetDishByIngredientsController(DishFinderAPI.getDishByIngredientsCallback getDishByIngredientsCallback) {
        this.getDishByIngredientsCallback = getDishByIngredientsCallback;
    }


    public void start(IngredientIdList includedIngredientIds){
        Retrofit retrofit= new Retrofit.Builder().baseUrl( DishFinderAPI.BASE_URL ).
                addConverterFactory( GsonConverterFactory.create() ).build();

        DishFinderAPI dishFinderAPI=retrofit.create( DishFinderAPI.class );
        Call<ArrayList<Dish>> call = dishFinderAPI.getDishByIngredients( includedIngredientIds );
        call.enqueue( new Callback<ArrayList<Dish>>() {
            @Override
            public void onResponse(Call<ArrayList<Dish>> call, Response<ArrayList<Dish>> response) {
                Log.d("TAG", "onResponse "+response.code());
                getDishByIngredientsCallback.onResponse( response.body() );
            }

            @Override
            public void onFailure(Call<ArrayList<Dish>> call, Throwable t) {

            }
        } );
    }




}
