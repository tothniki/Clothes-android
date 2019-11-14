package com.example.kata.clothes.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.kata.clothes.ClothesApplication;
import com.example.kata.clothes.R;
import com.example.kata.clothes.interactor.clothes.RepositoryInteractor;
import com.example.kata.clothes.model.CategoryModel;
import com.example.kata.clothes.model.ClothesModel;
import com.example.kata.clothes.model.FavouritesModel;
import com.example.kata.clothes.ui.create.CreateFragment;
import com.example.kata.clothes.ui.favourites.FavouritesFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Module;


public class MainActivity extends AppCompatActivity implements MainScreen {
    @Inject
    MainPresenter mainPresenter;

    private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClothesApplication.injector.inject(this);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CategoriesFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedfragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_categories:
                            selectedfragment = new CategoriesFragment();
                            break;
                        case R.id.nav_favourites:
                            selectedfragment = new FavouritesFragment();
                            break;
                        case R.id.nav_add:
                            selectedfragment = new CreateFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedfragment).commit();
                    return true;
                }
            };

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
        Log.e(TAG, "-------------------------------------------------------------onStart: dataset empty");
        mainPresenter.initDataset();
        Log.e(TAG, "-------------------------------------------------------------onStart: Dataset init done");
        CategoryModel cm = mainPresenter.getCategory();
        Log.e(TAG, "-------------------------------------------------------------onStart: category name:" + cm.getName());

    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name = "Main";
        Log.i("Meal", "Set new screen name: " + name);
    }

//    @Override
//    public void onRefresh() {
//        //mainPresenter.updateDatabase();
//    }
}
