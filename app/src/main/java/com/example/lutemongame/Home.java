package com.example.lutemongame;

import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Home extends Habitat{


    public Home(String name, ArrayList<Lutemon> lutemons) {
        super(name, lutemons);
    }

    @Override
    public void removeLutemon(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }

    @Override
    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }


}
