package com.example.kata.clothes.model;

import java.util.List;

public class CategoryModel{

    private long id;
    private String name;
    private List<ClothesModel> clothes;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClothesModel> getClothes() {
        return clothes;
    }

    public void setClothes(List<ClothesModel> clothes) {
        this.clothes = clothes;
    }

    public CategoryModel(long id, String name, List<ClothesModel> clothes) {
        this.id = id;
        this.name = name;
        this.clothes = clothes;
    }

}
