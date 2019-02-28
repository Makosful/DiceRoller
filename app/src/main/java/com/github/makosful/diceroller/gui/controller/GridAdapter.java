package com.github.makosful.diceroller.gui.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
    Context context;
    int[] diceImages;

    GridAdapter(Context cxt, int[] images) {
        this.context = cxt;
        this.diceImages = images;
    }
    @Override
    public int getCount() {
        return diceImages.length;
    }

    @Override
    public Object getItem(int i) {
        return diceImages[i];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ImageView imgView = new ImageView(context);

        imgView.setImageResource(diceImages[i]);
        imgView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imgView;
    }
}
