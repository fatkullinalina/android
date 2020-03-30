package com.example.gif;

import androidx.annotation.Nullable;

import java.util.List;

public class GifResponse {
    private List<GifDTO> data;

    @Nullable
    public List<GifDTO> getData(){
        return data;
    }
}
