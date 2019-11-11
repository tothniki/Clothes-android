package com.example.kata.clothes.model;


public class ClothesModel{
    private long id;
    private String category;
    private String label;
    private String picture;

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setLabel(String name) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}


