package com.example.kata.clothes.ui.create;

import android.util.Log;

import com.example.kata.clothes.ClothesApplication;
import com.example.kata.clothes.interactor.clothes.ClothesInteractor;
import com.example.kata.clothes.interactor.clothes.RepositoryInteractor;
import com.example.kata.clothes.model.CategoryModel;
import com.example.kata.clothes.model.ClothesModel;
import com.example.kata.clothes.model.FavouritesModel;
import com.example.kata.clothes.ui.Presenter;
import com.example.kata.clothes.ui.favourites.FavouritesScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class CreatePresenter extends Presenter<CreateScreen>{
    private static final String TAG = "CreatePresenter";
    @Inject
    ClothesInteractor clothesInteractor;
    @Inject
    RepositoryInteractor repositoryInteractor;

    @Inject
    Executor executor;

    @Override
    public void attachScreen(CreateScreen screen) {
        super.attachScreen(screen);
        ClothesApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }


    public void saveNewCloth(String cat, String fav, String file){
        Log.e(TAG, "-------------------------------------------------------------save new item  starts now ");
        CategoryModel category = new CategoryModel(cat);
        Log.e(TAG, "------------------------------------------------------------- create cat model");
        repositoryInteractor.saveCategory(category);
        Log.e(TAG, "------------------------------------------------------------- cat is saved");

        FavouritesModel favourite = new FavouritesModel(fav);
        Log.e(TAG, "-------------------------------------------------------------create fav model ");
        repositoryInteractor.saveFavourite(favourite);
        Log.e(TAG, "------------------------------------------------------------- fav is saved");


        Log.e(TAG, "------------------------------------------------------------- cloth fields: " + category + "-" + favourite + "-" + file);
        ClothesModel cloth = new ClothesModel("name", category, favourite, file);
        Log.e(TAG, "-------------------------------------------------------------create cloth");
        repositoryInteractor.saveCloth(cloth);
        Log.e(TAG, "------------------------------------------------------------- cloth is saved ");

    }
}
