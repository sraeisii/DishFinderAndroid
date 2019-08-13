package com.example.benglish.dishfindertest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.benglish.dishfindertest1.Adapters.MyRecyclerViewAdapter;
import com.example.benglish.dishfindertest1.Data.DishFinderAPI;
import com.example.benglish.dishfindertest1.Data.GetDishByIngredientsController;
import com.example.benglish.dishfindertest1.models.Dish;
import com.example.benglish.dishfindertest1.models.DishList;
import com.example.benglish.dishfindertest1.models.IngredientIdList;

import java.util.ArrayList;

public class FoodSearchFragment extends Fragment {

    private static final String TAG="FoodSearch";

    private Button searchBtn;
    private IMainActivity iMainActivity;
    private ArrayList<String> mNames= new ArrayList<>(  );
    private ArrayList<String> mImageUrls= new ArrayList<>(  );
    private ArrayList<String> mFaNames= new ArrayList<>(  );


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_food_search,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getImages(view);
        findViews( view );
        configureViews();



       // Load DiaryFragment
        iMainActivity= (IMainActivity) getActivity();
        iMainActivity.loadDiaryFragment();


    }

    private  void findViews(View view){
        searchBtn=view.findViewById( R.id.search_btn );

    }
    private void configureViews(){

        searchBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Integer> selectedIngredientIds= new ArrayList<>(  );
                for (int i=0; i< iMainActivity.getSelectedIngredients().size(); i++){
                    selectedIngredientIds.add( iMainActivity.getSelectedIngredients().get( i ).getId() );
                }

                IngredientIdList ingredientIdList = new IngredientIdList();
                ingredientIdList.setItems( selectedIngredientIds );


                GetDishByIngredientsController getDishByIngredientsController=
                        new GetDishByIngredientsController(getDishByIngredientsCallback);
                getDishByIngredientsController.start(ingredientIdList);

            }
        } );
    }
    DishFinderAPI.getDishByIngredientsCallback getDishByIngredientsCallback = new DishFinderAPI.getDishByIngredientsCallback() {
        @Override
        public void onResponse(ArrayList<Dish> dishes) {
            try{
                DishList dishList= new DishList(dishes );

                Intent intent = new Intent( getActivity(), LoadDishListActivity.class );
                intent.putExtra("selected_dishes", dishList );
                startActivity( intent );

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

    private void getImages(View view){

        mNames.add( "Diary" );
        mFaNames.add( "لبنیات" );
        mImageUrls.add( "https://www.iconsdb.com/icons/download/white/cheese-48.png" );

        mNames.add( "Vegetable" );
        mFaNames.add( "سبزیجات" );
        mImageUrls.add("https://www.iconsdb.com/icons/download/white/tomato-48.png");

        mNames.add( "Meats" );
        mFaNames.add( "پروتئین ها" );
        mImageUrls.add( "https://www.iconsdb.com/icons/download/white/chicken-48.png" );

        mNames.add( "Beans" );
        mFaNames.add( "غلات" );
        mImageUrls.add( "https://www.iconsdb.com/icons/download/white/coffee-bean-2-48.png");

        mNames.add( "Oil" );
        mFaNames.add( "روغن ها" );
        mImageUrls.add( "https://www.iconsdb.com/icons/download/white/milk-48.png" );

        initRecyclerView( view );
    }

    private void initRecyclerView(View view){
        LinearLayoutManager linearLayout= new LinearLayoutManager( getContext() , LinearLayoutManager.HORIZONTAL,true );
        linearLayout.setReverseLayout( true );
        RecyclerView recyclerView= view.findViewById(R.id.ingredient_group_rv );
        recyclerView.setLayoutManager( linearLayout );

        MyRecyclerViewAdapter recyclerViewAdapter= new MyRecyclerViewAdapter( getContext(),mNames ,mFaNames, mImageUrls );
        recyclerView.setAdapter( recyclerViewAdapter );


    }



}
