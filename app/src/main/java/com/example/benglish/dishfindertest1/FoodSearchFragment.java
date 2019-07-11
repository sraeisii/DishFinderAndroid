package com.example.benglish.dishfindertest1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Objects;

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



        //Load DiaryFragment
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
        mImageUrls.add( "https://brandmark.io/logo-rank/random/snap.png" );

        mNames.add( "Vegetable" );
        mImageUrls.add("https://brandmark.io/logo-rank/random/mcdonalds.png");

        mNames.add( "Twitter" );
        mImageUrls.add( "https://brandmark.io/logo-rank/random/twitter.png" );

        mNames.add( "Pepsi" );
        mImageUrls.add( "https://brandmark.io/logo-rank/random/pepsi.png" );

        mNames.add( "Yahoo" );
        mImageUrls.add( "https://brandmark.io/logo-rank/random/yc.png" );

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
