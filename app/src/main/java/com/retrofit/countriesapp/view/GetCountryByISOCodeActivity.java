package com.retrofit.countriesapp.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.retrofit.countriesapp.R;

public class GetCountryByISOCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_by_iso_layout);
        Toast.makeText(GetCountryByISOCodeActivity.this,"Rest everything is almost same as we did in Get allcountries",Toast.LENGTH_SHORT).show();


    }


}
