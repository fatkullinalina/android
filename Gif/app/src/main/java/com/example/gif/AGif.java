package com.example.gif;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AGif {
    @PrimaryKey
    public long id;

    public String url;
    public AGif(long id,String url){
        this.id=id;
        this.url=url;
    }
    public String getUrl(){
        return this.url;
    }

}
