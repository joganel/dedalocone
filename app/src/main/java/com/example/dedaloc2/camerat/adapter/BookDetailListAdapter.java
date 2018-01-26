package com.example.dedaloc2.camerat.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dedaloc2.camerat.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dedaloc2 on 1/25/18.
 */

public class BookDetailListAdapter extends RecyclerView.Adapter<BookDetailListAdapter.CardBookDetailHolder> {

    ArrayList<String> books;
    Activity activity;

    public BookDetailListAdapter(ArrayList<String> books, Activity activity) {
        this.books = books;
        this.activity = activity;
    }

    @Override
    public CardBookDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_detail, parent, false);
        return new CardBookDetailHolder(v);
    }

    @Override
    public void onBindViewHolder(CardBookDetailHolder holder, int position) {
        final String book = books.get(position);
        //holder.imageFoto.setImageResource(Integer.parseInt(book.getImageBook()));

        Picasso.with(activity)
                .load(book)
                .placeholder(R.drawable.icons8_read_50)
                .into(holder.imageFoto);

    }

    @Override
    public int getItemCount() {

        return books.size();
    }

    public class CardBookDetailHolder extends RecyclerView.ViewHolder {

        private ImageView imageFoto;
        public CardBookDetailHolder(View itemView) {
            super(itemView);
            imageFoto = (ImageView)itemView.findViewById(R.id.book_image_detail_carousel);
        }
    }
}

