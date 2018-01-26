package com.example.dedaloc2.camerat.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dedaloc2.camerat.R;
import com.example.dedaloc2.camerat.adapter.BookListAdpater;
import com.example.dedaloc2.camerat.pojo.Book;
import com.example.dedaloc2.camerat.presenter.IPresenter;
import com.example.dedaloc2.camerat.presenter.BookListPresenter;

import java.util.ArrayList;

public class BooksListActivity extends AppCompatActivity implements IView {

    private ArrayList<Book> booksList;
    private RecyclerView rvBooks;
    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        rvBooks = (RecyclerView) findViewById(R.id.recycler_view);
        presenter = new BookListPresenter(this, getApplicationContext());
    }


    @Override
    public void generategridlayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        rvBooks.setLayoutManager(gridLayoutManager);
    }

    @Override
    public RecyclerView.Adapter createAdapter(ArrayList<? extends Object> books) {
        BookListAdpater bookListAdpater = new BookListAdpater((ArrayList<Book>) books, this);
        return bookListAdpater;
    }

    @Override
    public void adapterInit(RecyclerView.Adapter bookListAdpater) {
        rvBooks.setAdapter(bookListAdpater);
    }
}
