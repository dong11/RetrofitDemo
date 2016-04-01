package com.dong.huang.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

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

    private static final String TAG = "Retrofit";

    //BASE_URL：一般都是域名
    private static final String BASE_URL = "https://api.github.com";

    private EditText mEditText;
    private TextView mTextView;

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editText);
        mTextView = (TextView) findViewById(R.id.textView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    public void btnClick(View view){
        final String userName = mEditText.getText().toString();
        if(userName == null){
            return;
        }

        mProgressBar.setVisibility(View.VISIBLE);

        //添加头部的方式
        Interceptor interceptor = new Interceptor() {
            @Override
            public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("User-Agent", "Retrofit-Sample-App").build();
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

        Call<JsonModel> telModelCall = apiInterface.getTelModel(userName);

        //异步在UI线程返回结果
        telModelCall.enqueue(new Callback<JsonModel>() {
            @Override
            public void onResponse(Response<JsonModel> response, Retrofit retrofit) {

                mProgressBar.setVisibility(View.GONE);

                JsonModel jsonModel = response.body();

                if(jsonModel != null) {
                    mTextView.setText("login::" + jsonModel.getLogin() + "\nid::" + jsonModel.getId() +
                            "\nurl::" + jsonModel.getUrl() + "\npublic_repos" + jsonModel.getPublic_repos());
                } else {
                    mTextView.setText("github没有" + userName + "这用户");
                }

            }

            @Override
            public void onFailure(Throwable t) {
                mTextView.setText(t.getMessage());
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
