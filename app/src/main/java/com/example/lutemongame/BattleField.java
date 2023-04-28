package com.example.lutemongame;

import java.util.ArrayList;

public class BattleField extends Habitat{

    public BattleField(String name, ArrayList<Lutemon> lutemons) {

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
