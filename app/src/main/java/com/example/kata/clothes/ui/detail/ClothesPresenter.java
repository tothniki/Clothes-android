package com.example.kata.clothes.ui.detail;

import com.example.kata.clothes.ClothesApplication;
import com.example.kata.clothes.interactor.clothes.ClothesInteractor;
import com.example.kata.clothes.interactor.clothes.RepositoryInteractor;
import com.example.kata.clothes.model.CategoryModel;
import com.example.kata.clothes.model.ClothesModel;
import com.example.kata.clothes.ui.Presenter;
import com.example.kata.clothes.ui.detail.ClothesScreen;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class ClothesPresenter extends Presenter<ClothesScreen> {
    private static final String TAG = "ClothesPresenter";
    @Inject
    ClothesInteractor clothesInteractor;

    @Inject
    RepositoryInteractor repositoryInteractor;

    @Inject
    Executor executor;

    @Override
    public void attachScreen(ClothesScreen screen) {
        super.attachScreen(screen);
        ClothesApplication.injector.inject(this);
    }
    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void loadClothesOfCategory(CategoryModel category){
        List<ClothesModel> list = repositoryInteractor.getClothesOfCategory(category);
        screen.showClothes(list);
    }

}

