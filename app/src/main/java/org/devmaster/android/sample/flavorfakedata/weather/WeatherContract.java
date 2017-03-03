package org.devmaster.android.sample.flavorfakedata.weather;

import org.devmaster.android.sample.flavorfakedata.model.Resp;

public interface WeatherContract {

    interface View {

        void showProgress(boolean visible);

        void setResp(Resp resp);

        void showError();

    }

    interface UserActionListener {

        void searchWeatherForLocation(CharSequence locationName);

    }

}
