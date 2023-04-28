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

    public void trainAttack(Lutemon lutemon) {

        lutemon.experience++;

        int experiencePoints = lutemon.getExperience();
        int attackPoints = experiencePoints;
        lutemon.attack += attackPoints;

        System.out.println("MOI");
        return;

    }

    public void trainDefence(Lutemon lutemon) {

        lutemon.experience++;

        int experiencePoints = lutemon.getExperience();
        int defensePoints = experiencePoints;
        lutemon.defense += defensePoints;

        System.out.println("MOI");


        return;

    }



}
