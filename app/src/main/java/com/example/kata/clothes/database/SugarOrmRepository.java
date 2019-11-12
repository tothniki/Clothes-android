//package com.example.kata.clothes.database;
//
//import com.example.kata.clothes.model.ClothesModel;
//
//import android.content.Context;
//
//import com.orm.SugarContext;
//import com.orm.SugarRecord;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class SugarOrmRepository {
//
//    @Override
//    public void open(Context context) {
//        SugarContext.init(context);
//    }
//
//    @Override
//    public void close() {
//        SugarContext.terminate();
//    }
//
//    @Override
//    public List<ClothesModel> getAllClothes() {
//        List<ClothesModel> v = SugarRecord.listAll(ClothesModel.class);
//        return v;
//    }
//
//    @Override
//    public ClothesModel getClotheslById(final long id) {
//        ClothesModel v = SugarRecord.findById(ClothesModel.class, id);
//        if(v !=null){
//            return v;
//        }
//        return new ClothesModel();
//    }
//
//    @Override
//    public void saveClothes(ClothesModel cloth) {
//        SugarRecord.saveInTx(cloth);
//    }
//
//    @Override
//    public void saveAllClothes(List<ClothesModel> cloth) {
//        /*int i=0;
//        for (MealModel m : meals) {
//            SugarRecord.save(m);
//            i++;
//        }
//        i=i+1;*/
//        SugarRecord.saveInTx(meals);
//    }
//
//    @Override
//    public void updateClothes(List<ClothesModel> newClothes) {
//        List<ClothesModel> oldClothes = getAllClothes();
//        List<ClothesModel> toUpdate = new ArrayList<>(oldClothes.size());
//        for (ClothesModel oldcloth : oldClothes) {
//            for (ClothesModel newcloth : newClothes) {
//                if (newcloth.getId()==oldcloth.getId()) {
//                    toUpdate.add(newcloth);
//                }
//            }
//        }
//        SugarRecord.saveInTx(toUpdate);
//    }
//
//    @Override
//    public void removeClothes(ClothesModel cloth) {
//        SugarRecord.deleteInTx(cloth);
//    }
//
//    @Override
//    public void removeAll(){
//        SugarRecord.deleteAll(ClothesModel.class);
//    }
//
//    @Override
//    public boolean isInDB(ClothesModel cloth) {
//        return SugarRecord.findById(ClothesModel.class, cloth.getId()) != null;
//    }
//}
