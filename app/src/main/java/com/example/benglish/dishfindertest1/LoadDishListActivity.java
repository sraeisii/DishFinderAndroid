package com.example.benglish.dishfindertest1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.benglish.dishfindertest1.Adapters.ShowDishRecyclerViewAdapter;
import com.example.benglish.dishfindertest1.Data.DishFinderAPI;
import com.example.benglish.dishfindertest1.Data.GetDishByIngredientsController;
import com.example.benglish.dishfindertest1.models.Dish;
import com.example.benglish.dishfindertest1.models.DishList;
import com.example.benglish.dishfindertest1.models.IngredientIdList;

import java.util.ArrayList;

public class LoadDishListActivity extends AppCompatActivity implements ILoadDishListActivity {

    private RecyclerView dishRecyclerView;
    ArrayList<Integer>  selectedIngredientIds;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_load_dish_list );

        selectedIngredientIds= (ArrayList<Integer>) getIntent().getSerializableExtra( "selected_ingredientIds" );

        IngredientIdList ingredientIdList = new IngredientIdList();
        ingredientIdList.setItems( selectedIngredientIds );


        GetDishByIngredientsController getDishByIngredientsController=
                new GetDishByIngredientsController(getDishByIngredientsCallback);
        getDishByIngredientsController.start(ingredientIdList);


        dishRecyclerView = findViewById( R.id.show_dish_rv );

        dishRecyclerView.setLayoutManager( new LinearLayoutManager( LoadDishListActivity.this, LinearLayoutManager.VERTICAL, false ) );

    }

    @Override
    public void loadDishRecipeFragment(Integer dishId) {
        DishRecipeFragment dishRecipeFragment= new DishRecipeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("dish_id",dishId);
        dishRecipeFragment.setArguments( bundle );
        getSupportFragmentManager().beginTransaction().add( R.id.dish_recipe_container, dishRecipeFragment )
                .commit();
    }
    DishFinderAPI.getDishByIngredientsCallback getDishByIngredientsCallback = new DishFinderAPI.getDishByIngredientsCallback() {
        @Override
        public void onResponse(ArrayList<Dish> dishes) {
            try{
                DishList dishList= new DishList(dishes );
                ShowDishRecyclerViewAdapter showDishRecyclerViewAdapter =
                        new ShowDishRecyclerViewAdapter( dishList.getDishes(), LoadDishListActivity.this );
                dishRecyclerView.setAdapter( showDishRecyclerViewAdapter );



            }
            catch (Exception e)
            {
                Log.d("TAG",e.getMessage());
            }
        }

        @Override
        public void onFailure(String cause) {

        }
    };

}


