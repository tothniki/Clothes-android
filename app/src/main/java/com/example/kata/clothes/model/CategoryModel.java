package com.example.kata.clothes.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;
import com.orm.dsl.Unique;

import java.util.List;

@Table
public class CategoryModel extends SugarRecord{
    private Long id;
    private String name;
    private int resource;

    public CategoryModel() {
    }

    public CategoryModel(String name, int res) {
        this.name = name;
        this.resource = res;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
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


    public List<ClothesModel> getCategoryClothes(){
        List<ClothesModel>  clothesList = ClothesModel.find(ClothesModel.class, "category = ?", this.getId().toString());
        return clothesList;
    }

}
