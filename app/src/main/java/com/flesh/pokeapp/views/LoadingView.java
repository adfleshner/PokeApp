package com.flesh.pokeapp.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.flesh.pokeapp.ImageLoader;
import com.flesh.pokeapp.R;

/**
 * Created by aaronfleshner on 3/23/17.
 */

public class LoadingView extends RelativeLayout {

    private ImageView image;
    private ImageLoader imageLoader;
    public LoadingView(Context context) {
        super(context);
        init(null, 0, 0);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0, 0);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs, defStyleAttr, defStyleRes);
    }

    public void init(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        inflate(getContext(), R.layout.loading_view, this);
        imageLoader = new ImageLoader(getContext());
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.LoadingView, defStyleAttr, defStyleRes);
        int resImage = a.getResourceId(R.styleable.LoadingView_lv_image, 0);
        image = (ImageView) findViewById(R.id.ivLoading);
        imageLoader.LoadGif(resImage,image);
    }

    public void show(){
        setVisibility(VISIBLE);
    }

    public void hide(){
        setVisibility(GONE);
    }

}
