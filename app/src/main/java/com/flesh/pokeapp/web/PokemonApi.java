package com.flesh.pokeapp.web;

import com.flesh.pokeapp.objects.Pokemon;
import com.flesh.pokeapp.objects.PokemonResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public interface PokemonApi {

    @GET("/api/v2/pokemon")
    Call<PokemonResult> getAllPokemonTo(@Query("limit") int limit);


    @GET("/api/v2/pokemon/{name}")
    Call<Pokemon> getPokemon(@Path("name") String name);

    @GET("/api/v2/pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") int pokemonNumber);

}
