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

import com.github.makosful.diceroller.R;
import com.github.makosful.diceroller.be.Die;
import com.github.makosful.diceroller.gui.model.DiceGridAdapter;
import com.github.makosful.diceroller.gui.model.MainModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    MainModel model;
    Spinner spinner;
    GridView gridView;
    DiceGridAdapter dga;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Super Duper Dice Roller");
        model = new MainModel();

        spinner = findViewById(R.id.spinAmount);
        gridView = findViewById(R.id.gridView);
        dga = new DiceGridAdapter(this, R.layout.gridview_dice_layout, new ArrayList<Die>());
        gridView.setAdapter(dga);
    }

    public void openHistory(View view)
    {
        Intent i = new Intent(this, History.class);
        startActivityForResult(i, 200);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void rollDice(View view)
    {
        dga.clear();
        String string = spinner.getSelectedItem().toString();
        int amount = Integer.parseInt(string);
        Random rand = new Random();

        for (int i = 0; i < amount; i++)
        {
            int x = rand.nextInt(6) + 1;
            Die die = new Die(x);
            Drawable drawable = getDrawable(
                    getResources().getIdentifier("d" + x, "drawable", getPackageName()));
            die.setDrawable(drawable);
            dga.add(die);
        }

        //DiceGridAdapter gridAdapter = new DiceGridAdapter(this, R.layout.gridview_dice_layout, dice);
        //gridView.setAdapter(gridAdapter);

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss | ");
        String date = df.format(Calendar.getInstance().getTime());
        sb.append(date);
        sb.append(amount).append(" dice were thrown, landing on [");
        for (int i = 0; i < dga.getCount(); i++) {
            Die die = dga.getItem(i);
            sum += die.getValue();
            sb.append(die.getValue()).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append("] resulting in ").append(sum);

        model.addResult(sb.toString());
    }
}
