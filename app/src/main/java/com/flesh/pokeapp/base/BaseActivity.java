package com.flesh.pokeapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.flesh.pokeapp.PokeAppApplication;
import com.flesh.pokeapp.web.PokemonService;

import javax.inject.Inject;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Inject public PokemonService pokemon;
    protected ActionBar mBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((PokeAppApplication)getApplication()).objectGraph.inject(this);
        mBar = getSupportActionBar();
    }
}
