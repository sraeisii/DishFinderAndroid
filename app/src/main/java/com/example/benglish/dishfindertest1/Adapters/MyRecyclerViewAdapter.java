package com.example.benglish.dishfindertest1.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.benglish.dishfindertest1.IMainActivity;
import com.example.benglish.dishfindertest1.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private static final String TAG= "MyRecyclerViewAdapter";
    private ArrayList<String> mNames= new ArrayList<>(  );
    private ArrayList<String> mFaNames= new ArrayList<>(  );
    private ArrayList<String> mImageUrls= new ArrayList<>(  );
    private Context mContext;
    private IMainActivity iMainActivity;
    private int selectedIngredientTypePosition = 0;

    public MyRecyclerViewAdapter( Context mContext, ArrayList<String> mNames,ArrayList<String> mFaNames ,ArrayList<String> mImageUrls) {
        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
        this.mContext = mContext;
        this.mFaNames=mFaNames;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view= LayoutInflater.from( parent.getContext()).inflate( R.layout.layout_listitem, parent , false);

        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Log.d(TAG,"onBindViewHolder:called.");
        Glide.with(mContext).asBitmap().load( mImageUrls.get( position ) ).into( holder.image );
        holder.name.setText( mFaNames.get( position ) );

        if(position == selectedIngredientTypePosition)
        {
            holder.name.setVisibility( View.INVISIBLE );
            holder.selectedType.setVisibility( View.VISIBLE );
        }
        else {
            holder.name.setVisibility( View.VISIBLE );
            holder.selectedType.setVisibility( View.INVISIBLE );
        }


        holder.image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedIngredientTypePosition = position;

                Log.d(TAG,"onclick"+mNames.get( position ));

                iMainActivity= (IMainActivity) mContext;
                if (mNames.get(position)=="Diary"){
                    iMainActivity.loadDiaryFragment();
                }
                else if(mNames.get(position)=="Vegetable"){
                    iMainActivity.loadVegetableFragment();
                }

                else if(mNames.get(position)=="Meats"){
                    iMainActivity.loadMeatFragment();
                }
                else if(mNames.get(position)=="Beans") {
                    iMainActivity.loadBeanFragment();
                }

                notifyDataSetChanged();
            }
        } );
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout ingredientGroupRL;
        ImageView image;
        TextView name;
        ImageView selectedType;

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            image = itemView.findViewById( R.id.image_view );
            image.setClipToOutline(true);
            name= itemView.findViewById( R.id.name );
            selectedType=itemView.findViewById( R.id.selected_type );
            ingredientGroupRL= itemView.findViewById( R.id.ingredient_group_rl );

        }
    }

}
