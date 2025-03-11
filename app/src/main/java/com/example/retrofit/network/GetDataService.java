package com.example.retrofit.network;

import com.example.retrofit.model.Comment;
import com.example.retrofit.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetDataService {
    // @Headers({"X-RapidAPI-key: oiweurju08435u092hjfhds98"})
    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();

    @GET("/comments")
    Call<List<Comment>> getAllComments();
}
