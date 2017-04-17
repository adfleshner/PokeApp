package com.flesh.pokeapp;

import android.app.Application;

import dagger.ObjectGraph;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokeAppApplication extends Application {

    public ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(new NetworkModule());
    }

}
