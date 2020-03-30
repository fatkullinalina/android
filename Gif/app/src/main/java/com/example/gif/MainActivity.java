package com.example.gif;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {
    private static final String URL="https://api.giphy.com";
    List<GifDTO> gifs = new ArrayList<>();
    public void notifyAboutNewItems(List<GifDTO> gifky){
        gifs.addAll(gifky);
    }
    DataAdapter adapter;
    public interface GifEndpoint{
        @GET("/v1/gifs/search")
        Call<GifResponse> search(@Query("api_key")String apiKey,
                                 @Query("q")String search,@Query("limit")int amount,@Query("offset")int StartPoint);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newData(0);

            }
        });
        RecyclerView recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DataAdapter(recyclerView, this, gifs);
        recyclerView.setAdapter(adapter);
        adapter.setLoadMore(new ILoadMore() {
            @Override
            public void onLoadMore() {
                if (gifs.size() <= 100 && gifs.size()%20==0) {
                    gifs.add(null);
                    adapter.notifyItemInserted(gifs.size() - 1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            gifs.remove(gifs.size() - 1);
                            adapter.notifyItemRemoved(gifs.size());
                            int index = gifs.size();
                            newData(index);
                            adapter.notifyDataSetChanged();
                            adapter.setLoaded();
                        }
                    }, 3000);
                } else {
                    Toast.makeText(MainActivity.this, "Load data completed !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void newData(int indexStart) {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        EditText editText = findViewById(R.id.editText);
        String word = editText.getText().toString();

        GifEndpoint endpoint = retrofit.create(GifEndpoint.class);
        endpoint.search("PZP8lnlAgXXhMwcVjKyjlFV9M4VW15hY", word, 20, indexStart)
                .enqueue(new Callback<GifResponse>() {


                    @Override
                    public void onResponse(Call<GifResponse> call,
                                           Response<GifResponse> response) {

                        if (response.isSuccessful()) {
                            GifResponse result = response.body();
                            List<GifDTO> gifs=new ArrayList<>();
                            gifs = result.getData();
                            notifyAboutNewItems(gifs);

                        }
                    }

                    @Override
                    public void onFailure(Call<GifResponse> call, Throwable t) {

                    }
                });

    }
}

