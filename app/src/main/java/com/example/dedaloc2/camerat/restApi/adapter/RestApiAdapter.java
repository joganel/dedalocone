package com.example.dedaloc2.camerat.restApi.adapter;

import com.example.dedaloc2.camerat.restApi.ApiEndPoints;
import com.example.dedaloc2.camerat.restApi.Model.BookResponse;
import com.example.dedaloc2.camerat.restApi.RestApiConstant;
import com.example.dedaloc2.camerat.restApi.deseralizer.BookDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dedaloc2 on 1/24/18.
 */

public class RestApiAdapter {

    public ApiEndPoints creatingRestApiConnexions(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestApiConstant.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(ApiEndPoints.class);
    }

    public Gson buildingJsonDeserializerMedia(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BookResponse.class, new BookDeserializer());
        return gsonBuilder.create();
    }
}
