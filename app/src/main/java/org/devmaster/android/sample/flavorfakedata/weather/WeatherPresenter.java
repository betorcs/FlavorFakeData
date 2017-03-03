package org.devmaster.android.sample.flavorfakedata.weather;

import android.support.annotation.NonNull;

import org.devmaster.android.sample.flavorfakedata.client.ApiClient;
import org.devmaster.android.sample.flavorfakedata.model.Resp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherPresenter implements WeatherContract.UserActionListener {

    private final ApiClient client;
    private final WeatherContract.View view;

    public WeatherPresenter(@NonNull ApiClient client, @NonNull WeatherContract.View view) {
        this.client = client;
        this.view = view;
    }

    @Override
    public void searchWeatherForLocation(CharSequence locationName) {
        client.getWeather((String) locationName).enqueue(new Callback<Resp>() {
            @Override
            public void onResponse(Call<Resp> call, Response<Resp> response) {
                if (response.isSuccessful()) {
                    view.setResp(response.body());
                } else {
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<Resp> call, Throwable t) {
                view.showError();
            }
        });
    }
}
