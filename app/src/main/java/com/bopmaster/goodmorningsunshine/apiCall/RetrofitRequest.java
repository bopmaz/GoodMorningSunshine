package com.bopmaster.goodmorningsunshine.apiCall;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tuanm on 18-Apr-17.
 */

public class RetrofitRequest {
    static String API_BASE_URL = " http://quotesondesign.com";

    static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

    static {
        init();
    }

    public static Retrofit retrofit() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build());
        return builder.client(httpClient.build()).build();
    }

    public static void init() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // Print HTTP requests/responses through LogCat
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(logging);
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request().newBuilder().build();
                return chain.proceed(original);
            }
        });
    }

}
