
package com.hma.hma.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author__ {

    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("href")
    @Expose
    private String href;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
