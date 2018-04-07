package me.anasmadrhar.hiddenfoundersandroidchallenge.model;

import android.annotation.SuppressLint;

import com.google.gson.annotations.SerializedName;

public class Repo {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("description")
    private String description;

    @SerializedName("stargazers_count")
    private int stargazers;


    @SuppressLint("DefaultLocale")
    public String getStargazers() {
        return stargazers>=1000?String.format("%.1fk",stargazers/1000.0):stargazers+"";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }
}