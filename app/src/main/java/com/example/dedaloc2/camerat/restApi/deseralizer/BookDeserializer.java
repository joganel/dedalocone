package com.example.dedaloc2.camerat.restApi.deseralizer;

import com.example.dedaloc2.camerat.pojo.Book;
import com.example.dedaloc2.camerat.restApi.Model.BookResponse;
import com.example.dedaloc2.camerat.restApi.Model.JsonKeys;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by dedaloc2 on 1/24/18.
 */

public class BookDeserializer implements JsonDeserializer<BookResponse>{


    @Override
    public BookResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        BookResponse bookResponse = gson.fromJson(json,BookResponse.class);
        JsonArray bookResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        bookResponse.setBooks(deseralizationOfBook(bookResponseData));

        return bookResponse;
    }

    private ArrayList<Book> deseralizationOfBook(JsonArray bookResponseData){
        ArrayList<Book> booksList = new ArrayList<>();
        Book book;

        for (int i = 0; i < bookResponseData.size(); i++) {

            JsonObject bookData = bookResponseData.get(i).getAsJsonObject();

            JsonObject userJson = bookData.getAsJsonObject(JsonKeys.USER);
            String id = userJson.get(JsonKeys.USER_ID).getAsString();
            String name = userJson.get(JsonKeys.FULL_NAME).getAsString();

            JsonObject imageJson = bookData.getAsJsonObject(JsonKeys.MEDIA_IMAGE);
            JsonObject imageResolution = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlImage = imageResolution.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = bookData.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likesCount = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            JsonArray carouselMedia = bookData.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_CAROUSEL_MEDIA);

            ArrayList<String> urlImageCarouselList = new ArrayList<>();

            String imageDetailCarousel;

            if (carouselMedia != null) {

                for (int j = 0; j < carouselMedia.size(); j++) {
                    JsonObject imageDetail = carouselMedia.get(j).getAsJsonObject();
                    JsonObject imageJsonDetail = imageDetail.getAsJsonObject(JsonKeys.MEDIA_IMAGE);
                    JsonObject imagesListResolution = imageJsonDetail.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
                    imageDetailCarousel = imagesListResolution.get(JsonKeys.MEDIA_URL).getAsString();
                    urlImageCarouselList.add(imageDetailCarousel);
                }
            }



            book = new Book();

            book.setId(id);
            book.setName(name);
            book.setImageBook(urlImage);
            book.setLikes(likesCount);
            book.setCarouselImage(urlImageCarouselList);


            booksList.add(book);
        }
        return booksList;

    }

}
