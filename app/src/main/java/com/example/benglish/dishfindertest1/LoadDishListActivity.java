package com.example.benglish.dishfindertest1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.benglish.dishfindertest1.Adapters.ShowDishRecyclerViewAdapter;
import com.example.benglish.dishfindertest1.models.DishList;

public class LoadDishListActivity extends AppCompatActivity implements ILoadDishListActivity {

    private RecyclerView dishRecyclerView;
    private DishList dishList;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_load_dish_list );

        dishList = (DishList) getIntent().getSerializableExtra( "selected_dishes" );


        dishRecyclerView = findViewById( R.id.show_dish_rv );

        dishRecyclerView.setLayoutManager( new LinearLayoutManager( LoadDishListActivity.this, LinearLayoutManager.VERTICAL, false ) );

        ShowDishRecyclerViewAdapter showDishRecyclerViewAdapter =
                new ShowDishRecyclerViewAdapter( dishList.getDishes(), LoadDishListActivity.this );
        dishRecyclerView.setAdapter( showDishRecyclerViewAdapter );

    }

    @Override
    public void loadDishRecipeFragment() {
        DishRecipeFragment dishRecipeFragment= new DishRecipeFragment();
        getSupportFragmentManager().beginTransaction().add( R.id.dish_recipe_container, dishRecipeFragment )
                .commit();
    }


}

