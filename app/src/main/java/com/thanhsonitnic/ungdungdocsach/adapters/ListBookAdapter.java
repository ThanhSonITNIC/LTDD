package com.thanhsonitnic.ungdungdocsach.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.thanhsonitnic.ungdungdocsach.R;
import com.thanhsonitnic.ungdungdocsach.models.Book;
import com.thanhsonitnic.ungdungdocsach.models.JacketImage;

import java.util.ArrayList;

public class ListBookAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Book> books;

    public ListBookAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Book> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.books = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.book_listview, parent, false);

        TextView txtTitle = convertView.findViewById(R.id.txtTitle);
        TextView txtAuthor = convertView.findViewById(R.id.txtAuthor);
        ImageView imageView = convertView.findViewById(R.id.imgJacket);

        txtTitle.setText(books.get(position).getTitle());
        txtAuthor.setText(books.get(position).getAuthor());
        JacketImage.getInstance().loadImage(imageView, books.get(position).getImage());

        return convertView;
    }
}
