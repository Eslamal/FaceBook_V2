package com.example.facebook_v2.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebook_v2.R;
import com.example.facebook_v2.model.Posts;

import java.util.List;

public class MainActivity extends AppCompatActivity {
ViewModel viewModel;
RecyclerView recyclerView;
Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel=new ViewModelProvider(this).get(ViewModel.class);
        recyclerView=findViewById(R.id.rv);
        adapter=new Adapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        viewModel.getPosts();
       viewModel.mutableLiveData.observe(this, new Observer<List<Posts>>() {
           @Override
           public void onChanged(List<Posts> posts) {
               adapter.setList(posts);
           }
       });
    }
}