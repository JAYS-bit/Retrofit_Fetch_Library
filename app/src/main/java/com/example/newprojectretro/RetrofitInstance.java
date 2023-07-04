package com.example.newprojectretro;

import static com.example.newprojectretro.MainActivity.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

   public static RetrofitInstance instance;
    public static ApiInterface apiInterface;

    public RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();


      apiInterface=   retrofit.create(ApiInterface.class);
    }

    public static  RetrofitInstance getInstance(){

        if(instance==null){

            instance = new RetrofitInstance();
        }

        return instance;


    }
}
