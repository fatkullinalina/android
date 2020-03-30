package com.example.gif;

public class GifDTO {
    private UserDTO user;
    private ImagesDTO images;

    public String getUrl(){
        return images.getOriginal().getUrl();
    }
}

 class ImagesDTO{
    private OriginalDTO original;
    public OriginalDTO getOriginal(){
        return original;
    }
 }

 class OriginalDTO{
    private String url;

    public String getUrl(){
        return url;
    }
 }