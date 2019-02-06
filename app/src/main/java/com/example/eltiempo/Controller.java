package com.example.eltiempo;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<Weather> {

    ServerResponse handler;

    public Controller(ServerResponse handler){
        this.handler = handler;
    }

    static final String BASE_URL = "https://www.metaweather.com/api/";

    public void start(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        WeatherApi api = retrofit.create(WeatherApi.class);

        Call<Weather> call = api.loadWeather();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Weather> call, Response<Weather> response) {
        if (response.isSuccessful()){
            Weather weather = response.body();
            handler.onResponse(weather);
            Log.d("CONTROLLER",weather.getTitle());

        }else{
            Log.d("CONTROLLER",response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<Weather> call, Throwable t) {
        t.printStackTrace();
    }

    interface ServerResponse{
        public void onResponse(Weather weather);

    }
}
