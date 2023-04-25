package com.example.lutemongame;

public class Lutemon {
    protected String name;
    protected String color;
    protected String age;
    protected String gameNumber;
    protected int attack;
    protected int defense;
    protected int health;
    protected int maxHealth;
    protected int id;

    protected int experience;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getAge() {
        return age;
    }

    public String getGameNumber() {
        return gameNumber;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getId() {
        return id;
    }

    public int getExperience() {
        return experience;
    }

    public Lutemon(String name, String color, String age, String gameNumber) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.gameNumber = gameNumber;
    }

}
