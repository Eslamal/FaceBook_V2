package com.example.facebook_v2.ui.main;

import androidx.lifecycle.MutableLiveData;

import com.example.facebook_v2.data.postClient;
import com.example.facebook_v2.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModel extends androidx.lifecycle.ViewModel {
    MutableLiveData<List<Posts>> mutableLiveData=new MutableLiveData<List<Posts>>();


    public void getPosts(){
        postClient.getInstance().getPost().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });
    }
}
