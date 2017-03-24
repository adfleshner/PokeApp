package com.flesh.pokeapp.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokemonSprite implements Parcelable {

    private String front_default;


    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.front_default);
    }

    public PokemonSprite() {
    }

    protected PokemonSprite(Parcel in) {
        this.front_default = in.readString();
    }

    public static final Parcelable.Creator<PokemonSprite> CREATOR = new Parcelable.Creator<PokemonSprite>() {
        @Override
        public PokemonSprite createFromParcel(Parcel source) {
            return new PokemonSprite(source);
        }

        @Override
        public PokemonSprite[] newArray(int size) {
            return new PokemonSprite[size];
        }
    };
}
