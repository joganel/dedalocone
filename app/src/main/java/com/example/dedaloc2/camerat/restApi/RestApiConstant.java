package com.example.dedaloc2.camerat.restApi;

/**
 * Created by dedaloc2 on 1/24/18.
 */

public class RestApiConstant {


    public static final String VERSION = "/v1/";
    public static final String URL_BASE = "https://api.instagram.com" + VERSION;
    public static final String ACCES_TOKEN = "6937277066.1849d52.480d0aa172e24631b17e7f2fb465c2cd";
    public static final String KEY_ACCES_TOKEN = "?access_token=";
    public static final String KEY_GET_INFORMATION_USER = "users/self/media/recent/";

    public static final String URL_INFORMATION_USER = KEY_GET_INFORMATION_USER+KEY_ACCES_TOKEN+ACCES_TOKEN;


}
