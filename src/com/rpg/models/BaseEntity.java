package com.rpg.models;

import com.rpg.contracts.Entity;

public abstract class BaseEntity implements Entity {

	 	protected String name;
	    protected int health;
	    protected int attack;
	    protected int defense;
	    protected float speed;
	    protected float level;

	    public BaseEntity(String name, int health, int attack, int defense, float speed, float level) {
	        this.name = name;
	        this.health = health;
	        this.attack = attack;
	        this.defense = defense;
	        this.speed = speed;
	        this.level = level;
	    }

	    @Override
	    public String getName() { return name; }

	    @Override
	    public int getHealth() { return health; }

	    @Override
	    public int getAttack() { return attack; }

	    @Override
	    public int getDefense() { return defense; }

	    @Override
	    public float getSpeed() { return speed; }

	    @Override
	    public float getLevel() { return level; }

	    @Override
	    public void takeDamage(int amount) {
	        int damage = Math.max(0, amount - defense);
	        health = Math.max(0, health - damage);
	    }

	    @Override
	    public boolean isAlive() {
	        return health > 0;
	    }
	
}
