package com.example.benglish.dishfindertest1.Data;

import android.util.Log;

import com.example.benglish.dishfindertest1.models.Ingredient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetIngredientController {

    DishFinderAPI.GetIngredientCallback getIngredientCallback;

    public GetIngredientController(DishFinderAPI.GetIngredientCallback getIngredientCallback) {
        this.getIngredientCallback = getIngredientCallback;
    }

    public void start(String ingredientType){
        Retrofit retrofit= new Retrofit.Builder().baseUrl( DishFinderAPI.BASE_URL ).
                addConverterFactory( GsonConverterFactory.create( )).
                build();

        DishFinderAPI dishFinderAPI= retrofit.create( DishFinderAPI.class );
        Call<ArrayList<Ingredient>> call = dishFinderAPI.getIngredient( ingredientType );
        call.enqueue( new Callback<ArrayList<Ingredient>>() {
            @Override
            public void onResponse(Call<ArrayList<Ingredient>> call, Response<ArrayList<Ingredient>> response) {
                Log.d("TAG", "onResponse "+response.code());
                getIngredientCallback.onResponse( response.body() );
            }

            @Override
            public void onFailure(Call<ArrayList<Ingredient>> call, Throwable t) {
                Log.d("TAG", "onFailure "+t.getCause());
            }
        } );
    }
}
