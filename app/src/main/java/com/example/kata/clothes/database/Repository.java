package com.example.kata.clothes.database;

import com.example.kata.clothes.model.ClothesModel;

import android.content.Context;

import java.util.List;

//import dagger.Module;
//import dagger.Provides;

public interface Repository {

    void open(Context context);

    void close();

    List<ClothesModel> getAllClothes();

    ClothesModel getClothesById(long id);

    void saveClothes(ClothesModel cloth);

    void saveAllClothes (List<ClothesModel> cloth);

    void updateClothes(List<ClothesModel> newCloth);

    void removeClothes(ClothesModel cloth);

    void removeAll();

    boolean isInDB(ClothesModel cloth);
}

