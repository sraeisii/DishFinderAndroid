package com.example.benglish.dishfindertest1.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.benglish.dishfindertest1.IMainActivity;
import com.example.benglish.dishfindertest1.R;
import com.example.benglish.dishfindertest1.models.Ingredient;

import java.util.ArrayList;

public class IngredientRecyclerViewAdapter extends RecyclerView.Adapter<IngredientRecyclerViewAdapter.ViewHolder> {


    private ArrayList<Ingredient> ingredients= new ArrayList<>(  );
    private Context mContext;
    private IMainActivity iMainActivity;



    public IngredientRecyclerViewAdapter(ArrayList<Ingredient> ingredients, Context mContext) {
        this.ingredients = ingredients;
        this.mContext= mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from( parent.getContext()).
                inflate( R.layout.layout_ingredient_item , parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        iMainActivity= (IMainActivity) mContext;
        //is the comming ingredient position in the selectedIngredients?
        if(iMainActivity.isIngredientChecked( ingredients.get( position ) )== true)
        {
            holder.ingredientButton.setBackgroundResource(R.drawable.ingredinet_clicked_buttonshape );
        }
        holder.ingredientButton.setText( ingredients.get( position ).getTitle() );
        holder.ingredientButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d( "TAG","Clicked" );

                if (ingredients.get( position ). getSelected()== false){
                    holder.ingredientButton.setBackgroundResource(R.drawable.ingredinet_clicked_buttonshape );
                    ingredients.get( position ).setSelected( true );
                    iMainActivity.setSelectedIngredients( ingredients.get( position ) );

                }
                else {
                    holder.ingredientButton.setBackgroundResource(R.drawable.ingredient_buttonshape );
                    ingredients.get( position ).setSelected( false );
                    iMainActivity.removeSelectedIngredient( ingredients.get( position ) );
                }



            }
        } );


    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button ingredientButton;
        private CardView ingredientItem;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            ingredientButton= itemView.findViewById( R.id.ingredient_button );
            ingredientItem= itemView.findViewById( R.id.ingredient_item );

        }
    }
}

