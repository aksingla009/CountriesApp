package com.retrofit.countriesapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.retrofit.countriesapp.R;
import com.retrofit.countriesapp.model.Result;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>{

    private ArrayList<Result> countriesArrayList;

    public CountryAdapter(ArrayList<Result> countriesArrayList) {
        this.countriesArrayList = countriesArrayList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_country,parent,false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.countryNameTV.setText(countriesArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countriesArrayList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder{
        TextView countryNameTV;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryNameTV = itemView.findViewById(R.id.tv_country_name);
        }
    }
}
