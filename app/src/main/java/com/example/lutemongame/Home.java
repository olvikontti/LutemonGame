package com.example.lutemongame;

import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Home extends LutemonStorage{

    private ArrayList<Lutemon> homeLutemons = new ArrayList<>();

    public Home(ArrayList<Lutemon> lutemons, String name) {
        super(lutemons, name);
    }

    public ArrayList<Lutemon> getHomeLutemons(){
        for(int i = 0; i < lutemons.size(); i++){
            homeLutemons.add(lutemons.get(i));
            System.out.println(homeLutemons.get(i).name);
        }
        return homeLutemons;
    }


}
