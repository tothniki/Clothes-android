package com.example.kata.clothes.database;

import com.example.kata.clothes.model.ClothesModel;
import com.example.kata.clothes.model.CategoryModel;
import com.example.kata.clothes.model.FavouritesModel;


import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;


public class SugarOrmRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<ClothesModel> getAllClothes() {
        List<ClothesModel> v = SugarRecord.listAll(ClothesModel.class);
        return v;
    }

    @Override
    public ClothesModel getClothById(final long id) {
        ClothesModel v = SugarRecord.findById(ClothesModel.class, id);
        if(v !=null){
            return v;
        }
        return new ClothesModel();
    }

    @Override
    public void saveCloth(ClothesModel cloth) {
        SugarRecord.saveInTx(cloth);
    }

    @Override
    public void saveAllClothes(List<ClothesModel> clothes) {
        SugarRecord.saveInTx(clothes);
    }

    @Override
    public void updateClothes(List<ClothesModel> newClothes) {
        List<ClothesModel> oldClothes = getAllClothes();
        List<ClothesModel> toUpdate = new ArrayList<>(oldClothes.size());
        for (ClothesModel oldcloth : oldClothes) {
            for (ClothesModel newcloth : newClothes) {
                if (newcloth.getId()==oldcloth.getId()) {
                    toUpdate.add(newcloth);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public void removeCloth(ClothesModel cloth) {
        SugarRecord.deleteInTx(cloth);
    }

    @Override
    public void removeAllClothes(){
        SugarRecord.deleteAll(ClothesModel.class);
    }

    @Override
    public boolean isInDBCloth(ClothesModel cloth) {
        return SugarRecord.findById(ClothesModel.class, cloth.getId()) != null;
    }


    //Categories
    @Override
    public List<CategoryModel> getAllCategories() {
        List<CategoryModel> allc = SugarRecord.listAll(CategoryModel.class);
        return allc;
    }

    @Override
    public CategoryModel getCategoryById(final long id) {
        CategoryModel m = SugarRecord.findById(CategoryModel.class, id);
        if(m !=null){
            return m;
        }
        return new CategoryModel();
    }

    @Override
    public void saveCategory(CategoryModel category) {
        SugarRecord.saveInTx(category);
    }

    @Override
    public void saveAllCategories(List<CategoryModel> categories) {
        SugarRecord.saveInTx(categories);
    }

    @Override
    public void updateCategories(List<CategoryModel> newCategories) {
        List<CategoryModel> oldCategories = getAllCategories();
        List<CategoryModel> toUpdate = new ArrayList<>(oldCategories.size());
        for (CategoryModel oldcategory : oldCategories) {
            for (CategoryModel newcategory : newCategories) {
                if (newcategory.getId()==oldcategory.getId()) {
                    toUpdate.add(newcategory);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public void removeCategory(CategoryModel category) {
        SugarRecord.deleteInTx(category);
    }

    @Override
    public void removeAllCategories(){
        SugarRecord.deleteAll(CategoryModel.class);
    }

    @Override
    public boolean isInDBCat(CategoryModel category) {
        return SugarRecord.findById(CategoryModel.class, category.getId()) != null;
    }

    //Favourites
    @Override
    public List<FavouritesModel> getAllFavourites() {
        List<FavouritesModel> f = SugarRecord.listAll(FavouritesModel.class);
        return f;
    }

    @Override
    public FavouritesModel getFavouriteById(final long id) {
        FavouritesModel fm = SugarRecord.findById(FavouritesModel.class, id);
        if(fm !=null){
            return fm;
        }
        return new FavouritesModel();
    }

    @Override
    public void saveFavourite(FavouritesModel favourite) {
        SugarRecord.saveInTx(favourite);
    }

    @Override
    public void saveAllFavourites(List<FavouritesModel> favourites) {
        SugarRecord.saveInTx(favourites);
    }

    @Override
    public void updateFavourites(List<FavouritesModel> newFavourites) {
        List<FavouritesModel> oldFavourites = getAllFavourites();
        List<FavouritesModel> toUpdate = new ArrayList<>(oldFavourites.size());
        for (FavouritesModel oldfavourite : oldFavourites) {
            for (FavouritesModel newfavourite : newFavourites) {
                if (newfavourite.getId()==oldfavourite.getId()) {
                    toUpdate.add(newfavourite);
                }
            }
        }
        SugarRecord.saveInTx(toUpdate);
    }

    @Override
    public void removeFavourite(FavouritesModel favourite) {
        SugarRecord.deleteInTx(favourite);
    }

    @Override
    public void removeAllFavourites(){
        SugarRecord.deleteAll(FavouritesModel.class);
    }

    @Override
    public boolean isInDBFav(FavouritesModel favourite) {
        return SugarRecord.findById(FavouritesModel.class, favourite.getId()) != null;
    }

}
