package com.example.kata.clothes.ui.favourites;

import android.util.Log;

import com.example.kata.clothes.ClothesApplication;
import com.example.kata.clothes.interactor.clothes.ClothesInteractor;
import com.example.kata.clothes.interactor.clothes.RepositoryInteractor;
import com.example.kata.clothes.model.ClothesModel;
import com.example.kata.clothes.model.FavouritesModel;
import com.example.kata.clothes.ui.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class FavouritesPresenter extends Presenter<FavouritesScreen> {
    private static final String TAG = "FavouritesPresenter";

    @Inject
    ClothesInteractor clothesInteractor;
    @Inject
    RepositoryInteractor repositoryInteractor;

    @Inject
    Executor executor;

    @Override
    public void attachScreen(FavouritesScreen screen) {
        super.attachScreen(screen);
        ClothesApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }



    public void loadFavouritesFromRepo(){
        // Todo: delete the favourites which are empty
        List<FavouritesModel> selected_list = new ArrayList<>();
        List<FavouritesModel> all_list = repositoryInteractor.getAllFavourites();
        for (FavouritesModel fav : all_list) {
            List<ClothesModel> c_list = repositoryInteractor.getClothesOfFavourite(fav);
            if(c_list.size() != 0){
                selected_list.add(fav);
            }
        }

        int num = selected_list.size();
        Log.e(TAG, "*****************************************************loadFavsFromRepo:" + num);
        screen.showFavourites(selected_list);
    }


}
