package com.example.kata.clothes.interactor;

import com.example.kata.clothes.interactor.clothes.ClothesInteractor;
import com.example.kata.clothes.interactor.clothes.RepositoryInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public ClothesInteractor provideClothesInteractor() {
        return new ClothesInteractor();
    }

    @Singleton
    @Provides
    public RepositoryInteractor provideRepositoryInteractor(){
        return new RepositoryInteractor();
    }

}