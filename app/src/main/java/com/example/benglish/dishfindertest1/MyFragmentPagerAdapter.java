package com.example.benglish.dishfindertest1;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class MyFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    String[] titles = {"Search", "Favorite","Profile"};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super( fm );
    }

    @Override
    public Fragment getItem(int position) {

        if(position==0){
        return new FoodSearchFragment();
        }
        else if(position==1){
            return new FavoriteFragment();
        }
        else
            return new ProfileFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
