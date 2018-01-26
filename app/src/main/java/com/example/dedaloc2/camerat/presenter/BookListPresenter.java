package com.example.dedaloc2.camerat.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.dedaloc2.camerat.pojo.Book;
import com.example.dedaloc2.camerat.restApi.ApiEndPoints;
import com.example.dedaloc2.camerat.restApi.Model.BookResponse;
import com.example.dedaloc2.camerat.restApi.adapter.RestApiAdapter;
import com.example.dedaloc2.camerat.view.IView;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dedaloc2 on 1/24/18.
 */

public class BookListPresenter implements IPresenter {

    public IView iRecylcerView;
    public Context context;
    public ArrayList<Book> booksList;

    public BookListPresenter(IView iRecylcerView, Context context) {
        this.iRecylcerView = iRecylcerView;
        this.context = context;

        obtainingBooks();
    }

    @Override
    public void obtainingBooks() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.buildingJsonDeserializerMedia();

        ApiEndPoints apiEndPoints = restApiAdapter.creatingRestApiConnexions(gsonMediaRecent);
        Call<BookResponse> callBookResponce = apiEndPoints.getRecentMedia();

        callBookResponce.enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                BookResponse bookResponse = response.body();
                booksList = bookResponse.getBooks();
                showDataInRecycler();
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {
                Toast.makeText(context,"Something wrong, not conection", Toast.LENGTH_SHORT).show();
                Log.i("Conexion failed",t.toString());

            }
        });
    }


    @Override
    public void showDataInRecycler() {
        iRecylcerView.adapterInit(iRecylcerView.createAdapter(booksList));
        iRecylcerView.generategridlayout();

    }
}
