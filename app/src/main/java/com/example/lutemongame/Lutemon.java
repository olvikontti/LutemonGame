package com.example.lutemongame;

import java.io.Serializable;

public class Lutemon implements Serializable {

    private static final long SerialVersion1 = 123;

    protected String name;
    protected String color;
    protected int attack;
    protected int defense;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected int experience;
    protected int image;

    public String getName() {
        return name;
    }

    public int getImage() { return image; }

    public String getColor() {
        return color;
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


    public Lutemon(String name, String color, int attack, int defense, int health, int maxHealth, int id, int experience, int image) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
        this.experience = 0;
        this.image = image;
    }



}
