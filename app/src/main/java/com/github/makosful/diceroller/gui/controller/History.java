package com.github.makosful.diceroller.gui.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.makosful.diceroller.R;

public class History extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("History");
    }

    public void openDiceroller(View view)
    {
        setResult(RESULT_OK);
        finish();
    }
}
