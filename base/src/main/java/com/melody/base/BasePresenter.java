package com.melody.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends BaseModel, T extends BaseView> {

    protected WeakReference<T> mView;
    protected WeakReference<V> mModel;

    public BasePresenter(T view) {
        attach(createModel(), view);
    }

    public abstract V createModel();

    //绑定 Model  View
    private void attach(V model, T view) {
        mModel = new WeakReference<>(model);
        mView = new WeakReference<>(view);
    }

    //清空 Model  View
    void detach() {
        try {
            mView.clear();
            mModel.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
