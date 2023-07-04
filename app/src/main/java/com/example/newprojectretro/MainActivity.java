package com.example.newprojectretro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    public static String BASE_URL ="https://jsonplaceholder.typicode.com";
    List<UserModel> allUserList;
    RecyclerView recyclerView;
    MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));





        RetrofitInstance.getInstance().apiInterface.getUsers().enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                allUserList =response.body();
                adapter= new MyCustomAdapter(allUserList,MainActivity.this);
                recyclerView.setAdapter(adapter);


              /*  for(int i=0;i<allUserList.size();i++)
                        Log.e("api","OnResponse : Get the titile : \t "+allUserList.get(i).getTitle()); */
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

                Log.e("api","OnFailure" + t.getLocalizedMessage());
            }
        });


    }
}