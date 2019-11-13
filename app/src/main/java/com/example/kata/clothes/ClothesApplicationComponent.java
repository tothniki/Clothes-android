package com.example.kata.clothes;
import com.example.kata.clothes.database.RepositoryModule;
import com.example.kata.clothes.interactor.clothes.RepositoryInteractor;
import com.example.kata.clothes.interactor.InteractorModule;
import com.example.kata.clothes.interactor.clothes.ClothesInteractor;
import com.example.kata.clothes.ui.UIModule;
import com.example.kata.clothes.ui.main.CategoriesFragment;
import com.example.kata.clothes.ui.main.CategoriesPresenter;
import com.example.kata.clothes.ui.main.MainActivity;
import com.example.kata.clothes.ui.main.MainPresenter;
import com.example.kata.clothes.ui.main.MainScreen;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class,
        InteractorModule.class, RepositoryModule.class})
public interface ClothesApplicationComponent {

        void inject(MainActivity mainActivity);
        void inject(MainPresenter mainPresenter);

        void inject(ClothesInteractor clothesInteractor);
        void inject(RepositoryInteractor repositoryInteractor);

        void inject(CategoriesFragment categoriesFragment);
        void inject(CategoriesPresenter categoriesPresenter);


}
