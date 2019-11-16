package com.thanhsonitnic.ungdungdocsach.models;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.thanhsonitnic.ungdungdocsach.interfaces.OnDataCompleteListener;
import com.thanhsonitnic.ungdungdocsach.interfaces.OnTOCResultListener;

import java.util.ArrayList;

public class Book {
    private String id;
    private String title;
    private int image;
    private String author;

    public static final String KEY_ID = "hahaha";
    public static final String KEY_TITLE = "vlxx";
    public static final String KEY_IMAGE = "dcmm";
    public static final String KEY_AUTHOR = "hihihi";

    public Book(String id) {
        this.id = id;
    }

    public Book(String id, String title, int image, String author) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void getChapters(final OnTOCResultListener onTOCResultListener){
        Database.getInstance().getTableOfContent(id, new OnDataCompleteListener() {
            @Override
            public void onComplete(QuerySnapshot data) {
                ArrayList<Chapter> chapters = new ArrayList<>();

                for (DocumentSnapshot documentSnapshot : data) {
                    chapters.add(new Chapter(documentSnapshot.getId(), documentSnapshot.get("Name").toString(), documentSnapshot.get("Content").toString()));
                }

                onTOCResultListener.onResult(chapters);
            }
        });
    }
}
