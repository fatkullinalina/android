package com.example.businesscard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.businesscard.data.NewsItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private final List<NewsItem> news;
    private final Context context;
    private final LayoutInflater inflater;


    public NewsAdapter(Context context,List<NewsItem> news) {
        this.news = news;
        this.context = context;
        inflater = LayoutInflater.from(context);

    }
    @Override
    public int getItemCount() {
        return news.size();
    }

    //@Override
    public int getCount(){
        return news.size();
    }
    //@Override
    public NewsItem getItem(int position){
        return news.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                inflater.inflate(R.layout.list_item_news, parent, false)
        );
    }



    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsItem item=news.get(position);
        holder.nameView.setText(item.getTitle());
        holder.inner.setText(item.getPreviewText());
        holder.category.setText(item.getCategory().getName());
        String pattern="MM/dd/yyyy HH:mm:ss";
        DateFormat df=new SimpleDateFormat(pattern);
        Date data=item.getPublishDate();
        String data2=df.format(data);
        holder.date.setText(data2);
        Glide.with(context).load(item.getImageUrl()).into(holder.image);

    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final ImageView image;
        public final TextView nameView;
        public final TextView inner;
        public final TextView date;
        public final TextView category;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            inner = itemView.findViewById(R.id.textView3);
            nameView = itemView.findViewById(R.id.textView2);
            date = itemView.findViewById(R.id.textView4);
            category = itemView.findViewById(R.id.textView);



        }


    }
    }


