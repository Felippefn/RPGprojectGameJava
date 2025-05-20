package com.rpg.models;

public class Enemy extends BaseEntity {

    private int xp;
    private float rarity;
    private int coins;

    public Enemy(String name, int health, int attack, int defense, float speed, float level, int xp, int rarity, int coins) {
    	super(name, health, attack, defense, speed, level);
        this.xp = xp;
        this.coins = coins;
        this.rarity = rarity;
    }

    public int getXp() {
        return xp;
    }

    public float getRarity() {
        return rarity;
    }
    
    public int getCoins() {
    	return coins;
    }
    
    @Override
    public String toString() {
        return getName() + " [HP=" + getHealth() + ", ATK=" + getAttack() +
               ", DEF=" + getDefense() + ", XP=" + xp + ", Coins=" + coins +
               ", Rarity=" + rarity + "]";
    }
}
