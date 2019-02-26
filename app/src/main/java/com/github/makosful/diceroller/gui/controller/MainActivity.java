package com.github.makosful.diceroller.gui.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.github.makosful.diceroller.R;
import com.github.makosful.diceroller.gui.model.BE_Die;
import com.github.makosful.diceroller.gui.model.Dice;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    GridView gridView;
    int[] images = {
            R.drawable.d1,
            R.drawable.d2,
            R.drawable.d3,
            R.drawable.d4,
            R.drawable.d5,
            R.drawable.d6};

    Dice m_dice;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Super Duper Dice Roller");

        m_dice = new Dice();

        // ArrayList<BE_Die> dice = m_dice.getAllDice();

        gridView = findViewById(R.id.gridView);
        Button btnRoll = findViewById(R.id.btnRoll);
        Button btnHistory = findViewById(R.id.btnHistory);

        GridAdapter adapter = new GridAdapter(this, images);

        //ListAdapter adapter = new ArrayAdapter<>()

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You've clicked the image: " + position, Toast.LENGTH_LONG).show();
            }
        });

        //btnRoll.setOnClickListener();

        //btnHistory.setOnClickListener();

    }
}
