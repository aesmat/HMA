package com.hma.hma.webservice;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostFactory {

    public final static String BASE_URL = "http://digitalcurv.com/whiteboard/wp-json/wp/v2/posts/?_embed";

    private static PostService mPostService;

    public static PostService create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(PostService.class);
    }

    public static PostService getPostService() {
        if (mPostService == null) {
            mPostService = create();
        }

        return mPostService;
    }
}
