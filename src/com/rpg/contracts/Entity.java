package com.rpg.contracts;

public interface Entity {
    String getName();
    int getHealth();
    int getAttack();
    int getDefense();
    float getSpeed();
    float getLevel();

    void takeDamage(int amount);
    boolean isAlive();
}