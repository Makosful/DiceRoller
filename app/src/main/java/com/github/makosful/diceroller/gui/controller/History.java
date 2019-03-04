package com.github.makosful.diceroller.gui.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.makosful.diceroller.R;
import com.github.makosful.diceroller.gui.model.HistoryModel;
import com.github.makosful.diceroller.gui.model.ResultAdapter;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity
{
    private HistoryModel model;

    private RecyclerView recyclerView;
    private ResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("History");

        model = new HistoryModel();

        recyclerView = findViewById(R.id.rv_History);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        updateList();

        recyclerView.setAdapter(adapter);
    }

    private void updateList()
    {
        adapter = new ResultAdapter(model.getResultList(), this);
        recyclerView.setAdapter(adapter);
    }

    public void openDiceroller(View view)
    {
        setResult(RESULT_OK);
        finish();
    }

    public void clearHistory(View view)
    {
        model.clearResultList();
        updateList();
    }
}
