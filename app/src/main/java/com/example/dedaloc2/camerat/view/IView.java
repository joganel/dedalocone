package com.example.dedaloc2.camerat.view;

import android.support.v7.widget.RecyclerView;

import com.example.dedaloc2.camerat.adapter.BookListAdpater;
import com.example.dedaloc2.camerat.pojo.Book;

import java.util.ArrayList;

/**
 * Created by dedaloc2 on 1/24/18.
 */

public interface IView {
    void generategridlayout();
    RecyclerView.Adapter createAdapter(ArrayList<? extends Object> books);
    void adapterInit(RecyclerView.Adapter rvAdpater);
}
