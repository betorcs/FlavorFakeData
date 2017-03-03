package org.devmaster.android.sample.flavorfakedata.weather;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.devmaster.android.sample.flavorfakedata.Inject;
import org.devmaster.android.sample.flavorfakedata.R;
import org.devmaster.android.sample.flavorfakedata.databinding.ActivityMainBinding;
import org.devmaster.android.sample.flavorfakedata.model.Resp;

public class WeatherActivity extends AppCompatActivity implements WeatherContract.View {

    private ActivityMainBinding mBinding;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WeatherPresenter presenter = new WeatherPresenter(Inject.getClient(), this);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setUserAction(presenter);
    }

    @Override
    public void showProgress(boolean visible) {
        if (visible) {
            loading = ProgressDialog.show(this, null, "Aguarde...", true, false);
        } else if (loading != null) {
            loading.dismiss();
        }
    }

    @Override
    public void setResp(Resp resp) {
        mBinding.setResp(resp);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Something was wrong", Toast.LENGTH_LONG).show();
    }
}
