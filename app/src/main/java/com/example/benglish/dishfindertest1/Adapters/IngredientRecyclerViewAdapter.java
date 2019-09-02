package com.example.benglish.dishfindertest1.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
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
        holder.ingredientName.setText( ingredients.get( position ).getTitle() );
        if(iMainActivity.isIngredientChecked( ingredients.get( position ) )== true)
        {
            holder.ingredientImage.setBackgroundResource(R.drawable.ingredient_clicked_button_shape );
        }

        if(ingredients.get( position ).getImageBinary() != null)
        {
            try
            {
                byte[] imageByteArray = Base64.decode(ingredients.get( position ).getImageBinary(), Base64.DEFAULT);
                Glide.with(mContext).asBitmap().load( imageByteArray).into( holder.ingredientImage );
            }
            catch(Exception ex)
            {
                Log.d( "BinaryImage", ex.getMessage() );
            }

        }

        holder.ingredientImage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d( "TAG","Clicked" );

                if (ingredients.get( position ). getSelected()== false){
                    holder.ingredientImage.setBackgroundResource(R.drawable.ingredient_clicked_button_shape );
                    ingredients.get( position ).setSelected( true );
                    iMainActivity.setSelectedIngredients( ingredients.get( position ) );

                }
                else {
                    holder.ingredientImage.setBackgroundResource(R.drawable.ingredient_buttonshape );
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
        private ImageButton ingredientImage;
        private CardView ingredientItem;
        private TextView ingredientName;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            ingredientImage= itemView.findViewById( R.id.ingredient_image );
            ingredientItem= itemView.findViewById( R.id.ingredient_item );
            ingredientName= itemView.findViewById( R.id.ingredient_name );

        }
    }
}

