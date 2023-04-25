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

    public Lutemon(String name, String color, String age, String gameNumber) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.gameNumber = gameNumber;
    }

}
