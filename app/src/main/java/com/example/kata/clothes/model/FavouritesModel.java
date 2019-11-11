package com.example.kata.clothes.model;

public class FavouritesModel{
    private long id;
    private String label;
    private String list;

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLabel(String name) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getList() {
        return list;
    }

}
