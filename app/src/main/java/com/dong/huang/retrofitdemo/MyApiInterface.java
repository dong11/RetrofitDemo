package com.dong.huang.retrofitdemo;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by dong on 16/4/1.
 */
public interface MyApiInterface {
    @GET("/users/{user}")
    Call<JsonModel> getTelModel(@Path("user") String user);
}
