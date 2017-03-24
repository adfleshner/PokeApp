package com.flesh.pokeapp.pokemon.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flesh.pokeapp.ImageLoader;
import com.flesh.pokeapp.R;
import com.flesh.pokeapp.base.BaseFragment;
import com.flesh.pokeapp.base.BaseView;
import com.flesh.pokeapp.objects.Pokemon;
import com.flesh.pokeapp.objects.PokemonType;
import com.flesh.pokeapp.views.LoadingView;

import java.util.List;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonDetailsFragment extends BaseFragment implements BaseView<Pokemon>{


    private static final String POKEMON_NAME = "com.flesh.pokeapp.pokemon.details POKEMON NAME";
    private static final String POKEMON = "com.flesh.pokeapp.pokemon.details POKEMON";
    private String mPokemonName;
    private Pokemon mPokemon;
    private PokemonDetailsPresenter mPresenter;
    private ImageLoader mImageLoader;

    private LoadingView lvLoading;
    private ImageView ivPokemonImage;
    private TextView tvPokemonName;
    private TextView tvPokemonTypes;
    private TextView tvPokemonWeight;
    private TextView tvPokemonHeight;


    public static PokemonDetailsFragment newInstance(String pokemonName) {
        Bundle args = new Bundle();
        args.putString(POKEMON_NAME,pokemonName);
        PokemonDetailsFragment fragment = new PokemonDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null && savedInstanceState.containsKey(POKEMON)){
            mPokemon = savedInstanceState.getParcelable(POKEMON);
        }else if(getArguments()!=null && getArguments().containsKey(POKEMON_NAME)){
            mPokemonName = getArguments().getString(POKEMON_NAME);
        }

        //Create the presenter
        mPresenter = new PokemonDetailsPresenter(pokemon,this);
        mImageLoader = new ImageLoader(getContext());
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemon_details,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //init View
        lvLoading = (LoadingView) view.findViewById(R.id.lvLoading);
        ivPokemonImage = (ImageView) view.findViewById(R.id.ivPokemonSprite);
        tvPokemonName = (TextView) view.findViewById(R.id.tvPokemonName);
        tvPokemonTypes = (TextView) view.findViewById(R.id.tvPokemonTypes);
        tvPokemonHeight = (TextView) view.findViewById(R.id.tvPokemonHeight);
        tvPokemonWeight = (TextView) view.findViewById(R.id.tvPokemonWeight);
        //load data
        loadData();
    }

    private void loadData(){
        if(mPokemon != null){
            onLoaded(mPokemon);
        }else if(mPokemonName!=null){
            mPresenter.getPokemon(mPokemonName);
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(POKEMON,mPokemon);
    }

    @Override
    public void onLoaded(Pokemon pokemon) {
        mPokemon = pokemon;
        mImageLoader.LoadImage(pokemon.getSprites().getFront_default(),ivPokemonImage);
        tvPokemonName.setText(getString(R.string.pokemon_name,formatPokemonName(pokemon.getName())));
        tvPokemonHeight.setText(getString(R.string.pokemon_Height,pokemon.getHeight()));
        tvPokemonWeight.setText(getString(R.string.pokemon_Weight,pokemon.getWeight()));
        tvPokemonTypes.setText(getString(R.string.pokemon_type,createStringFromTypes(pokemon.getTypes())));
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

    private String createStringFromTypes(List<PokemonType> types) {
        String temp ="";
        for (PokemonType type :
                types) {
            temp = temp.concat(type.getType().getName()+" ,");
        }
        return temp.substring(0,temp.length()-2);
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
