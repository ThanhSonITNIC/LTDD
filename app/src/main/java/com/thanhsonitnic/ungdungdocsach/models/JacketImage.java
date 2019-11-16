package com.thanhsonitnic.ungdungdocsach.models;

import android.content.Context;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class JacketImage {
    private static JacketImage instance = null;

    private JacketImage(){

    }

    public static JacketImage getInstance(){
        if(instance == null){
            instance = new JacketImage();
        }
        return instance;
    }

    /**
     * Load image
     * @param imageView
     * @param location (full https://)
     */
    public void loadImage(ImageView imageView, String location){
        Picasso.get().load(location).into(imageView);
    }
}
