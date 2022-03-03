package com.example.retrofit.network;

import com.example.retrofit.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();

    @GET("/comments")
    Call<List<Comment>> getAllComments();
}
