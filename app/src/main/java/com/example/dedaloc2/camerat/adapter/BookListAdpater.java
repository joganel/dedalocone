package com.example.dedaloc2.camerat.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dedaloc2.camerat.view.DetailBookActivity;
import com.example.dedaloc2.camerat.R;
import com.example.dedaloc2.camerat.pojo.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dedaloc2 on 1/23/18.
 */

public class BookListAdpater extends RecyclerView.Adapter<BookListAdpater.CardHolder>{

    ArrayList<Book> books;
    Activity activity;

    public BookListAdpater(ArrayList<Book> books, Activity activity) {
        this.books = books;
        this.activity = activity;
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new CardHolder(v);
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        final Book book = books.get(position);
        //holder.imageFoto.setImageResource(Integer.parseInt(book.getImageBook()));
        holder.likes.setText(String.valueOf(book.getLikes()));
        //holder.imageFoto.setImageURI(Uri.parse(book.getImageBook()));

        Picasso.with(activity)
                .load(book.getImageBook())
                .placeholder(R.drawable.icons8_read_50)
                .into(holder.imageFoto);

        holder.imageFoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DetailBookActivity.class);
                intent.putExtra("url",book.getImageBook());
                intent.putExtra("likes",book.getLikes());
                intent.putStringArrayListExtra("imagesCarousel",book.getCarouselImage());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return books.size();
    }

    public class CardHolder extends RecyclerView.ViewHolder {

        private ImageView imageFoto;
        private TextView likes;
        public CardHolder(View itemView) {
            super(itemView);
            imageFoto = (ImageView)itemView.findViewById(R.id.book_image);
            likes = (TextView)itemView.findViewById(R.id.books_likes);
        }
    }
}
