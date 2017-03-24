package com.flesh.pokeapp.pokemon.list;

import com.flesh.pokeapp.base.BasePresenter;
import com.flesh.pokeapp.base.BaseView;
import com.flesh.pokeapp.objects.PokemonResult;
import com.flesh.pokeapp.web.PokemonService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonListPresenter extends BasePresenter<PokemonService, BaseView<PokemonResult>> {

    public PokemonListPresenter(PokemonService webService, BaseView<PokemonResult> view) {
        super(webService, view);
    }

    public void getAllGenOnePokemon() {
        mView.showLoading();
        mDataProvider.getAllFirstGenPokemon(new Callback<PokemonResult>() {
            @Override
            public void onResponse(Call<PokemonResult> call, Response<PokemonResult> response) {
                try {
                    mView.hideLoading();
                    if (response.code() == 200) {
                        mView.onLoaded(response.body());
                    } else {
                        mView.onError(null);
                    }
                } catch (NullPointerException e) {
                    e.fillInStackTrace();
                }
            }

            @Override
            public void onFailure(Call<PokemonResult> call, Throwable t) {
                mView.onError(t);
            }
        });
    }
}
