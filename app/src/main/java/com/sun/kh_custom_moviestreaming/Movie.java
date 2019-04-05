package com.sun.kh_custom_moviestreaming;

import java.io.Serializable;

public class Movie implements Serializable {
    private String mTitle;
    private String mDescription;
    private int mThumbnail;
    private String mStudio;
    private String mRating;
    private String mStreamUrl;

    public Movie() {
    }

    public Movie(String title, int thumbnail) {
        mTitle = title;
        mThumbnail = thumbnail;
    }

    public Movie(String title, String description, int thumbnail, String studio, String rating,
            String streamUrl) {
        mTitle = title;
        mDescription = description;
        mThumbnail = thumbnail;
        mStudio = studio;
        mRating = rating;
        mStreamUrl = streamUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        mThumbnail = thumbnail;
    }

    public String getStudio() {
        return mStudio;
    }

    public void setStudio(String studio) {
        mStudio = studio;
    }

    public String getRating() {
        return mRating;
    }

    public void setRating(String rating) {
        mRating = rating;
    }

    public String getStreamUrl() {
        return mStreamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        mStreamUrl = streamUrl;
    }
}
