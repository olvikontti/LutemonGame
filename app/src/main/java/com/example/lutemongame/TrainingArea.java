package com.example.lutemongame;

import java.util.ArrayList;

public class TrainingArea extends Habitat{

    public TrainingArea(String name, ArrayList<Lutemon> lutemons) {
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

    @Override
    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }







}
