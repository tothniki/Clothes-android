package com.example.kata.clothes.ui.main;

import javax.inject.Inject;

import com.example.kata.clothes.ClothesApplication;
import com.example.kata.clothes.R;
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
        repositoryInteractor.removeAllCategories(); //TODO legyen csak update, hogy a sajat hozzaadottak megmaradjanak
        repositoryInteractor.removeAllClothes(); //TODO legyen csak update, hogy a sajat hozzaadottak megmaradjanak
        repositoryInteractor.removeAllFavourites();

        // create favorites elements
        FavouritesModel fav1 = new FavouritesModel("business");
        FavouritesModel fav2 = new FavouritesModel("home");
        fav1.save();
        fav2.save();
//        List<FavouritesModel> favourites = new ArrayList<>();
//        favourites.add(fav1);
//        favourites.add(fav2);
//        repositoryInteractor.saveAllFavourites(favourites);

        CategoryModel cat1 = new CategoryModel("dummyShirts", R.drawable.ic_camera_alt_black_24dp);
        CategoryModel cat2 = new CategoryModel("dummyJeans", R.drawable.ic_camera_alt_black_24dp);
        cat1.save();
        cat2.save();

        CategoryModel cat_tshirt = new CategoryModel("T-Shirt", R.drawable.ic_cat_tshirt);
        CategoryModel cat_shirt = new CategoryModel("Shirt", R.drawable.ic_cat_shirt);
        CategoryModel cat_skirt = new CategoryModel("Skirt", R.drawable.ic_cat_skirt);
        CategoryModel cat_jacket = new CategoryModel("Jacket", R.drawable.ic_cat_jacket);
        CategoryModel cat_trousers = new CategoryModel("Trousers", R.drawable.ic_cat_trousers);
        CategoryModel cat_heels = new CategoryModel("Heels", R.drawable.ic_cat_heels);
        CategoryModel cat_dress = new CategoryModel("Dress", R.drawable.ic_cat_dress);
        CategoryModel cat_accessories = new CategoryModel("Accessories", R.drawable.ic_cat_bag);
        CategoryModel cat_misc = new CategoryModel("Others", R.drawable.ic_camera_alt_black_24dp);

        cat_tshirt.save();
        cat_shirt.save();
        cat_skirt.save();
        cat_jacket.save();
        cat_trousers.save();
        cat_heels.save();
        cat_dress.save();
        cat_accessories.save();
        cat_misc.save();


//        List<CategoryModel> categories = new ArrayList<>();
//        categories.add(cat1);
//        categories.add(cat2);
//        repositoryInteractor.saveAllCategories(categories);


        // create one cloth list containing two clothes
        ClothesModel cloth = new ClothesModel("shirtA", cat1, fav1, null);
        ClothesModel cloth2 = new ClothesModel("jeansA",cat2, fav2, null);
        ClothesModel cloth3 = new ClothesModel("jeansB",cat2, fav1, null);
        ClothesModel cloth4 = new ClothesModel("shirtB", cat1, fav2, null);
        cloth.save();
        cloth2.save();
        cloth3.save();
        cloth4.save();

//        List<ClothesModel> clothes = new ArrayList<>();
//        clothes.add(cloth);
//        clothes.add(cloth2);
//        clothes.add(cloth3);
//        clothes.add(cloth4);
//        repositoryInteractor.saveAllClothes(clothes);

    }

    public CategoryModel getCategory(){
        List<CategoryModel> categories= new ArrayList<CategoryModel>();
        categories =  repositoryInteractor.getAllCategories();
        return categories.get(1);
    }

    public String getClothName(){
        List<CategoryModel> categories= new ArrayList<CategoryModel>();
        categories =  repositoryInteractor.getAllCategories();
        CategoryModel cat = categories.get(1);

        List<ClothesModel> clothes = cat.getCategoryClothes();

        return clothes.get(0).getName();
    }

    public String getFavName(){
        List<CategoryModel> categories= new ArrayList<CategoryModel>();
        categories =  repositoryInteractor.getAllCategories();
        CategoryModel cat = categories.get(1);

        List<ClothesModel> clothes = cat.getCategoryClothes();

        return clothes.get(0).getLabel().getName();
    }


}