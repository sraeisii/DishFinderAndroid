package com.example.benglish.dishfindertest1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.benglish.dishfindertest1.Data.DishFinderAPI;
import com.example.benglish.dishfindertest1.Data.GetIngredientController;
import com.example.benglish.dishfindertest1.models.Ingredient;

import java.util.ArrayList;

public class DiaryFragment extends Fragment {

    private RecyclerView ingredientRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_diary, container,false );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

        ingredientRecyclerView= view.findViewById(R.id.diary_ingredient_rv);

        GetIngredientController getIngredientController= new GetIngredientController(getIngredientCallback);
        getIngredientController.start( "Diary" );

    }

    DishFinderAPI.GetIngredientCallback getIngredientCallback= new DishFinderAPI.GetIngredientCallback() {
        @Override
        public void onResponse(ArrayList<Ingredient> ingredients) {

            LinearLayoutManager linearLayout= new LinearLayoutManager( getContext() , LinearLayoutManager.VERTICAL,false );
            ingredientRecyclerView.setLayoutManager( linearLayout );

            IngredientRecyclerViewAdapter ingredientRecyclerViewAdapter=
                    new IngredientRecyclerViewAdapter( ingredients);
            ingredientRecyclerView.setAdapter( ingredientRecyclerViewAdapter );
        }

        @Override
        public void onFailure(String cause) {
            Toast.makeText( getContext(), "Error", Toast.LENGTH_SHORT );
        }
    };
}
