package com.flesh.pokeapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

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

    public void showError(){
        new AlertDialog.Builder(getContext()).setTitle("Error").setMessage("Pokemon Falied to Load").show();
    }


}
