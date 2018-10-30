package com.abisayuti.indonews.Network;

import com.abisayuti.indonews.Main.Model.ResponseGetNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    @GET("top-headlines?")
    Call<ResponseGetNews> getNewsData(
            @Query("country") String id,
            @Query("key") String key
    );
}
