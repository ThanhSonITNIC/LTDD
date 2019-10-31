package com.thanhsonitnic.ungdungdocsach.models;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class Setting{
    private static Setting instance = null;
    private static Context context;
    private SharedPreferences sharedPreferences;

    private Setting() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static Setting getInstance(Context context){
        Setting.context = context;
        if(instance == null)
            instance = new Setting();
        return instance;
    }

    public Boolean getIsDarkTheme() {
        return sharedPreferences.getBoolean("isDarkTheme", false);
    }

    public int getContentTextSize() {
        return sharedPreferences.getInt("textSize", 18);
    }

    public int getTimeAutoScroll() {
        return sharedPreferences.getInt("timeAutoScroll", 15);
    }
}
