package com.example.kata.clothes.model;

import com.orm.dsl.Table;

@Table
public class ClothesModel{
    private long id;
    private CategoryModel category;
    private FavouritesModel label;
    private byte[] picture;

//    public ClothesModel(long id, CategoryModel category, FavouritesModel label, byte[] picture ) {
////        this.id = id;
////        this.category = category;
////        this.label = label;
////        this.picture = picture;
////    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public FavouritesModel getLabel() {
        return label;
    }

    public void setLabel(FavouritesModel label) {
        this.label = label;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }



}


