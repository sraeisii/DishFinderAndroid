package com.example.benglish.dishfindertest1.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class DishList implements Parcelable {
    private ArrayList<Dish> dishes;


    protected DishList(Parcel in) {
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public static final Creator<DishList> CREATOR = new Creator<DishList>() {
        @Override
        public DishList createFromParcel(Parcel in) {
            return new DishList( in );
        }

        @Override
        public DishList[] newArray(int size) {
            return new DishList[size];
        }
    };

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    public DishList(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
