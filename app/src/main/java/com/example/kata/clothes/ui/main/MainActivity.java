package com.example.kata.clothes.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.kata.clothes.R;
import com.example.kata.clothes.ui.create.CreateFragment;
import com.example.kata.clothes.ui.favourites.FavouritesFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

}
