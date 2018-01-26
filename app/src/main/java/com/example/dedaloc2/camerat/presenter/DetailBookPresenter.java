package com.example.dedaloc2.camerat.presenter;

import android.content.Context;

import com.example.dedaloc2.camerat.view.IView;

import java.util.ArrayList;

/**
 * Created by dedaloc2 on 1/25/18.
 */

public class DetailBookPresenter implements IPresenter {
    public IView iView;
    public Context context;
    public ArrayList<String> booksList;

    public DetailBookPresenter(IView iView, Context context, ArrayList<String> booksList) {
        this.iView = iView;
        this.context = context;
        this.booksList = booksList;

        obtainingBooks();
    }

    @Override
    public void obtainingBooks() {
        showDataInRecycler();
    }


    @Override
    public void showDataInRecycler() {
        iView.adapterInit(iView.createAdapter(booksList));
        iView.generategridlayout();
    }
}
