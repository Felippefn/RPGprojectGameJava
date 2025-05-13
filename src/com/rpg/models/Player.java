package com.rpg.models;


import com.rpg.services.Inventory;

public class Player extends BaseEntity {
	
	private Inventory inventory;

	public Player(String name) {
        super(name, 100, 15, 5, 1.2f, 1.0f);
        this.inventory = new Inventory();
    }
	
	public Inventory getInventory() {
        return inventory;
    }
	
	public void levelUp() {
        level += 1;
        attack += 2;
        defense += 1;
        health += 10;
    }
	
}