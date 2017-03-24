package com.flesh.pokeapp;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.squareup.picasso.Picasso;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class ImageLoader {

    private RequestManager mGlide;
    private Picasso mPicasso;

    public ImageLoader(Context context) {
        mPicasso = Picasso.with(context.getApplicationContext());
        mGlide = Glide.with(context.getApplicationContext());
    }

    public  void LoadImage(String url , ImageView image){
        mPicasso.load(url).into(image);
    }

    public  void LoadGif(int localRes, ImageView image){
        mGlide.load(localRes).asGif().into(image);
    }
}
