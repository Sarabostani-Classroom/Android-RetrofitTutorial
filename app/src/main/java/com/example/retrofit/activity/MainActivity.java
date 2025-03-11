package com.example.retrofit.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.R;
import com.example.retrofit.adapter.CustomAdapter;
import com.example.retrofit.model.Comment;
import com.example.retrofit.model.RetroPhoto;
import com.example.retrofit.network.GetDataService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.internal.EverythingIsNonNull;


public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String BASE_URL = "https://jsonplaceholder.typicode.com"; // https://jsonplaceholder.typicode.com?key=value

        // Volley
        // Singleton pattern
        Retrofit retrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        // Create a reference for the RetrofitInstance interface
        GetDataService service = retrofit.create(GetDataService.class);

        Call<List<RetroPhoto>> call = service.getAllPhotos();


        call.enqueue(new Callback<List<RetroPhoto>>() {

            @Override
            @EverythingIsNonNull
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                generateDataList(response.body());
            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        Call<List<Comment>> commentCall = service.getAllComments();
        commentCall.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                Log.i("Comment", response.body().get(0).body);
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });

    }

    private void generateDataList(List<RetroPhoto> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this, photoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);
    }

}
