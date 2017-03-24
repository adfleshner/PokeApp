package com.flesh.pokeapp;

import android.os.Bundle;

import com.flesh.pokeapp.base.BaseActivity;
import com.flesh.pokeapp.pokemon.details.NoPokemonFragment;
import com.flesh.pokeapp.pokemon.details.PokemonDetailsFragment;
import com.flesh.pokeapp.pokemon.list.PokemonListFragment;

public class MainActivity extends BaseActivity implements PokemonListFragment.OnPokemonSelectedListener{


    private static final String BACK_STACK = "back stack";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isTablet = getResources().getBoolean(R.bool.isTablet);
        if(isTablet){
            mBar.setTitle(R.string.app_name);
            if (savedInstanceState == null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_list, PokemonListFragment.newInstance())
                        .commit();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_details, new NoPokemonFragment())
                        .commit();
            }
        }else {
            mBar.setTitle(R.string.pokemon_list);
            if (savedInstanceState == null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, PokemonListFragment.newInstance())
                        .commit();
            }
        }
    }

    @Override
    public void onPokemonSelected(String pokemoname) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_details, PokemonDetailsFragment.newInstance(pokemoname))
                .addToBackStack(BACK_STACK)
                .commit();
    }
}
