package com.example.benglish.dishfindertest1.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    public MyRecyclerViewAdapter( Context mContext, ArrayList<String> mNames,ArrayList<String> mFaNames ,ArrayList<String> mImageUrls) {
        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
        this.mContext = mContext;
        this.mFaNames=mFaNames;
    }

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
        holder.image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onclick"+mNames.get( position ));
                Toast.makeText( mContext, mNames.get( position ), Toast.LENGTH_SHORT ).show();

                iMainActivity= (IMainActivity) mContext;
                    if (mNames.get(position)=="Diary"){
                        iMainActivity.loadDiaryFragment();
                       // holder.ingredientGroupRL.setBackgroundColor( Color.parseColor("#EA5A56"));
                    }
                    else if(mNames.get(position)=="Vegetable"){
                        iMainActivity.loadVegetableFragment();
                       // holder.ingredientGroupRL.setBackgroundColor( Color.parseColor("#EA5A56"));
                    }

                    else if(mNames.get(position)=="Meats"){
                    iMainActivity.loadMeatFragment();
                       // holder.ingredientGroupRL.setBackgroundColor( Color.parseColor("#EA5A56"));
                    }
                    else if(mNames.get(position)=="Beans") {
                        iMainActivity.loadBeanFragment();
                        holder.ingredientGroupRL.setBackgroundColor( Color.parseColor("#EA5A56"));
                    }
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

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            image = itemView.findViewById( R.id.image_view );
            name= itemView.findViewById( R.id.name );
            ingredientGroupRL= itemView.findViewById( R.id.ingredient_group_rl );
        }
    }

}
