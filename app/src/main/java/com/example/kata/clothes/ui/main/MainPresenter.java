package com.example.kata.clothes.ui.main;

import javax.inject.Inject;

import com.example.kata.clothes.ClothesApplication;
import com.example.kata.clothes.interactor.clothes.ClothesInteractor;
import com.example.kata.clothes.interactor.clothes.RepositoryInteractor;
import com.example.kata.clothes.model.CategoryModel;
import com.example.kata.clothes.model.ClothesModel;
import com.example.kata.clothes.model.FavouritesModel;
import com.example.kata.clothes.ui.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    ClothesInteractor clothesInteractor;
    @Inject
    RepositoryInteractor repositoryInteractor;

    @Inject
    Executor executor;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        ClothesApplication.injector.inject(this);
    }
    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void initDataset(){

        List<CategoryModel> newList = new ArrayList<CategoryModel>();
        List<FavouritesModel> favouritesModelList = new ArrayList<FavouritesModel>();
        List<ClothesModel> clothesModelList = new ArrayList<ClothesModel>();

        // create one cloth list containing two clothes
        ClothesModel cloth = new ClothesModel();
        ClothesModel cloth2 = new ClothesModel();
        List<ClothesModel> clothList = new ArrayList<>();
        clothList.add(cloth);
        clothList.add(cloth2);

        CategoryModel newItem = new CategoryModel();
        newItem.setClothes(clothList);
        newItem.setName("Shirts");

        // create other clothes list with two clothes
        ClothesModel cloth3 = new ClothesModel();
        ClothesModel cloth4 = new ClothesModel();
        List<ClothesModel> clothList1 = new ArrayList<>();
        clothList.add(cloth3);
        clothList.add(cloth4);

        CategoryModel newItem2 = new CategoryModel();
        newItem2.setClothes(clothList1);
        newItem2.setName("Jeans");

        newList.add(newItem);
        newList.add(newItem2);

        // create favorites elements
        FavouritesModel fav1 = new FavouritesModel();
        fav1.setName("business");
        fav1.setClothes(clothList);
        FavouritesModel fav2 = new FavouritesModel();
        fav2.setName("home");
        fav2.setClothes(clothList1);

        favouritesModelList.add(fav1);
        favouritesModelList.add(fav2);

        clothesModelList.add(cloth);
        clothesModelList.add(cloth2);
        clothesModelList.add(cloth3);
        clothesModelList.add(cloth4);


        repositoryInteractor.removeAllCategories(); //TODO legyen csak update, hogy a sajat hozzaadottak megmaradjanak
        repositoryInteractor.removeAllClothes(); //TODO legyen csak update, hogy a sajat hozzaadottak megmaradjanak
        repositoryInteractor.removeAllFavourites(); //TODO legyen csak update, hogy a sajat hozzaadottak megmaradjanak
        repositoryInteractor.saveAllCategories(newList);
        repositoryInteractor.saveAllClothes(clothesModelList);
        repositoryInteractor.saveAllFavourites(favouritesModelList);
    }
}