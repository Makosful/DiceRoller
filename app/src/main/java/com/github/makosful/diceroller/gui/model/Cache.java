package com.github.makosful.diceroller.gui.model;

class Cache
{
    private static final Cache ourInstance = new Cache();

    static Cache getInstance()
    {
        return ourInstance;
    }

    private Cache()
    {
    }
}
