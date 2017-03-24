package com.flesh.pokeapp.pokemon.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flesh.pokeapp.R;
import com.flesh.pokeapp.base.BaseFragment;
import com.flesh.pokeapp.base.BaseView;
import com.flesh.pokeapp.objects.PokemonResult;
import com.flesh.pokeapp.pokemon.details.PokemonDetailsActivity;
import com.flesh.pokeapp.views.LoadingView;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonListFragment extends BaseFragment implements BaseView<PokemonResult>, PokemonAdapter.PokemonItemClick {

    public static final String POKEMON = "com.flesh.pokeapp.pokemon.list POKEMON";
    private static final String RESULT = "com.flesh.pokeapp.pokemon.list POKEMON RESULT";
    private RecyclerView rvPokemonList;
    private PokemonResult mResult;
    private PokemonListPresenter mPresenter;
    protected LoadingView lvLoading;
    private OnPokemonSelectedListener mListener;


    public interface OnPokemonSelectedListener {
        void onPokemonSelected(String pokemoname);
    }


    public static PokemonListFragment newInstance() {

        Bundle args = new Bundle();

        PokemonListFragment fragment = new PokemonListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new PokemonListPresenter(pokemon, this);
        if (savedInstanceState != null && savedInstanceState.containsKey(RESULT)) {
            mResult = savedInstanceState.getParcelable(RESULT);
        }
        mListener = (OnPokemonSelectedListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvLoading = (LoadingView) view.findViewById(R.id.lvLoading);
        rvPokemonList = (RecyclerView) view.findViewById(R.id.rvPokemonList);
        rvPokemonList.setLayoutManager(new LinearLayoutManager(getContext()));
        loadPokemon();
    }

    //Load the pokemon
    public void loadPokemon() {
        //if it is null make the web call
        if (mResult == null) {
            mPresenter.getAllGenOnePokemon();
        } else {
            //if its not null just load the data.
            onLoaded(mResult);
        }
    }

    @Override
    public void onPokemonClick(String name) {
        Boolean isTablet = getResources().getBoolean(R.bool.isTablet);
        if (isTablet) {
            //call tablet ui
            if (mListener != null)
                mListener.onPokemonSelected(name);
        } else {
            //call phone ui
            Intent pokemonDetailsIntent = new Intent(getActivity(), PokemonDetailsActivity.class);
            pokemonDetailsIntent.putExtra(POKEMON, name);
            startActivity(pokemonDetailsIntent);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(RESULT, mResult);
    }

    @Override
    public void onLoaded(PokemonResult data) {
        mResult = data;
        //create the adapter
        PokemonAdapter adapter = new PokemonAdapter(getContext(), data);
        //set the onclickListener
        adapter.setOnPokemonClickListener(this);
        //set the adapter
        rvPokemonList.setAdapter(adapter);
    }

    @Override
    public void onError(Throwable error) {
        showError();
    }

    @Override
    public void showLoading() {
        lvLoading.show();

    }

    @Override
    public void hideLoading() {
        lvLoading.hide();
    }


}
