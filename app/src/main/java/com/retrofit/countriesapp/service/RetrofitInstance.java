package com.retrofit.countriesapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static String BASE_URL = "http://www.groupkt.com/";

    public static GetCountryDataServiceInterface getServiceInstance() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }


        return retrofit.create(GetCountryDataServiceInterface.class);
    }

}
