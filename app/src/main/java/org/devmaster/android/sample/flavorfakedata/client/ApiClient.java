package org.devmaster.android.sample.flavorfakedata.client;

import org.devmaster.android.sample.flavorfakedata.model.Resp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("weather?appid=9abfdc7ee20f783f4d75327563b7979a")
    Call<Resp> getWeather(@Query(value = "q", encoded = true) String location);

}
