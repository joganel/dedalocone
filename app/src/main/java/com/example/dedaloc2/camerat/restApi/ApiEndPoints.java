package com.example.dedaloc2.camerat.restApi;

import com.example.dedaloc2.camerat.restApi.Model.BookResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dedaloc2 on 1/24/18.
 */

public interface ApiEndPoints {

    @GET(RestApiConstant.URL_INFORMATION_USER)
    Call<BookResponse> getRecentMedia();
}
