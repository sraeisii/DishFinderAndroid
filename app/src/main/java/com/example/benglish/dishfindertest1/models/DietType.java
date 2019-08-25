package com.example.benglish.dishfindertest1.models;

import java.io.Serializable;

public class DietType implements Serializable {
    private int id;
    private String text;
    private String origin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
