package com.github.makosful.diceroller.gui.model;

import com.github.makosful.diceroller.bll.LogicManager;

public class MainModel
{
    private LogicManager logic;
    private Cache cache = Cache.getInstance();

    public MainModel()
    {
        logic = new LogicManager();
    }

    public void addResult(String result)
    {
        cache.results.add(result);
    }

}
