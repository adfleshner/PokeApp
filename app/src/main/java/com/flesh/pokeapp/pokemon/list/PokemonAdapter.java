package com.flesh.pokeapp.pokemon.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.flesh.pokeapp.ImageLoader;
import com.flesh.pokeapp.R;
import com.flesh.pokeapp.objects.PokeApiNamedAPIResource;
import com.flesh.pokeapp.objects.PokemonResult;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private PokemonResult result;
    private PokemonItemClick listener;
    private ImageLoader imageLoader;

    public interface PokemonItemClick {
        void onPokemonClick(String name);
    }

    public void setOnPokemonClickListener(PokemonItemClick listener) {
        this.listener = listener;
    }

    public PokemonAdapter(Context context, PokemonResult result) {
        this.result = result;
        imageLoader = new ImageLoader(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell_pokemon, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.BindView(position, getItem(position));
    }

    private PokeApiNamedAPIResource getItem(int position) {
        return result.getResults().get(position);
    }

    @Override
    public int getItemCount() {
        return result.getResults().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvPokemonName);
            image = (ImageView) itemView.findViewById(R.id.ivPokemonImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onPokemonClick(getItem(getAdapterPosition()).getName());
                    }
                }
            });
        }

        public void BindView(int position, PokeApiNamedAPIResource pokemon) {
            title.setText(formatPokemonName(position,pokemon.getName()));
            imageLoader.LoadImage(getPokemonImage(pokemon.getName()), image);
        }

        private String formatPokemonName(int position,String input) {
            String temp = input.substring(0, 1).toUpperCase() + input.substring(1);
            if (temp.substring(temp.length() - 2, temp.length()).equals("-f")) {
                temp = temp.substring(0, temp.length() - 2).concat(" ♀");
            } else if (temp.substring(temp.length() - 2, temp.length()).equals("-m")) {
                temp = temp.substring(0, temp.length() - 2).concat(" ♂");
            }
            temp = (position + 1) + ". " + temp;
            return temp;
    }

    private String getPokemonImage(String name) {
        return "https://img.pokemondb.net/artwork/" + name + ".jpg";
    }
}
}
