package com.hma.hma.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hma.hma.model.Post;

public class PostViewModel extends BaseObservable {

    private Post mPost;
    private Context mContext;

    public PostViewModel(@NonNull Context context,Post post) {

        mContext = context;
        mPost = post;
    }
    public String getTitle() {
        return mPost.getTitle().getRendered();
    }
    public String getAuthor() {
        return mPost.getEmbedded().getAuthor().get(0).getName();
    }
    public String getDate() {
        return mPost.getDate();
    }

    public String getCoverURL() {
        return mPost.getEmbedded().getWpFeaturedmedia().get(0).getMediaDetails().getSizes().getThumbnail().getSourceUrl();
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
    public void setPost(Post p) {
        mPost = p;
        notifyChange();
    }
    public void onClick(View view) {

    }
}
