package com.retrofit.countriesapp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.retrofit.countriesapp.R;
import com.retrofit.countriesapp.databinding.LaucherActivityLayoutBinding;

public class LauncherActivity extends AppCompatActivity {

    private LaucherActivityLayoutBinding laucherActivityLayoutBinding;
    private LauncherActivityClickHandler launcherActivityClickHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laucher_activity_layout);

        laucherActivityLayoutBinding = DataBindingUtil.setContentView(this,R.layout.laucher_activity_layout);

        launcherActivityClickHandler = new LauncherActivityClickHandler(this);
        laucherActivityLayoutBinding.setLauncherActivityCLickHandler(launcherActivityClickHandler);

    }

    public class LauncherActivityClickHandler{
        private Context context;

        public LauncherActivityClickHandler(Context context) {
            this.context = context;
        }

        public void OnGetAllCountriesButtonClicked(View view){
            Intent intent = new Intent(context, GetAllCountriesActivity.class);
            startActivity(intent);
            finish();

        }
        public void OnGetCountryNameByISOCodeButtonClicked(View view){
            Intent intent = new Intent(context, GetCountryByISOCodeActivity.class);
            startActivity(intent);
            finish();

        }
    }

}
