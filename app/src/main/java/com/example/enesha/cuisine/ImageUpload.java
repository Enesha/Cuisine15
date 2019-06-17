package com.example.enesha.cuisine;

import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class ImageUpload {

    public String name;
    public String url;
    public String ingredients;
    public String description;


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }

    public ImageUpload(String name, String url) {
        this.name = name;
        this.url = url;
        this.ingredients = ingredients;
        this.description = description;
    }
}
