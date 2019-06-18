package com.example.enesha.cuisine;

public class  Model {

    private int id_;
    private String textName;
    private String textDesc;
    int image;

    public Model(int id_, String textName, String textDesc, int image) {
        this.id_ = id_;
        this.textName = textName;
        this.textDesc = textDesc;
        this.image = image;
    }

    public int getId_() {
        return id_;
    }

    public String getTextName() {
        return textName;
    }

    public String getTextDesc() {
        return textDesc;
    }

    public int getImage() {
        return image;
    }
}
