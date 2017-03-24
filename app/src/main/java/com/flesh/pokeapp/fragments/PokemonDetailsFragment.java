package com.flesh.pokeapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonDetailsFragment extends Fragment {


    public static PokemonDetailsFragment newInstance() {

        Bundle args = new Bundle();

        PokemonDetailsFragment fragment = new PokemonDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
