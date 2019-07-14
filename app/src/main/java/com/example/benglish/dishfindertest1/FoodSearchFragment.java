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
import android.widget.Button;

import com.example.benglish.dishfindertest1.Adapters.MyRecyclerViewAdapter;

import java.util.ArrayList;

public class FoodSearchFragment extends Fragment {

    private static final String TAG="FoodSearch";

    private Button searchBtn;
    private IMainActivity iMainActivity;
    private ArrayList<String> mNames= new ArrayList<>(  );
    private ArrayList<String> mImageUrls= new ArrayList<>(  );

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

            }
        } );
    }

    private void getImages(View view){

        mNames.add( "Diary" );
        mImageUrls.add( "https://static2.eghtesadonline.com/thumbnail/7s8Yo5xGrjGS/BGmQaTBpfAytX4aLRhq9RbEWa7bc5QW5pCHuzyG5otRNRZdnqt5pantj5o8bnpZX1gDYrWUUxpJ8csm-_V9yRCNcdp1QsQZ6ZduTs8jYW1YsPpy72VofiQ,,/%D9%84%D8%A8%D9%86%DB%8C%D8%A7%D8%AA.jpg" );

        mNames.add( "Vegetable" );
        mImageUrls.add("https://www.theswag.com.au/wp-content/uploads/2019/02/vegetables-the-swag.jpeg");

        mNames.add( "Meats" );
        mImageUrls.add( "http://www.cndajin.com/data/wls/53/7902282.jpg" );

        mNames.add( "Beans" );
        mImageUrls.add( "https://images.thestar.com/A2m4YKeE3KfKr5-k1dgmfRYo_HA=/1086x725/smart/filters:cb(2700061000)/https://www.thestar.com/content/dam/thestar/life/2017/07/12/dont-fall-for-lectin-free-fad-the-diet-that-cuts-out-beans-and-grains/beans.jpg" );

        mNames.add( "Oil" );
        mImageUrls.add( "https://c.tribune.com.pk/2017/07/1458661-bestbenefitsofoliveoiljaitunkatelforskinhairandhealth-1500103259-216-640x480.jpg" );

        initRecyclerView( view );
    }

    private void initRecyclerView(View view){
        LinearLayoutManager linearLayout= new LinearLayoutManager( getContext() , LinearLayoutManager.HORIZONTAL,true );
        linearLayout.setReverseLayout( true );
        RecyclerView recyclerView= view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager( linearLayout );

        MyRecyclerViewAdapter recyclerViewAdapter= new MyRecyclerViewAdapter( getContext(), mNames, mImageUrls );
        recyclerView.setAdapter( recyclerViewAdapter );


    }



}
