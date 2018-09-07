package com.melody.creditkeeper.home.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.melody.base.BaseActivity;
import com.melody.creditkeeper.R;
import com.melody.creditkeeper.home.model.MainModel;
import com.melody.creditkeeper.home.presenter.MainPresenter;
import com.melody.creditkeeper.home.presenter.impl.MainPresenterImpl;
import com.melody.creditkeeper.home.view.MainView;

public class MainActivity
        extends BaseActivity<MainModel, MainView, MainPresenter>
        implements MainView {


    @Override
    public MainPresenter createPresenter() {
        return new MainPresenterImpl(this);
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
    }


}