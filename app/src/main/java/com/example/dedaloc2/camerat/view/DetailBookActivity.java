package com.example.dedaloc2.camerat.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dedaloc2.camerat.R;
import com.example.dedaloc2.camerat.adapter.BookDetailListAdapter;
import com.example.dedaloc2.camerat.adapter.BookListAdpater;
import com.example.dedaloc2.camerat.pojo.Book;
import com.example.dedaloc2.camerat.presenter.DetailBookPresenter;
import com.example.dedaloc2.camerat.presenter.IPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailBookActivity extends AppCompatActivity implements IView{

    private static final String KEY_EXTRA_URL= "url";
    private static final String KEY_EXTRA_LIKES= "likes";
    private static final String KEY_CAROUSEL_IMAGES= "imagesCarousel";

    String url;
    int likes;
    private ArrayList<String> booksList;

    private RecyclerView rvBooks;
    private IPresenter presenter;


    private ImageView book;
    private TextView likesTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

        Bundle extras = getIntent().getExtras();

        url = extras.getString(KEY_EXTRA_URL);
        likes = extras.getInt(KEY_EXTRA_LIKES);
        booksList = extras.getStringArrayList(KEY_CAROUSEL_IMAGES);

        book =  (ImageView)findViewById(R.id.book_image_detail);
        likesTo = (TextView)findViewById(R.id.books_likes_detail);

        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.icons8_read_50)
                .into(book);

        likesTo.setText(String.valueOf(likes));

        rvBooks = (RecyclerView) findViewById(R.id.recycler_view_detail);
        if(!booksList.isEmpty()) {
            presenter = new DetailBookPresenter(this, getApplicationContext(), booksList);
        }
        else{
            rvBooks.setVisibility(View.GONE);
        }
    }

    @Override
    public void generategridlayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        rvBooks.setLayoutManager(gridLayoutManager);
    }

    @Override
    public RecyclerView.Adapter createAdapter(ArrayList<? extends Object> books) {
        BookDetailListAdapter bookListAdpater = new BookDetailListAdapter((ArrayList<String>) books, this);
        return bookListAdpater;
    }


    @Override
    public void adapterInit(RecyclerView.Adapter bookListAdpater) {
        rvBooks.setAdapter(bookListAdpater);
    }
}

