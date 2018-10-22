package com.hma.hma.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hma.hma.R;
import com.hma.hma.databinding.ItemPostBinding;
import com.hma.hma.model.Post;
import com.hma.hma.viewmodel.PostViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostAdapterViewHolder> {

  private List<Post> mPostList = new ArrayList<>();

  public PostAdapter() {
    mPostList = Collections.emptyList();
  }

  @Override public PostAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ItemPostBinding itemPostBinding =
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_post,
            parent, false);
    return new PostAdapterViewHolder(itemPostBinding);
  }

  @Override public void onBindViewHolder(PostAdapterViewHolder holder, int position) {
    holder.bindPost(mPostList.get(position));
  }

  @Override public int getItemCount() {
    return mPostList.size();
  }

  public void setPostList(List<Post> postList) {
    mPostList = postList;
    notifyDataSetChanged();
  }

  public static class PostAdapterViewHolder extends RecyclerView.ViewHolder {
    ItemPostBinding mItemPostBinding;

    public PostAdapterViewHolder(ItemPostBinding itemPostBinding) {
      super(itemPostBinding.itemPost);
      mItemPostBinding = itemPostBinding;
    }

    void bindPost(Post p) {
      if (mItemPostBinding.getPostViewModel() == null) {
        mItemPostBinding.setPostViewModel(new PostViewModel(itemView.getContext(),p));
      } else {
        mItemPostBinding.getPostViewModel().setPost(p);
      }
    }
  }
}
