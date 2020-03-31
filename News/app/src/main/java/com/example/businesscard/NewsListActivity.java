package com.example.businesscard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.businesscard.data.DataUtils;
import com.example.businesscard.data.NewsItem;
import com.example.businesscard.data.Category;
public class NewsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        RecyclerView listview=findViewById(R.id.list_view);
        listview.setAdapter(new NewsAdapter(this, DataUtils.generateNews()));
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
        listview.setLayoutManager(new GridLayoutManager(this,2));}
        else {
            listview.setLayoutManager(new LinearLayoutManager(this));
        }

        listview.addOnItemTouchListener(
                new RecyclerClickListener(this,new RecyclerClickListener.OnItemClickListener(){
                    @Override public void onItemClick(View view,int position){
                        Intent intent=new Intent(NewsListActivity.this,MoreInfoActivity.class);
                        intent.putExtra(MoreInfoActivity.ID,position);
                        startActivity(intent);
                    }
                }
                ));



    }

}
