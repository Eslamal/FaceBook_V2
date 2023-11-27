package com.example.facebook_v2.data;

import com.example.facebook_v2.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
@GET("posts")
    public Call<List<Posts>>getPost();
}
