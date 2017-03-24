package com.flesh.pokeapp.base;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public interface BaseView<T> {

    void onLoaded(T data);

    void onError(Throwable error);

    void showLoading();

    void hideLoading();

}
