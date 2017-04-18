package com.bopmaster.goodmorningsunshine.Adapter;

import android.util.Log;

import com.bopmaster.goodmorningsunshine.apiCall.QuotdClient;
import com.bopmaster.goodmorningsunshine.apiCall.QuoteOfTheDay;
import com.bopmaster.goodmorningsunshine.apiCall.RetrofitRequest;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by tuanm on 18-Apr-17.
 */

public class CallAdapter {

    static Retrofit retrofit = RetrofitRequest.retrofit();
    static QuotdClient client = retrofit.create(QuotdClient.class);

    public CallAdapter() {
        super();
    }

    public void getPost() {

        Call<QuoteOfTheDay> call = client.getQuote();
        call.enqueue(new Callback<QuoteOfTheDay>() {
            @Override
            public void onResponse(Call<QuoteOfTheDay> call, Response<QuoteOfTheDay> response) {
                if (response.code() == 200 && response.body() != null) {
                    Log.e("#### dcm response", response.body().getContent());
                } else {
                    Log.e("#### dcm error", String.valueOf(response.code()) + response.message());
                }
            }

            @Override
            public void onFailure(Call<QuoteOfTheDay> call, Throwable t) {
                Log.e("#### dcm fail", " error" + t.toString());
            }
        });
    }
}
