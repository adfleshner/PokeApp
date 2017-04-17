package com.flesh.pokeapp.web;

import com.flesh.pokeapp.objects.Pokemon;
import com.flesh.pokeapp.objects.PokemonResult;

import javax.inject.Inject;

import retrofit2.Callback;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonService {

    private PokemonApi mPokemonApi;

    @Inject
    public PokemonService(PokemonApi pokemonApi) {
       mPokemonApi = pokemonApi;
    }

    public void getAllFirstGenPokemon(Callback<PokemonResult> callback) {
        mPokemonApi.getAllPokemonTo(151).enqueue(callback);
    }

    public void getPokemonByName(String name, Callback<Pokemon> callback) {
        mPokemonApi.getPokemon(name).enqueue(callback);
    }

}
