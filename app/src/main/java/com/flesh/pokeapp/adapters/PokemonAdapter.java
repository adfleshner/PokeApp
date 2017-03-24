package com.flesh.pokeapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flesh.pokeapp.R;
import com.flesh.pokeapp.objects.PokeApiNamedAPIResource;
import com.flesh.pokeapp.objects.PokemonResult;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private PokemonResult result;
    private PokemonItemClick listener;

    public interface PokemonItemClick{
        void onPokemonClick(String name);
    }

    public void setOnPokemonClickListener(PokemonItemClick listener){
        this.listener = listener;
    }

    public PokemonAdapter(PokemonResult result) {
        this.result = result;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell_pokemon,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.BindView(getItem(position));
    }

    private PokeApiNamedAPIResource getItem(int position) {
        return result.getResults().get(position);
    }

    @Override
    public int getItemCount() {
        return result.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvPokemonName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null){
                        listener.onPokemonClick(getItem(getAdapterPosition()).getName());
                    }
                }
            });
        }

        public void BindView(PokeApiNamedAPIResource pokemon){
            title.setText(capitalizeFirstLetter(pokemon.getName()));
        }

        public String capitalizeFirstLetter(String input){
            return input.substring(0, 1).toUpperCase() + input.substring(1);
        }
    }
}
