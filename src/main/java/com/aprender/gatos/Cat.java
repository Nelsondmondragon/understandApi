package com.aprender.gatos;

import com.google.gson.annotations.SerializedName;

public class Cat {
    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "url")
    private String url;


    private String apiKey = "23e162ba-231c-4dfe-82b8-6c841efcfc81";
    private String img;

    @SerializedName(value = "image")
    private Cat imaFavo;

    public Cat getImaFavo() {
        return imaFavo;
    }

    public void setImaFavo(Cat imaFavo) {
        this.imaFavo = imaFavo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String toString(){
        return "id " + id+ " url " + url +" apiKey " + apiKey + " img " + img + " imgFav "+ imaFavo;
    }
}
