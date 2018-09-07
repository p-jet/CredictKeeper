package com.melody.creditkeeper.home.presenter.impl;

import com.melody.creditkeeper.home.model.MainModel;
import com.melody.creditkeeper.home.model.impl.MainModelImpl;
import com.melody.creditkeeper.home.presenter.MainPresenter;
import com.melody.creditkeeper.home.view.MainView;

public class MainPresenterImpl extends MainPresenter {
    public MainPresenterImpl(MainView view) {
        super(view);
    }

    @Override
    public MainModel createModel() {
        return new MainModelImpl(this);
    }
}
