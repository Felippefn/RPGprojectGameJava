package com.rpg.models;

import com.rpg.services.Inventory;

public class Enemy extends BaseEntity{
	
	private int xp;
	private float rarity;
	
	public Enemy(String name, int health, int attack, int defense, float speed, float level) {
		super(name, health, attack, defense, speed, level);
		this.xp = xp;
		this.rarity = rarity;
	}
	
}
