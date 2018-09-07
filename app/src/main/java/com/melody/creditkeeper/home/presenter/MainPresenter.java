package com.melody.creditkeeper.home.presenter;

import com.melody.base.BasePresenter;
import com.melody.creditkeeper.home.model.MainModel;
import com.melody.creditkeeper.home.view.MainView;

public abstract class MainPresenter extends BasePresenter<MainModel, MainView> {

    public MainPresenter(MainView view) {
        super(view);
    }



}
