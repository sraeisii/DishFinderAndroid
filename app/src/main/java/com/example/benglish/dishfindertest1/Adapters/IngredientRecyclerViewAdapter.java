package com.example.benglish.dishfindertest1.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.benglish.dishfindertest1.R;
import com.example.benglish.dishfindertest1.models.Ingredient;

import java.util.ArrayList;

public class IngredientRecyclerViewAdapter extends RecyclerView.Adapter<IngredientRecyclerViewAdapter.ViewHolder> {


    private ArrayList<Ingredient> ingredients= new ArrayList<>(  );


    public IngredientRecyclerViewAdapter(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from( parent.getContext()).
                inflate( R.layout.layout_ingredient_item , parent, false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ingredientName.setText( ingredients.get( position ).getTitle() );
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ingredientName;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            ingredientName= itemView.findViewById( R.id.ingredient_name );

        }
    }
}

