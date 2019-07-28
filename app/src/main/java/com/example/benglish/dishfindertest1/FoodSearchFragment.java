package com.example.benglish.dishfindertest1;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.benglish.dishfindertest1.Adapters.IngredientRecyclerViewAdapter;
import com.example.benglish.dishfindertest1.Adapters.MyRecyclerViewAdapter;
import com.example.benglish.dishfindertest1.Data.DishFinderAPI;
import com.example.benglish.dishfindertest1.Data.GetDishByIngredientsController;
import com.example.benglish.dishfindertest1.Data.GetIngredientController;
import com.example.benglish.dishfindertest1.IngredientFragments.ShowDishFragment;
import com.example.benglish.dishfindertest1.models.Dish;
import com.example.benglish.dishfindertest1.models.DishList;
import com.example.benglish.dishfindertest1.models.Ingredient;
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
                Bundle bundle = new Bundle(  );
                bundle.putParcelable( "selected_dish", dishList );
                ShowDishFragment showDishFragment= new ShowDishFragment();
                showDishFragment.setArguments( bundle );
                getChildFragmentManager().beginTransaction().add( R.id.dish_fragment_container, showDishFragment )
                        .commit();
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
        mImageUrls.add( "https://static2.eghtesadonline.com/thumbnail/7s8Yo5xGrjGS/BGmQaTBpfAytX4aLRhq9RbEWa7bc5QW5pCHuzyG5otRNRZdnqt5pantj5o8bnpZX1gDYrWUUxpJ8csm-_V9yRCNcdp1QsQZ6ZduTs8jYW1YsPpy72VofiQ,,/%D9%84%D8%A8%D9%86%DB%8C%D8%A7%D8%AA.jpg" );

        mNames.add( "Vegetable" );
        mFaNames.add( "سبزیجات" );
        mImageUrls.add("https://www.theswag.com.au/wp-content/uploads/2019/02/vegetables-the-swag.jpeg");

        mNames.add( "Meats" );
        mFaNames.add( "پروتئین ها" );
        mImageUrls.add( "http://www.cndajin.com/data/wls/53/7902282.jpg" );

        mNames.add( "Beans" );
        mFaNames.add( "غلات" );
        mImageUrls.add( "https://images.thestar.com/A2m4YKeE3KfKr5-k1dgmfRYo_HA=/1086x725/smart/filters:cb(2700061000)/https://www.thestar.com/content/dam/thestar/life/2017/07/12/dont-fall-for-lectin-free-fad-the-diet-that-cuts-out-beans-and-grains/beans.jpg" );

        mNames.add( "Oil" );
        mFaNames.add( "روغن ها" );
        mImageUrls.add( "https://c.tribune.com.pk/2017/07/1458661-bestbenefitsofoliveoiljaitunkatelforskinhairandhealth-1500103259-216-640x480.jpg" );

        initRecyclerView( view );
    }

    private void initRecyclerView(View view){
        LinearLayoutManager linearLayout= new LinearLayoutManager( getContext() , LinearLayoutManager.HORIZONTAL,true );
        linearLayout.setReverseLayout( true );
        RecyclerView recyclerView= view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager( linearLayout );

        MyRecyclerViewAdapter recyclerViewAdapter= new MyRecyclerViewAdapter( getContext(),mNames ,mFaNames, mImageUrls );
        recyclerView.setAdapter( recyclerViewAdapter );


    }



}
