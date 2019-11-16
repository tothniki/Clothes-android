package com.example.kata.clothes.interactor.clothes;

import com.example.kata.clothes.ClothesApplication;
import com.example.kata.clothes.database.Repository;
import com.example.kata.clothes.model.CategoryModel;
import com.example.kata.clothes.model.ClothesModel;
import com.example.kata.clothes.model.FavouritesModel;

import java.util.List;
import javax.inject.Inject;


public class RepositoryInteractor {
    @Inject
    Repository repository;

    public RepositoryInteractor() {
        ClothesApplication.injector.inject(this);
    };

    public List<ClothesModel> getAllClothes() {
        return repository.getAllClothes();
    }

    public ClothesModel getClothById(final long id) {
        return repository.getClothById(id);
    }


    public void saveCloth(ClothesModel cloth){repository.saveCloth(cloth);}


    public void saveAllClothes(List<ClothesModel> clothes) {
        repository.saveAllClothes(clothes);
    }


    public void updateClothes(List<ClothesModel> newClothes) {
      repository.updateClothes(newClothes);
    }


    public void removeCloth(ClothesModel cloth) {
        repository.removeCloth(cloth);
    }


    public void removeAllClothes(){
        repository.removeAllClothes();
    }


    public boolean isInDBCloth(ClothesModel cloth) {
        return repository.isInDBCloth((cloth));
    }


    //Categories
    public List<CategoryModel> getAllCategories() {
        return repository.getAllCategories();
    }


    public CategoryModel getCategoryById(final long id) {
        return repository.getCategoryById(id);
    }


    public void saveCategory(CategoryModel category) {
        repository.saveCategory(category);
    }


    public void saveAllCategories(List<CategoryModel> categories) {
        repository.saveAllCategories(categories);
    }


    public void updateCategories(List<CategoryModel> newCategories) {
        repository.updateCategories(newCategories);
    }


    public void removeCategory(CategoryModel category) {
        repository.removeCategory(category);
    }


    public void removeAllCategories(){
        repository.removeAllCategories();
    }


    public boolean isInDBCat(CategoryModel category) {
        return repository.isInDBCat(category);
    }

    //Favourites

    public List<FavouritesModel> getAllFavourites() {
        return repository.getAllFavourites();
    }


    public FavouritesModel getFavouriteById(final long id) {
        return repository.getFavouriteById(id);
    }


    public void saveFavourite(FavouritesModel favourite) {
        repository.saveFavourite(favourite);
    }


    public void saveAllFavourites(List<FavouritesModel> favourites) {
        repository.saveAllFavourites(favourites);
    }


    public void updateFavourites(List<FavouritesModel> newFavourites) {
        repository.updateFavourites(newFavourites);
    }


    public void removeFavourite(FavouritesModel favourite) {
        repository.removeFavourite(favourite);
    }


    public void removeAllFavourites(){
        repository.removeAllFavourites();
    }


    public boolean isInDBFav(FavouritesModel favourite) {
        return repository.isInDBFav(favourite);
    }

    public List<ClothesModel> getClothesOfCategory(CategoryModel category){
        return repository.getClothesOfCategory(category);
    }

}