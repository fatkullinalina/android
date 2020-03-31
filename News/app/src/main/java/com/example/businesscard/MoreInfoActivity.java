package com.example.businesscard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.businesscard.data.DataUtils;
import com.example.businesscard.data.NewsItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MoreInfoActivity extends AppCompatActivity {
    public final static String ID="ID";
    public NewsItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        item=DataUtils.generateNews().get(getIntent().getIntExtra(ID,0));
        TextView title=findViewById(R.id.textView5);
        title.setText(item.getTitle());
        ImageView img=findViewById(R.id.imageView2);
        Glide.with(this).load(item.getImageUrl()).into(img);
        String pattern="MM/dd/yyyy HH:mm:ss";
        DateFormat df=new SimpleDateFormat(pattern);
        Date data=item.getPublishDate();
        String data2=df.format(data);
        TextView date=findViewById(R.id.textView6);
        date.setText(data2);
        TextView full=findViewById(R.id.textView7);
        full.setText(item.getFullText());

    }

}
