package com.melody.creditkeeper.home.model.impl;

import com.melody.creditkeeper.home.model.MainModel;
import com.melody.creditkeeper.home.presenter.MainPresenter;

public class MainModelImpl implements MainModel {

    private MainPresenter presenter;

    public MainModelImpl(MainPresenter presenter) {
        this.presenter = presenter;
    }
}
