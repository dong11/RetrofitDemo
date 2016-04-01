package com.dong.huang.retrofitdemo;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by dong on 16/4/1.
 */
public interface MyApiInterface {
    @GET("https://api.github.com")
    Call<JsonModel> getTelModel();
}
