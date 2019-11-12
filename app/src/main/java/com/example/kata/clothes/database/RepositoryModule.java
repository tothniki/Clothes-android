package com.example.kata.clothes.database;

import com.example.kata.clothes.ClothesApplication;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    private Context context;

    public RepositoryModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new SugarOrmRepository();
    }

}
