package com.example.benglish.dishfindertest1.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Dish implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private DishDetail dishDetailsDto;
    private String imageBinary;




    public String getImageBinary() {
        return imageBinary;
    }

    public void setImageBinary(String imageBinary) {
        this.imageBinary = imageBinary;
    }


    public DishDetail getDishDetailsDto() {
        return dishDetailsDto;
    }

    public void setDishDetailsDto(DishDetail dishDetailsDto) {
        this.dishDetailsDto = dishDetailsDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
