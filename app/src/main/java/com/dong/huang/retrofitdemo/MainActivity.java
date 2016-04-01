package com.dong.huang.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    //BASE_URL：一般都是域名
    private static final String BASE_URL = "http://app.wy.guahao.com/json/white/applocal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //添加头部的方式
        Interceptor interceptor = new Interceptor() {
            @Override
            public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("apikey", "c1d09145de3bbd6af864b3c92dbf8800").build();
                return chain.proceed(newRequest);
            }
        };

        OkHttpClient client = new OkHttpClient();
        client.interceptors().add(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                                    .addConverterFactory(GsonConverterFactory.create())
//                                    .client(client)
                .build();

        MyApiInterface apiInterface = retrofit.create(MyApiInterface.class);

        Call<JsonModel> telModelCall = apiInterface.getTelModel();

        telModelCall.enqueue(new Callback<JsonModel>() {
            @Override
            public void onResponse(Response<JsonModel> response, Retrofit retrofit) {
                int statusCode = response.code();
                Log.i("123","----->" + statusCode);
                JsonModel telModel = response.body();
                Log.i("123","----->" + telModel);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i("123","------>" + t.toString());
            }
        });

    }
}
