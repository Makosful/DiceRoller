package com.github.makosful.diceroller.gui.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.github.makosful.diceroller.gui.model.BE_Die;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    Context context;
    BE_Die[] dice;

    GridAdapter(Context cxt, ArrayList<BE_Die> dice) {
        this.context = cxt;
        dice = dice;
    }
    @Override
    public int getCount() {
        return dice.length;
    }

    @Override
    public BE_Die getItem(int i) {
        return dice[i];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ImageView imgView = new ImageView(context);
        imgView.setImageResource(dice[i].getImage());
        imgView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imgView;
    }
}
