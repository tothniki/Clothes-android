package com.example.kata.clothes.ui;
import android.content.Context;

import com.example.kata.clothes.ui.favourites.FavouritesFragment;
import com.example.kata.clothes.ui.main.CategoriesPresenter;
import com.example.kata.clothes.ui.main.MainPresenter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {

    private Context context;

    public UIModule(Context context) {
        this.context = context; }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public CategoriesPresenter provideCategoriesPresenter(){ return new CategoriesPresenter();}

//    @Provides
//    @Singleton
//    public FavouritesPresenter provideFavouritesPresenter(){ return new FavouritesPresenter();}

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }

}

