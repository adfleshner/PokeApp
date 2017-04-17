package com.flesh.pokeapp;

import com.flesh.pokeapp.pokemon.details.PokemonDetailsActivity;
import com.flesh.pokeapp.pokemon.details.PokemonDetailsFragment;
import com.flesh.pokeapp.pokemon.list.PokemonListFragment;
import com.flesh.pokeapp.web.PokemonApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aaronfleshner on 4/17/17.
 */
@Singleton
@Module (injects = {PokemonDetailsFragment.class, PokemonDetailsActivity.class, MainActivity.class,PokemonListFragment.class})
public class NetworkModule {

    @Provides
    PokemonApi providesPokeApi() {
        Retrofit pokemonRetrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return pokemonRetrofit.create(PokemonApi.class);
    }


}
