package com.fabianofranca.daggerlab.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

import com.fabianofranca.daggerlab.DaggerLabApplication;
import com.fabianofranca.daggerlab.R;
import com.fabianofranca.daggerlab.di.DaggerAppComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainViewContract {

    @Inject
    MainPresenterContract presenter;

    @BindView(R.id.main_name)
    AppCompatEditText nameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerLabApplication
                .getApp()
                .getAppComponent()
                .getMainComponentBuilder()
                .get()
                .view(this)
                .build()
                .inject(this);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_show_name)
    public void showName(View view) {
        String name =  nameEdit.getText().toString();

        if (!name.equals("")) {
            presenter.setName(name);
            presenter.showName();
        }
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
