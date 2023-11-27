package com.example.facebook_v2.data;

import com.example.facebook_v2.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class postClient {
    private  static postClient Instance ;
  private PostInterface postInterface;
    public postClient() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.org/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        postInterface =retrofit.create(PostInterface.class);
    }
    public static postClient getInstance(){
        if(Instance==null){
            Instance=new postClient();
        }
        return Instance;
    }
    public Call<List<Posts>>getPost(){
       return  postInterface.getPost();
    }
}
