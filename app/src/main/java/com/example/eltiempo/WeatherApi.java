package com.example.eltiempo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {
    @GET("location/766273/")
    Call<Weather> loadWeather();


}
