package com.flesh.pokeapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.flesh.pokeapp.R;
import com.flesh.pokeapp.adapters.PokemonAdapter;
import com.flesh.pokeapp.objects.PokemonResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonListFragment extends BaseFragment {

    private RecyclerView rvPokemonList;
    private PokemonResult result;



    public static PokemonListFragment newInstance() {

        Bundle args = new Bundle();

        PokemonListFragment fragment = new PokemonListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemon_list,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvPokemonList = (RecyclerView) view.findViewById(R.id.rvPokemonList);
        rvPokemonList.setLayoutManager(new LinearLayoutManager(getContext()));
//        rvPokemonList.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        pokemon.getAllFirstGenPokemon(new Callback<PokemonResult>() {
            @Override
            public void onResponse(Call<PokemonResult> call, Response<PokemonResult> response) {
                if(response.code()==200) {
                    PokemonAdapter adapter = new PokemonAdapter(response.body());
                    adapter.setOnPokemonClickListener(new PokemonAdapter.PokemonItemClick() {
                        @Override
                        public void onPokemonClick(String name) {
                            showError(name);
                        }
                    });
                    rvPokemonList.setAdapter(adapter);
                    showError(response.body().getResults().size()+"");
                }else{
                    showError("Error Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<PokemonResult> call, Throwable t) {
                showError("Server Error");
            }
        });
    }

    private void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

}
