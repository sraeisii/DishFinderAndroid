package com.example.benglish.dishfindertest1.models;

import java.io.Serializable;

public class MealType implements Serializable {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
