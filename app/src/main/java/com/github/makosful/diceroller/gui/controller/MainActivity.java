package com.github.makosful.diceroller.gui.controller;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.makosful.diceroller.R;
import com.github.makosful.diceroller.be.Die;
import com.github.makosful.diceroller.gui.model.MainModel;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    MainModel model;

    Spinner spinner;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Super Duper Dice Roller");
        model = new MainModel();

        spinner = findViewById(R.id.spinAmount);
        gridView = findViewById(R.id.gridView);
    }

    public void openHistory(View view)
    {
        Intent i = new Intent(this, History.class);
        startActivityForResult(i, 200);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void rollDice(View view)
    {
        String string = spinner.getSelectedItem().toString();
        int amount = Integer.parseInt(string);

        Random rand = new Random();
        Die[] dice = new Die[amount];

        for (int i = 0; i < dice.length; i++)
        {
            int x = rand.nextInt(6) + 1;
            Die die = new Die(x);
            Drawable drawable = getDrawable(
                    getResources().getIdentifier("d" + x, "drawable", getPackageName()));
            die.setDrawable(drawable);
            dice[i] = die;
        }

        StringBuilder sb = new StringBuilder();
        for (Die die: dice) {
            sb.append(die.getValue());
            sb.append(", ");
        }

        gridView.ad
    }
}
