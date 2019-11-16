package com.thanhsonitnic.ungdungdocsach.models;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.thanhsonitnic.ungdungdocsach.interfaces.OnBookResultListener;
import com.thanhsonitnic.ungdungdocsach.interfaces.OnDataCompleteListener;
import com.thanhsonitnic.ungdungdocsach.interfaces.OnDocumentSnapshotCompleteListener;
import com.thanhsonitnic.ungdungdocsach.interfaces.OnTOCResultListener;

import java.util.ArrayList;

public class Book {
    private String id;
    private String title;
    private String image;
    private String author;

    public static final String KEY_ID = "hahaha";

    public Book(String id, final OnBookResultListener onBookResultListener) {
        this.id = id;
        Database.getInstance().getBook(id, new OnDocumentSnapshotCompleteListener() {
            @Override
            public void onComplete(DocumentSnapshot documentSnapshot) {
                Book book = new Book(documentSnapshot.getId(), documentSnapshot.getString("Title"), documentSnapshot.getString("Image"), documentSnapshot.getString("Author"));
                onBookResultListener.onResult(book);
            }
        });
    }

    public Book(String id, String title, String image, String author) {
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

    public String getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    /**
     * List of chapter
     * @param onTOCResultListener
     */
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
