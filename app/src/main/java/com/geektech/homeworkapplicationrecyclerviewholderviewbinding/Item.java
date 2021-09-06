package com.geektech.homeworkapplicationrecyclerviewholderviewbinding;

import android.widget.ImageView;
import android.widget.TextView;

public class Item {
    private String textView;
    private int imageView, type;

    public Item(int type, String textView) {
        this.textView = textView;
        this.type = type;
    }

    public Item(int type, String textView, int imageView) {
        this.textView = textView;
        this.imageView = imageView;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
