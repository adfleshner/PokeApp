package com.flesh.pokeapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonListFragment extends Fragment {


    public static PokemonListFragment newInstance() {

        Bundle args = new Bundle();

        PokemonListFragment fragment = new PokemonListFragment();
        fragment.setArguments(args);
        return fragment;
    }



}
