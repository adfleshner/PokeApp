package com.flesh.pokeapp.web;

import com.flesh.pokeapp.objects.Pokemon;
import com.flesh.pokeapp.objects.PokemonResult;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonService {

    private PokemonApi mPokemonApi;

    public PokemonService() {
        Retrofit pokemonRetrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mPokemonApi = pokemonRetrofit.create(PokemonApi.class);
    }

    public void getAllFirstGenPokemon(Callback<PokemonResult> callback) {
        mPokemonApi.getAllPokemonTo(151).enqueue(callback);
    }

    public void getPokemonByName(String name, Callback<Pokemon> callback) {
        mPokemonApi.getPokemon(name).enqueue(callback);
    }

}
