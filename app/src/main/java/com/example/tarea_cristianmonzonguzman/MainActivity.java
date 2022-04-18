package com.example.tarea_cristianmonzonguzman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tarea_cristianmonzonguzman.Apps.AppsFragment;
import com.example.tarea_cristianmonzonguzman.Calculator.CalculatorFragment;
import com.example.tarea_cristianmonzonguzman.Pokemon.PokemonFragment;
import com.example.tarea_cristianmonzonguzman.Sound.SoundFragment;
import com.example.tarea_cristianmonzonguzman.Website.WebsiteFragment;
import com.example.tarea_cristianmonzonguzman.WondersWorld.WondersFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open,
                R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                Fragment fragment = null;

                switch (id) {

                    case R.id.calculator:
                        fragment = new CalculatorFragment();
                        LoadFragment(fragment);
                        break;

                    case R.id.sound:
                        fragment = new SoundFragment();
                        LoadFragment(fragment);
                        break;

                    case R.id.website:
                        fragment = new WebsiteFragment();
                        LoadFragment(fragment);
                        break;

                    case R.id.apps:
                        fragment = new AppsFragment();
                        LoadFragment(fragment);
                        break;

                    case R.id.wondersWorld:
                        fragment = new WondersFragment();
                        LoadFragment(fragment);
                        break;

                    case R.id.pokemon:
                        fragment = new PokemonFragment();
                        LoadFragment(fragment);
                        break;

                    default:
                        return true;
                }

                return true;
            }

            private void LoadFragment(Fragment fragment) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.frame, fragment).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                fragmentTransaction.addToBackStack(null);
            }
        });

        navigationView.setItemIconTintList(null);

    }
}