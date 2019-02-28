package com.github.makosful.diceroller.gui.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.makosful.diceroller.R;
import com.github.makosful.diceroller.gui.model.BE_Die;
import com.github.makosful.diceroller.gui.model.Dice;

import java.util.ArrayList;
import java.util.Random;

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

    Spinner spinAmount;
    int rollAmount = 1;
    ArrayList<BE_Die> diceList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Super Duper Dice Roller");

        //m_dice = new Dice();

        diceList = new ArrayList<BE_Die>();

        Button btnRoll = findViewById(R.id.btnRoll);
        Button btnHistory = findViewById(R.id.btnHistory);

        spinAmount = findViewById(R.id.spinAmount);
        Integer[] numbers = new Integer[]{1,2,3,4,5,6};
        ArrayAdapter<Integer> numberAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, numbers);
        spinAmount.setAdapter(numberAdapter);

        gridView = findViewById(R.id.gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int amt = position + 1;
                Toast.makeText(getApplicationContext(), "You clicked the image: " + amt, Toast.LENGTH_SHORT).show();
            }
        });

        spinAmount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                rollAmount = position + 1;
                Toast.makeText(getApplicationContext(), "You selected: " + rollAmount, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                return;
            }
        });

        btnRoll.setOnClickListener(new AdapterView.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(rollAmount >= 1) {
                    RollTheCheeeeeeeeese(rollAmount);

                    GridAdapter booksAdapter = new GridAdapter(MainActivity.this, diceList);
                    gridView.setAdapter(booksAdapter);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please select a number of times to roll", Toast.LENGTH_SHORT).show();
                }
                //
            }
        });

        //btnHistory.setOnClickListener();
    }

    private void RollTheCheeeeeeeeese(int amt) {
        diceList = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < amt; i++) {
            int num = r.nextInt(7 - 1) + 1; //random between i and 6. i = 1
            BE_Die die = new BE_Die(Integer.toString(num), num-1);
            diceList.add(die);
        }
    }

    public void openHistory(View view)
    {
        Intent i = new Intent(this, History.class);
        startActivityForResult(i, 200);
    }
}
