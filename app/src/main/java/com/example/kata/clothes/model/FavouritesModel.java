package com.example.kata.clothes.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

import java.util.List;

@Table
public class FavouritesModel extends SugarRecord{
    private Long id;
    private String name;

    public FavouritesModel() {
    }
    public FavouritesModel(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClothesModel> getFavouritesClothes() {
        List<ClothesModel>  clothesList = ClothesModel.find(ClothesModel.class, "label = ?", this.getId().toString());
        return clothesList;

    }

}
