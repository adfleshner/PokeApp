package com.flesh.pokeapp.objects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class PokeApiNamedAPIResource implements Parcelable {

    private String url;
    private String name;

    public PokeApiNamedAPIResource() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        dest.writeString(this.url);
        dest.writeString(this.name);
    }

    protected PokeApiNamedAPIResource(Parcel in) {
        this.url = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<PokeApiNamedAPIResource> CREATOR = new Parcelable.Creator<PokeApiNamedAPIResource>() {
        @Override
        public PokeApiNamedAPIResource createFromParcel(Parcel source) {
            return new PokeApiNamedAPIResource(source);
        }

        @Override
        public PokeApiNamedAPIResource[] newArray(int size) {
            return new PokeApiNamedAPIResource[size];
        }
    };
}
