package com.example.benglish.dishfindertest1.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.benglish.dishfindertest1.ILoadDishListActivity;
import com.example.benglish.dishfindertest1.R;
import com.example.benglish.dishfindertest1.models.DietType;
import com.example.benglish.dishfindertest1.models.Dish;
import com.example.benglish.dishfindertest1.models.Region;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShowDishRecyclerViewAdapter extends RecyclerView.Adapter<ShowDishRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Dish> dishes= new ArrayList<>(  );
    private Context mContext;
    private ILoadDishListActivity iLoadDishListActivity;
    private String dietTypesStr="";
    private String regionsStr="";

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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.dishTitle.setText( dishes.get( position ).getTitle() );
//        ArrayList<DietType> dishDietTypes= dishes.get( position ).getDishDetailsDto().getDietTypes( );
//        for (int i=0; i< Math.min(dishDietTypes.size(), 2);i++){
//            dietTypesStr += dishDietTypes.get( i ).getText()+",";
//        }
        ArrayList<Region> dishRegions= dishes.get( position ).getDishDetailsDto().getRegions( );
        for (int i=0; i< Math.min(dishRegions.size(),2);i++){
            regionsStr += dishRegions.get( i ).getRegionText()+",";
        }
        if (regionsStr==""){
            holder.regionText.setVisibility( View.GONE );
            holder.regionImage.setVisibility( View.GONE );
        }
        else
            holder.regionText.setText(regionsStr );

        int cookingTime= dishes.get( position ).getDishDetailsDto().getCookingTime();
        if (  cookingTime<=0 ){
            holder.cookingTimeText.setVisibility( View.GONE );
            holder.cookingTimeImage.setVisibility( View.GONE );
        }
        else
            holder.cookingTimeText.setText( cookingTime +"'" );

//        if (dietTypesStr==""){
//            holder.dietType.setVisibility( View.GONE );
//            holder.dietImage.setVisibility( View.GONE );
//        }
//        else
//            holder.dietType.setText(dietTypesStr );

        holder.dishDescription.setText( dishes.get( position ).getDescription() );
        holder.dishCardView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iLoadDishListActivity=(ILoadDishListActivity) mContext;

                Integer dishId = dishes.get( position ).getId();

                iLoadDishListActivity.loadDishRecipeFragment(dishId);

            }
        } );

        String dishImage = dishes.get( position ).getImageBinary();
        if(dishImage != null)
        {
            try
            {
                byte[] imageByteArray = Base64.decode(dishes.get( position ).getImageBinary(), Base64.DEFAULT);
                Glide.with(mContext).asBitmap().load( imageByteArray).into( holder.dishImage );
            }
            catch(Exception ex)
            {
                Log.d( "BinaryImage", ex.getMessage() );
            }

        }


    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView dishTitle;
        private TextView dishDescription;
        private ImageView dishImage;
        private MaterialCardView dishCardView;
        private TextView dietType;
        private TextView cookingTimeText;
        private TextView regionText;
        private ImageView regionImage;
        private ImageView dietImage;
        private ImageView cookingTimeImage;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            dishTitle=itemView.findViewById( R.id.dish_title );
            dishDescription=itemView.findViewById( R.id.dish_description );
            dishImage=itemView.findViewById( R.id.dish_image );
            dishCardView=itemView.findViewById( R.id.dish_card_view );
//            dietType=itemView.findViewById( R.id.diet_type );
            cookingTimeText=itemView.findViewById( R.id.cooking_time_text );
            regionText=itemView.findViewById( R.id.region_text );
            regionImage=itemView.findViewById( R.id.region_image );
//            dietImage=itemView.findViewById( R.id.diet_image );
            cookingTimeImage=itemView.findViewById( R.id.cooking_time_image );
        }
    }

}
