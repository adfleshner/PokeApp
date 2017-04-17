package com.flesh.pokeapp.base;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class BasePresenter<D,T> {

    protected D mDataProvider;
    protected T mView;

    public BasePresenter(D webService, T view) {
        this.mView = view;
        this.mDataProvider = webService;
    }

}