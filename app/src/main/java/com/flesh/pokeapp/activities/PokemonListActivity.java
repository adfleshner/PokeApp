package com.flesh.pokeapp.activities;

import android.os.Bundle;

import com.flesh.pokeapp.R;
import com.flesh.pokeapp.fragments.PokemonListFragment;

public class PokemonListActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);
        if(savedInstanceState==null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, PokemonListFragment.newInstance())
                    .commit();
        }
    }
}
