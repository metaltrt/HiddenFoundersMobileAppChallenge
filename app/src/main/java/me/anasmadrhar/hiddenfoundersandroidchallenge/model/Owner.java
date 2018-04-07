package me.anasmadrhar.hiddenfoundersandroidchallenge.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anas on 4/7/18.
 */

public class Owner {

    @SerializedName("login")
    private String login;


    @SerializedName("avatar_url")
    private String avatarUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getLogin() {
        return login;
    }
}
