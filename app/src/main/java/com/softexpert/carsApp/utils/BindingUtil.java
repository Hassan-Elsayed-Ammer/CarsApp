package com.softexpert.carsApp.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.softexpert.carsApp.R;
import com.squareup.picasso.Picasso;

import static com.softexpert.carsApp.BaseActivity.screenWidth;


public class BindingUtil {
    @BindingAdapter("loadImage")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Picasso
                .with(imageView.getContext())
                .load(imageUrl)
                .resize(screenWidth, screenWidth * 9 / 16)
                .placeholder(R.drawable.place_holder)
                .into(imageView);
    }
}
