//package com.example.kata.clothes.interactor;
//
//import com.example.kata.clothes.interactor.clothes.ClothesInteractor;
//import com.example.kata.clothes.interactor.clothes.RepositoryInteractor;
//
//import javax.inject.Singleton;
//
//import dagger.Module;
//import dagger.Provides;
//
//public class InteractorModule {
//    @Provides
//    public RecepiesInteractor provideRecepiesInteractor() {
//        return new RecepiesInteractor();
//    }
//
//    @Singleton
//    @Provides
//    public RepositoryInteractor provideRepositoryInteractor(){
//        return new RepositoryInteractor();
//    }
//
//}