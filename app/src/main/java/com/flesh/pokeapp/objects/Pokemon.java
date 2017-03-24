package com.flesh.pokeapp.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class Pokemon implements Parcelable {

    private String name;
    private String weight;
    private String height;
    private List<PokemonType> types;
    private PokemonSprite sprites;

    public double getWeight() {
        double temp = Double.parseDouble(weight);
        return temp/10;
    }


    public double getHeight() {
        double temp = Double.parseDouble(height);
        return temp/10;
    }


    public List<PokemonType> getTypes() {
        return types;
    }


    public PokemonSprite getSprites() {
        return sprites;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.weight);
        dest.writeString(this.height);
        dest.writeList(this.types);
        dest.writeParcelable(this.sprites, flags);
    }

    public Pokemon() {
    }

    protected Pokemon(Parcel in) {
        this.name = in.readString();
        this.weight = in.readString();
        this.height = in.readString();
        this.types = new ArrayList<PokemonType>();
        in.readList(this.types, PokemonType.class.getClassLoader());
        this.sprites = in.readParcelable(PokemonSprite.class.getClassLoader());
    }

    public static final Creator<Pokemon> CREATOR = new Creator<Pokemon>() {
        @Override
        public Pokemon createFromParcel(Parcel source) {
            return new Pokemon(source);
        }

        @Override
        public Pokemon[] newArray(int size) {
            return new Pokemon[size];
        }
    };
}
