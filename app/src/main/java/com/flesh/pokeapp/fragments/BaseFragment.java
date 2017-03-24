package com.flesh.pokeapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.flesh.pokeapp.web.PokemonService;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class BaseFragment extends Fragment {

    protected PokemonService pokemon;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pokemon = new PokemonService();
    }


}
