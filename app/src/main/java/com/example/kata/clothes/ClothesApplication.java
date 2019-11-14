package com.example.kata.clothes;
import com.example.kata.clothes.database.RepositoryModule;
import  com.example.kata.clothes.ui.UIModule;
import android.app.Application;
import com.example.kata.clothes.database.Repository;
import com.orm.SugarContext;

import javax.inject.Inject;


public class ClothesApplication extends Application {
    public static ClothesApplicationComponent injector;

//
//    public void setInjector(ClothesApplicationComponent appComponent) {
//        injector = appComponent;
//        injector.inject(this);
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
        //injector = DaggerClothesApplicationComponent.builder().uIModule(new UIModule(this)).build();
        injector = DaggerClothesApplicationComponent.builder().uIModule(new UIModule(this)).repositoryModule(new RepositoryModule(this)).build();
    }
}

