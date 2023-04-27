package com.example.lutemongame;

import java.io.Serializable;

public class Lutemon implements Serializable {

    private static final long SerialVersion1 = 123;

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
    protected int image;

    public String getName() {
        return name;
    }

    public int getImage() { return image; }

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
        this.experience = 0;

        // testikuva
        this.image = R.drawable.testface;

        switch (color) {
            case "Valkoinen":
                this.attack = 5;
                this.defense = 4;
                this.maxHealth = 20;
                this.health = 20;
                image = R.drawable.white;
                break;
            case "Vihreä":
                this.attack = 6;
                this.defense = 3;
                this.maxHealth = 19;
                this.health = 19;
                image = R.drawable.green;
                break;
            case "Pinkki":
                this.attack = 7;
                this.defense = 2;
                this.maxHealth = 18;
                this.health = 18;
                image = R.drawable.pink;
                break;
            case "Oranssi":
                this.attack = 8;
                this.defense = 1;
                this.maxHealth = 17;
                this.health = 17;
                image = R.drawable.orange;
                break;
            case "Musta":
                this.attack = 9;
                this.defense = 0;
                this.maxHealth = 16;
                this.health = 16;
                break;
        }
    }

}
