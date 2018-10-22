package com.hma.hma.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hma.hma.R;
import com.hma.hma.adapter.PostAdapter;
import com.hma.hma.databinding.ActivityMainBinding;
import com.hma.hma.viewmodel.MainViewModel;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends Activity implements Observer {

    private ActivityMainBinding mMainActivityBinding;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDataBinding();
        setupRecyclerView(mMainActivityBinding.listPosts);
        mMainViewModel.addObserver(this);

    }
    private void initDataBinding() {
        mMainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = new MainViewModel(this);
        mMainActivityBinding.setMainViewModel(mMainViewModel);
    }
    private void setupRecyclerView(RecyclerView recycler) {
        recycler.setLayoutManager(new LinearLayoutManager(this));
        PostAdapter adapter = new PostAdapter();
        recycler.setAdapter(adapter);
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof MainViewModel) {
            PostAdapter postAdapter = (PostAdapter) mMainActivityBinding.listPosts.getAdapter();
            postAdapter.setPostList(((MainViewModel) o).getPostList());
        }
    }
}
