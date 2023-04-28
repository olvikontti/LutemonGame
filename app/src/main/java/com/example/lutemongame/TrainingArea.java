package com.example.lutemongame;

import java.util.ArrayList;

public class TrainingArea extends Habitat{

    public TrainingArea(String name, ArrayList<Lutemon> lutemons) {
        super(name, lutemons);
    }

    public void trainAttack(Lutemon lutemon) {

        int experiencePoints = lutemon.getExperience();
        int attackPoints = experiencePoints;
        lutemon.attack += attackPoints;
        lutemon.experience++;

        System.out.println("MOI");
        return;

    }

    public void trainDefence(Lutemon lutemon) {
        int experiencePoints = lutemon.getExperience();
        int defensePoints = experiencePoints;
        lutemon.defense += defensePoints;
        lutemon.experience++;

        System.out.println("MOI");


        return;

    }



}
