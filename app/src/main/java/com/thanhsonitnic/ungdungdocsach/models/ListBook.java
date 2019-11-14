package com.thanhsonitnic.ungdungdocsach.models;

import com.thanhsonitnic.ungdungdocsach.R;

import java.util.ArrayList;

public class ListBook {
    private static ListBook instance = null;

    private ArrayList<Book> books = new ArrayList<>();

    private ListBook() {
        books.add(new Book("hlj933h3hd3", "Ký sự code dạo", R.drawable.kscd, "Phạm Huy Hoàng"));
        books.add(new Book("943hf4jf832", "Ngày xưa có một con bò", R.drawable.nxcmcb, "Phan Thanh Sơn"));
        books.add(new Book("s0ud44426i7", "Bản thiết kế vĩ đại", R.drawable.btkvd, "Stephen Hawking"));
    }

    public static ListBook getInstance(){
        if(instance == null)
            instance = new ListBook();
        return instance;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
