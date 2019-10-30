package com.thanhsonitnic.ungdungdocsach.activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.thanhsonitnic.ungdungdocsach.R;
import com.thanhsonitnic.ungdungdocsach.adapters.ListBookAdapter;
import com.thanhsonitnic.ungdungdocsach.models.ListBook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

public class ListBookActivity extends AppCompatActivity {
    private ListView lvBooks;
    private ListBook listBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addControls();
        addEvents();
        loadData();
    }

    private void addControls() {
        lvBooks = findViewById(R.id.lvBooks);
    }

    private void addEvents() {
        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListBookActivity.this, BookActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        ListBookAdapter listBookAdapter = new ListBookAdapter(this, R.layout.book_listview, ListBook.getInstance().getBooks());
        lvBooks.setAdapter(listBookAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_book, menu);

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

}
