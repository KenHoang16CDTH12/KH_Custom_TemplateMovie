package com.sun.kh_custom_moviestreaming;

public class Slide {
    private int mImage;
    private String mTitle;

    public Slide() {
    }

    public Slide(int image, String title) {
        mImage = image;
        mTitle = title;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
