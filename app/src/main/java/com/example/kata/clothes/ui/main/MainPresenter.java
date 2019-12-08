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
//        repositoryInteractor.removeAllCategories(); //TODO legyen csak update, hogy a sajat hozzaadottak megmaradjanak
//        repositoryInteractor.removeAllClothes(); //TODO legyen csak update, hogy a sajat hozzaadottak megmaradjanak
//        repositoryInteractor.removeAllFavourites();

        if(repositoryInteractor.getAllCategories().size() == 0){
            CategoryModel cat_tshirt = new CategoryModel("T-Shirt", R.drawable.ic_tshirt);
            CategoryModel cat_skirt = new CategoryModel("Skirt", R.drawable.ic_mini_skirt);
            CategoryModel cat_shirt = new CategoryModel("Shirt", R.drawable.ic_shirt_1);
            CategoryModel cat_jacket = new CategoryModel("Coat", R.drawable.ic_blazer);
            CategoryModel cat_trousers = new CategoryModel("Pants", R.drawable.ic_pants);
            CategoryModel cat_heels = new CategoryModel("Shoes", R.drawable.ic_shoe);
            CategoryModel cat_dress = new CategoryModel("Dress", R.drawable.ic_pencil_dress);
            CategoryModel cat_accessories = new CategoryModel("Accessories", R.drawable.ic_bag);
            CategoryModel cat_misc = new CategoryModel("Others", R.drawable.ic_camera_alt_black_24dp);

            cat_tshirt.save();
            cat_skirt.save();
            cat_shirt.save();
            cat_jacket.save();
            cat_trousers.save();
            cat_dress.save();
            cat_heels.save();
            cat_accessories.save();
            cat_misc.save();
        }
        if(repositoryInteractor.getAllFavourites().size() == 0){
            FavouritesModel fav = new FavouritesModel("no_label_set");
            fav.save();
        }

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

    public void deleteCloth(ClothesModel item){
        repositoryInteractor.removeCloth(item);
    }

}