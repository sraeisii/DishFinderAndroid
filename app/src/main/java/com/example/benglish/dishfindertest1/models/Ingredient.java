package com.example.benglish.dishfindertest1.models;

import java.util.ArrayList;

public class Ingredient {

    private int id;
    private String title;
    private Boolean selected= false;

    public Ingredient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}

