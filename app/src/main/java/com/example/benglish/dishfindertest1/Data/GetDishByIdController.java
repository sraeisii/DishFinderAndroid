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

public class GetDishByIdController {
    private DishFinderAPI.getDishByIdCallback getDishByIdCallback;

    public GetDishByIdController(DishFinderAPI.getDishByIdCallback getDishByIdCallback) {
        this.getDishByIdCallback = getDishByIdCallback;
    }

    public void start(Dish dish){
        Retrofit retrofit= new Retrofit.Builder().baseUrl( DishFinderAPI.BASE_URL ).
                addConverterFactory( GsonConverterFactory.create() ).build();

        DishFinderAPI dishFinderAPI=retrofit.create( DishFinderAPI.class );
        Call<Dish> call = dishFinderAPI.getDishById( dish );
        call.enqueue( new Callback<Dish>() {
            @Override
            public void onResponse(Call<Dish> call, Response<Dish> response) {
                getDishByIdCallback.onResponse( response.body() );

            }

            @Override
            public void onFailure(Call<Dish> call, Throwable t) {
                Integer y = 0;
            }
        } );
    }
}
