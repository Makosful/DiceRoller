package com.github.makosful.diceroller.gui.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Spinner;
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
    Spinner spinAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Super Duper Dice Roller");

        m_dice = new Dice();

        ArrayList<BE_Die> dice = m_dice.getAllDice();
        Button btnRoll = findViewById(R.id.btnRoll);
        Button btnHistory = findViewById(R.id.btnHistory);

        spinAmount = findViewById(R.id.spinAmount);
        Integer[] numbers = new Integer[]{1,2,3,4,5,6};
        ArrayAdapter<Integer> numberAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, numbers);
        spinAmount.setAdapter(numberAdapter);

        spinAmount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            int amt = position + 1;
            Toast.makeText(getApplicationContext(), "You selected: " + amt, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
            return;
        }

    });

        gridView = findViewById(R.id.gridView);
        GridAdapter gridAdapter = new GridAdapter(this, images);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int amt = position + 1;
                Toast.makeText(getApplicationContext(), "You clicked the image: " + amt, Toast.LENGTH_SHORT).show();
            }
        });


        //btnRoll.setOnClickListener();

        //btnHistory.setOnClickListener();

    }

    public void openHistory(View view)
    {
        Intent i = new Intent(this, History.class);
        startActivityForResult(i, 200);
    }
}
