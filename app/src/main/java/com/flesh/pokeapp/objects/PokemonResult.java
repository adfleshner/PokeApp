package com.flesh.pokeapp.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonResult implements Parcelable {

    private int count;
    private String previous;
    private List<PokeApiNamedAPIResource> results;
    private String next;

    public PokemonResult() {

    }

    public List<PokeApiNamedAPIResource> getResults() {
        return results;
    }

    public void setResults(List<PokeApiNamedAPIResource> results) {
        this.results = results;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.count);
        dest.writeString(this.previous);
        dest.writeList(this.results);
        dest.writeString(this.next);
    }

    protected PokemonResult(Parcel in) {
        this.count = in.readInt();
        this.previous = in.readString();
        this.results = new ArrayList<PokeApiNamedAPIResource>();
        in.readList(this.results, PokeApiNamedAPIResource.class.getClassLoader());
        this.next = in.readString();
    }

    public static final Parcelable.Creator<PokemonResult> CREATOR = new Parcelable.Creator<PokemonResult>() {
        @Override
        public PokemonResult createFromParcel(Parcel source) {
            return new PokemonResult(source);
        }

        @Override
        public PokemonResult[] newArray(int size) {
            return new PokemonResult[size];
        }
    };
}
