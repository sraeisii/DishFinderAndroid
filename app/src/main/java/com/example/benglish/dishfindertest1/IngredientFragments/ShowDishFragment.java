package com.example.benglish.dishfindertest1.IngredientFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.benglish.dishfindertest1.Adapters.ShowDishRecyclerViewAdapter;
import com.example.benglish.dishfindertest1.R;
import com.example.benglish.dishfindertest1.models.Dish;

import java.util.ArrayList;

public class ShowDishFragment extends Fragment {
    private RecyclerView dishRecyclerView;
    private ArrayList<Dish> dishes= new ArrayList<>(  );
    private Context mContext;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_show_dish, container, false );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            dishes = bundle.getParcelable("selected_dish");
        }

//        dishRecyclerView= view.findViewById( R.id.show_dish_rv );
//
//        dishRecyclerView.setLayoutManager( new GridLayoutManager( getActivity(), 2 ) );
//
//        ShowDishRecyclerViewAdapter showDishRecyclerViewAdapter=
//                new ShowDishRecyclerViewAdapter( dishes, getContext());
//        dishRecyclerView.setAdapter( showDishRecyclerViewAdapter );

    }

}
