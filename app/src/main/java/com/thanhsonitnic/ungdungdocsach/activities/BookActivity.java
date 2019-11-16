package com.thanhsonitnic.ungdungdocsach.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.ui.AppBarConfiguration;
import com.google.android.material.navigation.NavigationView;
import com.thanhsonitnic.ungdungdocsach.R;
import com.thanhsonitnic.ungdungdocsach.interfaces.OnBookResultListener;
import com.thanhsonitnic.ungdungdocsach.interfaces.OnTOCResultListener;
import com.thanhsonitnic.ungdungdocsach.models.Book;
import com.thanhsonitnic.ungdungdocsach.models.Chapter;
import com.thanhsonitnic.ungdungdocsach.models.JacketImage;
import com.thanhsonitnic.ungdungdocsach.models.Setting;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import java.util.ArrayList;

public class BookActivity extends AppCompatActivity{

    private AppBarConfiguration mAppBarConfiguration;

    NavigationView navigationView;
    DrawerLayout drawer;
    SearchView searchView;
    ArrayList<Chapter> chapterArrayList = new ArrayList<>();
    TextView txtContent, txtTitle, txtAuthor;
    ImageView imgJackKet;
    Toolbar toolbar;
    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addControls();
        addEvents();
        receiveInfo();
        updateSettings();
    }

    private void addControls() {
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        txtContent = findViewById(R.id.txtContent);
        txtTitle = navigationView.getHeaderView(0).findViewById(R.id.txtTitle);
        txtAuthor = navigationView.getHeaderView(0).findViewById(R.id.txtAuthor);
        imgJackKet = navigationView.getHeaderView(0).findViewById(R.id.imgJacket);
    }

    private void addEvents() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_rate, R.id.nav_more)
                .setDrawerLayout(drawer)
                .build();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.nav_home:
                        finish();
                        break;
                    case R.id.nav_rate:
                        break;
                    case R.id.nav_more:
                        break;
                    default:
                        setContent(menuItem.getItemId());
                        break;
                }

                drawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    private void updateSettings() {
        Setting setting = Setting.getInstance(this);
        txtContent.setTextSize(setting.getContentTextSize());
    }

    /**
     * get info from ListBookActivity
     */
    private void receiveInfo(){
        Bundle bundle = getIntent().getExtras();
        loadBook(bundle.getString(Book.KEY_ID));
    }

    /**
     * Set book's content
     *
     * @param id
     */
    private void setContent(int id){
        String content = "";
        try {
            content = chapterArrayList.get(id).getContent();
        }catch (IndexOutOfBoundsException e){
            content = "Field id in firestore must start at 0 and increase +1";
        }catch (Exception e){
            content = "Content not found";
        }
        txtContent.setText(content);
    }

    /**
     * Load book infomation on ui
     *
     * @param id
     */
    private void loadBook(String id) {
        final Menu menu = navigationView.getMenu();

        // load book
        book = new Book(id, new OnBookResultListener() {
            @Override
            public void onResult(Book book) {
                txtTitle.setText(book.getTitle());
                txtAuthor.setText(book.getAuthor());
                JacketImage.getInstance().loadImage(imgJackKet, book.getImage());
            }
        });

        // load table of content
        book.getChapters(new OnTOCResultListener() {
            @Override
            public void onResult(ArrayList<Chapter> chapters) {
                chapterArrayList = chapters;
                for (Chapter chapter : chapters) {
                    menu.add(R.id.nav_more, Integer.parseInt(chapter.getId()), 0, chapter.getName());
                }

                // load content of first chapter
                setContent(0);
            }
        });

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
