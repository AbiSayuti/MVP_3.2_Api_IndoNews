package com.abisayuti.indonews.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {
    public static String Weburl = "https://newsapi.org/v2/";

    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(Weburl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance() {
        return setInit().create(ApiService.class);
    }
}
