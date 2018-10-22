package com.hma.hma.webservice;
import com.hma.hma.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PostService {

    @GET
    Observable<List<Post>> fetchPosts(@Url String url);

}
