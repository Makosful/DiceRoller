package com.github.makosful.diceroller.gui.model;

import java.util.ArrayList;
import java.util.List;

class Cache
{
    private static final Cache ourInstance = new Cache();

    static Cache getInstance()
    {
        return ourInstance;
    }

    List<String> results;

    private Cache()
    {
        results = new ArrayList<>();
    }
}
