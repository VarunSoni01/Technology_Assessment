package com.example.technologyassessment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.technologyassessment.Models.Articles;
import com.example.technologyassessment.Models.Model;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView title,author,date,content,url;
    List<Articles> articles;
    Retrofit retrofit;
    ApiInterface api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = findViewById(R.id.det_title);
        author = findViewById(R.id.det_author);
        date = findViewById(R.id.det_date);
        content = findViewById(R.id.det_content);
        imageView = findViewById(R.id.det_image);
        url = findViewById(R.id.det_url);

        String id = getIntent().getStringExtra("check");
        int value = Integer.valueOf(id);
        articles = new ArrayList<>();

        data(value);



    }

    private void data(int value) {

        retrofit = new Retrofit.Builder().baseUrl(Constants.url).addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(ApiInterface.class);

        Call<Model> call = api.getlist();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                articles.addAll(response.body().getArticles());
                Picasso.get().load(articles.get(value).getImage()).into(imageView);
                title.setText(articles.get(value).getTitle());
                if(articles.get(value).getAuthor() == null){
                    author.setText("Author is not provided in API");
                }
                else{
                    author.setText(articles.get(value).getAuthor());
                }
                date.setText(articles.get(value).getPubat());
                content.setText(articles.get(value).getContent());
                url.setText(articles.get(value).getUrl());

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}