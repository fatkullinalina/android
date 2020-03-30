package com.example.gif;

import com.google.gson.annotations.SerializedName;

public class UserDTO {
    @SerializedName("avatar_url")
    private String photoUrl;

    public String getPhUrl(){
        return photoUrl;
    }
}
