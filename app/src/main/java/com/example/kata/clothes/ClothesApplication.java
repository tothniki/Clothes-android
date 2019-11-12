package com.example.kata.clothes;
import  com.example.kata.clothes.ui.UIModule;
import android.app.Application;

public class ClothesApplication extends Application {
    public static ClothesApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerClothesApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}

