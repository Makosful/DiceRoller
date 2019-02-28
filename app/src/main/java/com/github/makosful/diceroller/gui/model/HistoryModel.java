package com.github.makosful.diceroller.gui.model;

import java.util.List;

public class HistoryModel
{


    private Cache cache = Cache.getInstance();

    public List<String> getResultList()
    {
        return cache.results;
    }
}
