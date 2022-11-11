package com.example.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class Comment {
    @SerializedName("postId")
    public Integer postId;

    @SerializedName("id")
    public Integer id;

    @SerializedName("name")
    public String name;

    @SerializedName("email")
    public String email;

    @SerializedName("body")
    public String body;
}
