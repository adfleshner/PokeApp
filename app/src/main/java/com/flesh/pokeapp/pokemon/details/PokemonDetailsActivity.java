package com.flesh.pokeapp.pokemon.details;

import android.os.Bundle;
import android.view.MenuItem;

import com.flesh.pokeapp.R;
import com.flesh.pokeapp.base.BaseActivity;
import com.flesh.pokeapp.pokemon.list.PokemonListFragment;

public class PokemonDetailsActivity extends BaseActivity {

    String name;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details_actvity);
        if (getIntent() != null && getIntent().hasExtra(PokemonListFragment.POKEMON)) {
            name = getIntent().getStringExtra(PokemonListFragment.POKEMON);
        }
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_details, PokemonDetailsFragment.newInstance(name))
                    .commit();

        }
        if (mBar != null) {
            mBar.setDisplayHomeAsUpEnabled(true);
            mBar.setDefaultDisplayHomeAsUpEnabled(true);
            mBar.setTitle(formatPokemonName(name));
        }
    }

    private String formatPokemonName(String input) {
        String temp = input.substring(0, 1).toUpperCase() + input.substring(1);
        if (temp.substring(temp.length() - 2, temp.length()).equals("-f")) {
            temp = temp.substring(0, temp.length() - 2).concat(" ♀");
        } else if (temp.substring(temp.length() - 2, temp.length()).equals("-m")) {
            temp = temp.substring(0, temp.length() - 2).concat(" ♂");
        }
        return temp;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
