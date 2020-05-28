package com.retrofit.countriesapp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.retrofit.countriesapp.R;
import com.retrofit.countriesapp.adapter.CountryAdapter;
import com.retrofit.countriesapp.model.Result;
import com.retrofit.countriesapp.model.WholeResponseMainUpperMostInfo;
import com.retrofit.countriesapp.service.GetCountryDataServiceInterface;
import com.retrofit.countriesapp.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAllCountriesActivity extends AppCompatActivity {

    private ArrayList<Result> countriesData;
    private CountryAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCountries();

    }

    private ArrayList<Result> getCountries() {

        GetCountryDataServiceInterface instance = RetrofitInstance.getServiceInstance();
        Call<WholeResponseMainUpperMostInfo> call = instance.getAllCountries();

        call.enqueue(new Callback<WholeResponseMainUpperMostInfo>() {
            @Override
            public void onResponse(Call<WholeResponseMainUpperMostInfo> call, Response<WholeResponseMainUpperMostInfo> response) {

                WholeResponseMainUpperMostInfo info = response.body();
                if(info != null && info.getRestResponse() != null){
                    countriesData = (ArrayList<Result>) info.getRestResponse().getResult();

                   /* for (Result r : countriesData){
                        Log.e("Testing countries list", "+++++++++++++"+r.getName());
                    }*/

                    viewData();

                }

            }

            @Override
            public void onFailure(Call<WholeResponseMainUpperMostInfo> call, Throwable t) {

            }
        });


        return countriesData;
    }

    private void viewData() {
        recyclerView = findViewById(R.id.countriesRV);
        adapter = new CountryAdapter(countriesData);

        RecyclerView.LayoutManager linearLayoutManagaer = new LinearLayoutManager(GetAllCountriesActivity.this);
        recyclerView.setLayoutManager(linearLayoutManagaer);

        recyclerView.setAdapter(adapter);

    }
}
