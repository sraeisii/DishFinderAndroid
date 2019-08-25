package com.example.benglish.dishfindertest1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.benglish.dishfindertest1.Adapters.DishIngredientRecyclerViewAdapter;
import com.example.benglish.dishfindertest1.Adapters.MyRecyclerViewAdapter;
import com.example.benglish.dishfindertest1.Data.DishFinderAPI;
import com.example.benglish.dishfindertest1.Data.GetDishByIdController;
import com.example.benglish.dishfindertest1.models.Dish;
import com.example.benglish.dishfindertest1.models.DishIngredient;

import java.util.ArrayList;

public class DishRecipeFragment extends Fragment {
    Integer dishId;
    RecyclerView dishIngredientsRecyclerView;
    private ImageView wideDishImage;
    private TextView dishRecipe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dishId = getArguments().getInt( "dish_id" );
        return inflater.inflate( R.layout.fragment_dish_recipe, container, false );

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

        LinearLayoutManager linearLayout = new LinearLayoutManager( getContext(), LinearLayoutManager.HORIZONTAL, true );
        linearLayout.setReverseLayout( true );
        dishIngredientsRecyclerView = view.findViewById( R.id.dish_ingredient_list );
        dishIngredientsRecyclerView.setLayoutManager( linearLayout );

        GetDishByIdController getDishByIdController = new GetDishByIdController( getDishByIdCallback );
        Dish inputDish = new Dish(  );
        inputDish.setId( dishId );
        getDishByIdController.start( inputDish );
        wideDishImage=view.findViewById( R.id.wide_dish_image );
        dishRecipe=view.findViewById( R.id.dish_recipe );
    }

    DishFinderAPI.getDishByIdCallback getDishByIdCallback = new DishFinderAPI.getDishByIdCallback() {
        @Override
        public void onResponse(Dish dishes) {
            ArrayList<DishIngredient> dishIngredients = dishes.getDishDetailsDto().getDishIngredients();


            DishIngredientRecyclerViewAdapter recyclerViewAdapter = new DishIngredientRecyclerViewAdapter( dishIngredients, getContext() );
            dishIngredientsRecyclerView.setAdapter( recyclerViewAdapter );


            byte[] imageByteArray = Base64.decode(dishes.getImageBinary(), Base64.DEFAULT);
            Glide.with(getContext()).asBitmap().load( imageByteArray).into( wideDishImage );

        }

        @Override
        public void onFailure(String cause) {

        }
    };
}
