package com.example.lutemongame;

import java.util.ArrayList;

public class LutemonStorage {
    private String name;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static LutemonStorage storage = null;

    private LutemonStorage() {
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public Lutemon getLutemon(int id) {
        return lutemons.get(id);
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public static LutemonStorage getInstance() {
        if (storage == null) {
            storage = new LutemonStorage();
        }
        return storage;
    }

}
