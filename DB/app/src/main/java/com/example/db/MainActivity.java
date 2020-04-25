package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MusicDao musicDao=((AppDelegate)getApplicationContext()).getMusicDataBase().getMusicDao();
        Button add=findViewById(R.id.addbutton);
        Button get=findViewById(R.id.getbutton);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                musicDao.insertAlbums(createAlbums());
                Toast.makeText(MainActivity.this, "сгенерировано",Toast.LENGTH_LONG).show();
            }
        });
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Album> list=musicDao.getAlbums();
                showToast(list);
                TextView text=findViewById(R.id.textView);
                for(int i=0;i<list.size();i++){
                    text.append(list.get(i).toString());
                }

            }
        });
    }

    private void showToast(List<Album> albums) {
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<albums.size();i++){
            builder.append(albums.get(i).toString()).append("heh");
        }
        Toast.makeText(this, builder.toString(),Toast.LENGTH_LONG).show();
    }

    private List<Album> createAlbums() {
        List<Album> albums=new ArrayList<>(10);
        for(int i=0;i<10;i++){
            albums.add(new Album(i,"album"+i," " + System.currentTimeMillis()));
        }
        return albums;
    }
}
