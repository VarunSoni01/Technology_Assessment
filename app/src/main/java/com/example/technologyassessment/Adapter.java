package com.example.technologyassessment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.technologyassessment.Models.Articles;
import com.example.technologyassessment.Models.Model;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    List<Articles> list;

    public Adapter(Context context, List<Articles> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);

        return new Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getTitle());
        if(list.get(position).getAuthor() == null){
            holder.title.setText("Author is not provided in API");
        }
        else{
            holder.title.setText(list.get(position).getAuthor());
        }
        Picasso.get().load(list.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,title;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.news_name);
            title = itemView.findViewById(R.id.news_title);
            imageView = itemView.findViewById(R.id.news_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = getAdapterPosition();
                    String index = String.valueOf(id);
                    Intent intent = new Intent(context,DetailActivity.class);
                    intent.putExtra("check",index);
                    context.startActivity(intent);
                }
            });

        }

    }


}
