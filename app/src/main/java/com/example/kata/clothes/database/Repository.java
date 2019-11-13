package com.example.kata.clothes.database;

import com.example.kata.clothes.model.ClothesModel;
import com.example.kata.clothes.model.CategoryModel;
import com.example.kata.clothes.model.FavouritesModel;

import android.content.Context;

import java.util.List;

import dagger.Module;
import dagger.Provides;

public interface Repository {

    void open(Context context);

    void close();

    List<ClothesModel> getAllClothes();

    ClothesModel getClothById(long id);

    void saveCloth(ClothesModel cloth);

    void saveAllClothes (List<ClothesModel> clothes);

    void updateClothes(List<ClothesModel> newClothes);

    void removeCloth(ClothesModel cloth);

    void removeAllClothes();

    boolean isInDBCloth(ClothesModel cloth);

    // Categories
    List<CategoryModel> getAllCategories();

    CategoryModel getCategoryById(long id);

    void saveCategory(CategoryModel category);

    void saveAllCategories (List<CategoryModel> categories);

    void updateCategories(List<CategoryModel> newCategories);

    void removeCategory(CategoryModel category);

    void removeAllCategories();

    boolean isInDBCat(CategoryModel category);

    // Favourites
    List<FavouritesModel> getAllFavourites();

    FavouritesModel getFavouriteById(long id);

    void saveFavourite(FavouritesModel favourite);

    void saveAllFavourites (List<FavouritesModel> favourites);

    void updateFavourites(List<FavouritesModel> newFavourites);

    void removeFavourite(FavouritesModel favourite);

    void removeAllFavourites();

    boolean isInDBFav(FavouritesModel favourite);
}

