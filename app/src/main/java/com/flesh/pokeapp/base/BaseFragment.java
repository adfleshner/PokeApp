package com.flesh.pokeapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

import com.flesh.pokeapp.PokeAppApplication;
import com.flesh.pokeapp.web.PokemonService;

import javax.inject.Inject;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class BaseFragment extends Fragment {

    @Inject public PokemonService pokemon;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((PokeAppApplication)getActivity().getApplication()).objectGraph.inject(this);
    }

    public void showError(){
        new AlertDialog.Builder(getContext()).setTitle("Error").setMessage("Pokemon Falied to Load").show();
    }


}
