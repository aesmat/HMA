
package com.hma.hma.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reply_ {

    @SerializedName("attributes")
    @Expose
    private Attributes_ attributes;
    @SerializedName("href")
    @Expose
    private String href;

    public Attributes_ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes_ attributes) {
        this.attributes = attributes;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
