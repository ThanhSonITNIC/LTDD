package com.thanhsonitnic.ungdungdocsach.activities;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.thanhsonitnic.ungdungdocsach.R;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.WindowManager;
import android.widget.SearchView;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity{

    private AppBarConfiguration mAppBarConfiguration;

    NavigationView navigationView;
    DrawerLayout drawer;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_rate, R.id.nav_more)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch(menuItem.getItemId()){
                case R.id.nav_home:
                    Intent intent = new Intent(BookActivity.this, ListBookActivity.class);
                    startActivity(intent);
                    break;
                case R.id.nav_rate:
                    break;
                case R.id.nav_more:
                    break;
                default:
                    break;
            }

            drawer.closeDrawer(GravityCompat.START);
            return false;
            }
        });

        loadTableOfContent();
    }

    private void loadTableOfContent() {
        Menu menu = navigationView.getMenu();
        menu.add(R.id.nav_more, Menu.NONE, 0, "Học gì bây giờ");
        menu.add(R.id.nav_more, Menu.NONE, 0, "18+ Sai lầm hay mắc phải");
        menu.add(R.id.nav_more, Menu.NONE, 0, "Sự thật đắng lòng");
        menu.add(R.id.nav_more, Menu.NONE, 0, "Tổng quan về UX/UI");
        menu.add(R.id.nav_more, Menu.NONE, 0, "Ngày đầu đi code dạo");
        menu.add(R.id.nav_more, Menu.NONE, 0, "Lời cuối");
        menu.add(R.id.nav_more, Menu.NONE, 0, "Học gì bây giờ");
        menu.add(R.id.nav_more, Menu.NONE, 0, "18+ Sai lầm hay mắc phải");
        menu.add(R.id.nav_more, Menu.NONE, 0, "Sự thật đắng lòng");
        menu.add(R.id.nav_more, Menu.NONE, 0, "Tổng quan về UX/UI");
        menu.add(R.id.nav_more, Menu.NONE, 0, "Ngày đầu đi code dạo");
        menu.add(R.id.nav_more, Menu.NONE, 0, "Lời cuối");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem menuItem = menu.findItem(R.id.appSearchBar);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Intent intent = new Intent(BookActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.action_full_screen:
                break;
            case R.id.action_auto_scroll:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
