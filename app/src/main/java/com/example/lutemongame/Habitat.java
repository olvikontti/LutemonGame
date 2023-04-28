package com.example.lutemongame;

import java.util.ArrayList;

public abstract class Habitat{

    protected String name;
    protected ArrayList<Lutemon> lutemons;

    public Habitat(String name, ArrayList<Lutemon> lutemons){
        this.name = name;
        this.lutemons = lutemons;
    }

    public abstract void removeLutemon(Lutemon lutemon);

    public abstract void addLutemon(Lutemon lutemon);

    public abstract ArrayList<Lutemon> getLutemons();

}
