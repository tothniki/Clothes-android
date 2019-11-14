package com.example.kata.clothes.ui.main;

import com.example.kata.clothes.ClothesApplication;
import com.example.kata.clothes.interactor.clothes.RepositoryInteractor;
import com.example.kata.clothes.model.CategoryModel;
import com.example.kata.clothes.model.ClothesModel;
import com.example.kata.clothes.ui.Presenter;
import com.example.kata.clothes.interactor.clothes.ClothesInteractor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class CategoriesPresenter extends Presenter<CategoriesScreen> {
    @Inject
    ClothesInteractor clothesInteractor;
    @Inject
    RepositoryInteractor repositoryInteractor;

    @Inject
    Executor executor;

    @Override
    public void attachScreen(CategoriesScreen screen) {
        super.attachScreen(screen);
        ClothesApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }



    public void loadCategoriesFromRepo(){
        executor.execute(new Runnable(){
            @Override
            public void run(){
                List<CategoryModel> list = repositoryInteractor.getAllCategories();
                screen.showCategories(list);
            }
        });
    }
}
