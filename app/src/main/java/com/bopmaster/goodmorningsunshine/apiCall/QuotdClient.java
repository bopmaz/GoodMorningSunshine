package com.bopmaster.goodmorningsunshine.apiCall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tuanm on 18-Apr-17.
 */

public interface QuotdClient {

    @GET("/wp-json/posts??filter[orderby]=rand&filter[posts_per_page]=1")
    Call<List<QuoteOfTheDay>> getQuote();
}
