package com.example.kata.clothes;
import com.example.kata.clothes.database.RepositoryModule;
import  com.example.kata.clothes.ui.UIModule;
import android.app.Application;
import com.example.kata.clothes.database.Repository;

import javax.inject.Inject;


public class ClothesApplication extends Application {
    public static ClothesApplicationComponent injector;

//    @Inject
//    Repository repository;
//
//
//    public void setInjector(ClothesApplicationComponent appComponent) {
//        injector = appComponent;
//        injector.inject(this);
//        repository.open(getApplicationContext());
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerClothesApplicationComponent.builder().uIModule(new UIModule(this)).build();
        //injector = DaggerClothesApplicationComponent.builder().uIModule(new UIModule(this)).repositoryModule(new RepositoryModule(this)).build();
    }
}

