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

                Intent intent = new Intent( getActivity(), LoadDishListActivity.class );
                intent.putExtra("selected_ingredientIds", selectedIngredientIds );
                startActivity( intent );
            }
        } );
    }


    private void getImages(View view){

        mNames.add( "Diary" );
        mFaNames.add( "لبنیات" );
        mImageUrls.add( "http://cdn.persiangig.com/preview/c7O4vGDh3C/large/Dairy2.jpg" );

        mNames.add( "Vegetable" );
        mFaNames.add( "سبزیجات" );
        mImageUrls.add("http://cdn.persiangig.com/preview/ilCzCnzLcl/large/Vegetable2.jpg");

        mNames.add( "Meats" );
        mFaNames.add( "پروتئین ها" );
        mImageUrls.add( "http://cdn.persiangig.com/preview/6ftBN2xl4n/large/Protein2.jpg" );

        mNames.add( "Beans" );
        mFaNames.add( "حبوبات" );
        mImageUrls.add( "http://cdn.persiangig.com/preview/HUrowFRGmm/large/Hobubat1.jpg");

        mNames.add( "Oil" );
        mFaNames.add( "روغن ها" );
        mImageUrls.add( "http://cdn.persiangig.com/preview/n49KZ4VHNG/large/Oil1.jpg" );

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
