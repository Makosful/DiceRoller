package com.github.makosful.diceroller.gui.model;

import com.github.makosful.diceroller.R;

import java.util.ArrayList;

public class Dice {
    ArrayList<BE_Die> m_Dice;

    public Dice() {
        m_Dice = new ArrayList<BE_Die>();
        m_Dice.add(new BE_Die("one", R.drawable.d1));
        m_Dice.add(new BE_Die("two", R.drawable.d2));
        m_Dice.add(new BE_Die("three", R.drawable.d3));
        m_Dice.add(new BE_Die("four", R.drawable.d4));
        m_Dice.add(new BE_Die("five", R.drawable.d5));
        m_Dice.add(new BE_Die("six", R.drawable.d6));
    }

    public ArrayList<BE_Die> getAllDice() {
        return m_Dice;
    }

    public String[] getNames() {
        String[] names = new String[m_Dice.size()];

        for (int i = 0; i < names.length; i++) {
            names[i] = m_Dice.get(i).getName();
        }
        return names;
    }

    public int[] getImage() {
        int[] images = new int[m_Dice.size()];

        for (int i = 0; i < images.length; i++) {
            images[i] = m_Dice.get(i).getImage();
        }
        return images;
    }
}
