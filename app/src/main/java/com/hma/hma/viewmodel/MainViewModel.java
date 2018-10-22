package com.hma.hma.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.hma.hma.model.Post;
import com.hma.hma.webservice.PostFactory;
import com.hma.hma.webservice.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends Observable {

    private List<Post> mPostList;
    private Context mContext;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public ObservableInt recyclerStatus = new ObservableInt(View.GONE) ;
    public ObservableInt progressStatus = new ObservableInt(View.GONE) ;

    public MainViewModel(@NonNull Context context) {

        mContext = context;
        mPostList = new ArrayList<>();

    }

    public List<Post> getPostList() {
        return mPostList;
    }

    public void fetchPostList() {
        setLoading(true);

        PostService postService = PostFactory.getPostService();

        Disposable disposable = postService.fetchPosts(PostFactory.BASE_URL)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                    @Override
                    public void accept(List<Post> postResponse) throws Exception {
                        setLoading(false);

                        mPostList.addAll(postResponse);
                        setChanged();
                        notifyObservers();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        setLoading(false);
                        Toast.makeText(mContext,throwable.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        mCompositeDisposable.add(disposable);
    }
    private void setLoading(boolean isLoading){
        recyclerStatus.set(isLoading?View.GONE:View.VISIBLE);
        progressStatus.set(isLoading?View.VISIBLE:View.GONE) ;
    }
    public void fetch_onClick(View view) {
        fetchPostList();
    }
    public void clear_onClick(View view) {

    }
}
