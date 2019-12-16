package com.example.myyappfortest.view;

import com.example.myyappfortest.model.MyPojo;
import com.example.myyappfortest.model.MyPojoArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyService {

    @GET("/posts")
    Call<List<MyPojo>> getUlist();
}
