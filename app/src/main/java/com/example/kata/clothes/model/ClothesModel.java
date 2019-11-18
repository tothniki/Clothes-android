package com.example.kata.clothes.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

@Table
public class ClothesModel extends SugarRecord{
    private Long id;
    private String name;
    private CategoryModel category;
    private FavouritesModel label;
    //private byte[] picture;
    private String uri;

    public ClothesModel() {

    }

    public ClothesModel(String name, CategoryModel category, FavouritesModel label, String uri) {
        this.name = name;
        this.category = CategoryModel.find(CategoryModel.class, "name = ?", category.getName()).get(0);
        this.label = FavouritesModel.find(FavouritesModel.class, "name = ?", label.getName()).get(0);
        //this.picture = picture;
        this.uri = uri;
    }
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

//    public byte[] getPicture() {
//        return picture;
//    }
//
//    public void setPicture(byte[] picture) {
//        this.picture = picture;
//    }



}


