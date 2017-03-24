package com.flesh.pokeapp.pokemon.details;

import com.flesh.pokeapp.base.BasePresenter;
import com.flesh.pokeapp.base.BaseView;
import com.flesh.pokeapp.objects.Pokemon;
import com.flesh.pokeapp.web.PokemonService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaronfleshner on 3/24/17.
 */

public class PokemonDetailsPresenter extends BasePresenter<PokemonService,BaseView<Pokemon>> {


    public PokemonDetailsPresenter(PokemonService dataProvider, BaseView<Pokemon> view) {
        super(dataProvider, view);
    }

    public void getPokemon(String pokemonName){
        mView.showLoading();
        mDataProvider.getPokemonByName(pokemonName, new Callback<Pokemon>() {
            @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                mView.hideLoading();
                if(response.code()==200) {
                    mView.onLoaded(response.body());
                }else{
                    mView.onError(null);
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                mView.hideLoading();
                mView.onError(t);
            }
        });
    }
}
