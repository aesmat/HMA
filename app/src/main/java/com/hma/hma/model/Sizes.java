
package com.hma.hma.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sizes {

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("medium")
    @Expose
    private Medium medium;
    @SerializedName("twentyseventeen-thumbnail-avatar")
    @Expose
    private TwentyseventeenThumbnailAvatar twentyseventeenThumbnailAvatar;
    @SerializedName("full")
    @Expose
    private Full full;

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public TwentyseventeenThumbnailAvatar getTwentyseventeenThumbnailAvatar() {
        return twentyseventeenThumbnailAvatar;
    }

    public void setTwentyseventeenThumbnailAvatar(TwentyseventeenThumbnailAvatar twentyseventeenThumbnailAvatar) {
        this.twentyseventeenThumbnailAvatar = twentyseventeenThumbnailAvatar;
    }

    public Full getFull() {
        return full;
    }

    public void setFull(Full full) {
        this.full = full;
    }

}
