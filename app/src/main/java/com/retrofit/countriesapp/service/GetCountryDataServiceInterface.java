package com.retrofit.countriesapp.service;

import com.retrofit.countriesapp.model.Result;
import com.retrofit.countriesapp.model.WholeResponseMainUpperMostInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GetCountryDataServiceInterface {

    @GET("country/get/all")
    Call<WholeResponseMainUpperMostInfo> getAllCountries();

    @GET("country/get/iso2code/{alpha2_code}")
    Call<WholeResponseMainUpperMostInfo> getCountryFromISOCode(@Path("alpha2_code") String alpha);

    @POST("results")
    Call<WholeResponseMainUpperMostInfo> postTheData(@Body Result result);
    //this means send result object as a body parmter to post request and expect a response of type WholeResponseMainUpperMostInfo

}
