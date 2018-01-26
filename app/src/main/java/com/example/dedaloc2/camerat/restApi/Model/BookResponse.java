package com.example.dedaloc2.camerat.restApi.Model;

import com.example.dedaloc2.camerat.pojo.Book;

import java.util.ArrayList;

/**
 * Created by dedaloc2 on 1/24/18.
 */

public class BookResponse {

    ArrayList<Book> books;



    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
