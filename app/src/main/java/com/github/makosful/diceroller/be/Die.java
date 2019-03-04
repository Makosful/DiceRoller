package com.github.makosful.diceroller.be;

import android.graphics.drawable.Drawable;

public class Die
{
    private int value;
    private Drawable drawable;

    public Die(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public void setDrawable(Drawable drawable)
    {
        this.drawable = drawable;
    }

    public Drawable getDrawable()
    {
        return drawable;
    }
}
