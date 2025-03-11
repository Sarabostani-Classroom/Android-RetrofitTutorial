package com.example.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class RetroPhoto {

    @SerializedName("albumId")
    public Integer albumId;
    @SerializedName("id")
    public Integer id;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;
    @SerializedName("thumbnailUrl")
    public String thumbnailUrl;
}
