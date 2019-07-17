package com.example.benglish.dishfindertest1.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.benglish.dishfindertest1.IMainActivity;
import com.example.benglish.dishfindertest1.R;
import com.example.benglish.dishfindertest1.models.Dish;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShowDishRecyclerViewAdapter extends RecyclerView.Adapter<ShowDishRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Dish> dishes= new ArrayList<>(  );
    private Context mContext;

    public ShowDishRecyclerViewAdapter(ArrayList<Dish> dishes, Context mContext) {
        this.dishes = dishes;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view= LayoutInflater.from( parent.getContext()).inflate(R.layout.layout_dish_item,parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        IMainActivity iMainActivity= (IMainActivity) mContext;
        holder.dishTitle.setText( dishes.get( position ).getTitle() );
        holder.dishDescription.setText( dishes.get( position ).getDescription() );
        //Glide.with(mContext).asBitmap().load( dishes.get( position ) ).into( holder.dishImage );
        holder.dishCardView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );


    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView dishTitle;
        private TextView dishDescription;
        private CircleImageView dishImage;
        private CardView dishCardView;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            dishTitle=itemView.findViewById( R.id.dish_title );
            dishDescription=itemView.findViewById( R.id.dish_description );
            dishImage=itemView.findViewById( R.id.dish_image );
            dishCardView=itemView.findViewById( R.id.dish_card_view );
        }
    }

}
