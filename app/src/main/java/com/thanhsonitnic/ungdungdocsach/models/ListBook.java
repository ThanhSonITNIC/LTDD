package com.thanhsonitnic.ungdungdocsach.models;

import com.thanhsonitnic.ungdungdocsach.R;

import java.util.ArrayList;

public class ListBook {
    private static ListBook instance = null;

    private ArrayList<Book> books = new ArrayList<>();

    private ListBook() {
        books.add(new Book("0", "Ký sự code dạo", "https://firebasestorage.googleapis.com/v0/b/ungdungdocsach.appspot.com/o/kscd.png?alt=media&token=6214d474-2481-4582-a16f-42c212202ea0", "Phạm Huy Hoàng"));
        books.add(new Book("1", "Ngày xưa có một con bò", "https://firebasestorage.googleapis.com/v0/b/ungdungdocsach.appspot.com/o/nxcmcb.jpg?alt=media&token=d3f34182-5088-4a6f-ac54-5ede3eb44afd", "Phan Thanh Sơn"));
        books.add(new Book("2", "Bản thiết kế vĩ đại", "https://firebasestorage.googleapis.com/v0/b/ungdungdocsach.appspot.com/o/btkvd.png?alt=media&token=e3f56170-3ddf-4a43-ad90-b43f8d4194f5", "Stephen Hawking"));
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
