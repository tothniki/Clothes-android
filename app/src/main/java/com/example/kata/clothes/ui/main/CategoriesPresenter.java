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

    private void createCategories(){

        List<CategoryModel> newList = new ArrayList<CategoryModel>();

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


        repositoryInteractor.removeAllCategories(); //TODO legyen csak update, hogy a sajat hozzaadottak megmaradjanak
        repositoryInteractor.saveAllCategories(newList);
    };

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
