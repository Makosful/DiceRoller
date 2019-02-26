package com.github.makosful.diceroller.gui.model;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.io.Serializable;

public class BE_Die implements Serializable {
    private String m_Name;
    private int m_Img;
    private int m_EyesAmount;

    public BE_Die(String name, int img) {
        m_Name = name;
        m_Img = img;
    }

    public int getImage() { return m_Img; }
    public String getName() { return m_Name; }
    //public int getEyeAmount() { return m_EyesAmount; }

}
