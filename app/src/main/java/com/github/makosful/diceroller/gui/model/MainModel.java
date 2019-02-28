package com.github.makosful.diceroller.gui.model;

public class MainModel
{
    private Cache cache = Cache.getInstance();

    public void addResult(String result)
    {
        cache.results.add(result);
    }
}
