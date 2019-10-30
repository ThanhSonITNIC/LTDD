package com.thanhsonitnic.ungdungdocsach.models;

public class Book {
    private String title;
    private int image;
    private String author;

    public Book() {

    }

    public Book(String title, int image, String author) {
        this.title = title;
        this.image = image;
        this.author = author;
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
}
