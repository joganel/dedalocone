package com.example.dedaloc2.camerat.pojo;

import java.util.ArrayList;

/**
 * Created by dedaloc2 on 1/23/18.
 */

public class Book {


    private String imageBook;
    private String id;
    private String name;
    private int likes = 0;
    private ArrayList<String> carouselImage;

    public Book() {}

    public Book(String imageBook, String id, String name, int likes, ArrayList<String> carouselImage) {
        this.imageBook = imageBook;
        this.id = id;
        this.name = name;
        this.likes = likes;
        this.carouselImage = carouselImage;
    }

    public String getImageBook() {
        return imageBook;
    }

    public void setImageBook(String imageBook) {
        this.imageBook = imageBook;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setCarouselImage(ArrayList<String> carouselImage) {
        this.carouselImage = carouselImage;
    }

    public ArrayList<String> getCarouselImage() {
        return carouselImage;
    }
}
