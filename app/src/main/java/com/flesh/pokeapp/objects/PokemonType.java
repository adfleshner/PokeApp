package com.flesh.pokeapp.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonType implements Parcelable {
    private int slot;
    private PokeApiNamedAPIResource type;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public PokeApiNamedAPIResource getType() {
        return type;
    }

    public void setType(PokeApiNamedAPIResource type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.slot);
        dest.writeParcelable(this.type, flags);
    }

    public PokemonType() {
    }

    protected PokemonType(Parcel in) {
        this.slot = in.readInt();
        this.type = in.readParcelable(PokeApiNamedAPIResource.class.getClassLoader());
    }

    public static final Parcelable.Creator<PokemonType> CREATOR = new Parcelable.Creator<PokemonType>() {
        @Override
        public PokemonType createFromParcel(Parcel source) {
            return new PokemonType(source);
        }

        @Override
        public PokemonType[] newArray(int size) {
            return new PokemonType[size];
        }
    };
}
