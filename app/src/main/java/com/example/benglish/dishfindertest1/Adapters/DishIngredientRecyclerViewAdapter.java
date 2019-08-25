package com.example.benglish.dishfindertest1.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.benglish.dishfindertest1.IMainActivity;
import com.example.benglish.dishfindertest1.R;
import com.example.benglish.dishfindertest1.models.Dish;
import com.example.benglish.dishfindertest1.models.DishIngredient;


import java.util.ArrayList;

public class DishIngredientRecyclerViewAdapter extends RecyclerView.Adapter<DishIngredientRecyclerViewAdapter.ViewHolder> {
    private ArrayList<DishIngredient> dishIngredients;
    private Context mContext;


    public DishIngredientRecyclerViewAdapter(ArrayList<DishIngredient> dishIngredient, Context mContext) {
        this.dishIngredients = dishIngredient;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from( parent.getContext()).
                inflate( R.layout.layout_dish_ingredient_item , parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        String unitStr = dishIngredients.get( position ).getQuantity() + " " + dishIngredients.get( position ).getUnitType().getText();
        holder.dishIngredientItemName.setText( dishIngredients.get(position).getIngredientTitle() );
        holder.dishIngredientItemUnit.setText( unitStr );
        if(dishIngredients.get( position ).getImageBinary() != null)
        {
            try
            {
                byte[] imageByteArray = Base64.decode(dishIngredients.get( position ).getImageBinary(), Base64.DEFAULT);
                Glide.with(mContext).asBitmap().load( imageByteArray).into( holder.dishIngredientItemImage );
            }
            catch(Exception ex)
            {
                Log.d( "BinaryImage", ex.getMessage() );
            }

        }
    }
    @Override
    public int getItemCount() {
        return dishIngredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageButton dishIngredientItemImage;
        private TextView dishIngredientItemName;
        private TextView dishIngredientItemUnit;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            dishIngredientItemImage= itemView.findViewById( R.id.dish_ingredient_item_image );
            dishIngredientItemName= itemView.findViewById( R.id.dish_ingredient_item_name );
            dishIngredientItemUnit= itemView.findViewById( R.id.dish_ingredient_item_unit );

        }
    }
}


