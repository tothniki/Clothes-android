package com.example.kata.clothes.interactor.clothes;
import com.example.kata.clothes.ClothesApplication;
import com.example.kata.clothes.database.Repository;
import com.example.kata.clothes.model.ClothesModel;

import javax.inject.Inject;

import dagger.Module;


public class ClothesInteractor {

    public ClothesInteractor(){
            ClothesApplication.injector.inject(this);
    }

}
