package com.thanhsonitnic.ungdungdocsach.models;

public class Chapter {
    private String id;
    private String name;
    private String Content;

    public Chapter(String id, String name, String content) {
        this.id = id;
        this.name = name;
        Content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return Content;
    }

}
