package com.rpg.models;

public class Enemy extends BaseEntity {

    private int xp;
    private float rarity;

    public Enemy(String name, int health, int attack, int defense, float speed, float level, int xp, float rarity) {
        super(name, health, attack, defense, speed, level);
        this.xp = xp;
        this.rarity = rarity;
    }

    public int getXp() {
        return xp;
    }

    public float getRarity() {
        return rarity;
    }
}
