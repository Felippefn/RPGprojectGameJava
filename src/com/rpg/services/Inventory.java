package com.rpg.services;

import com.rpg.models.Item;
import java.util.ArrayList;
import java.util.List;


public class Inventory {

	private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println("An Item was added to your intenvory: " + item.getName());
    }

    public boolean removeItem(Item item) {
    	System.out.printf("%s was removed from your inventory", item.getName());
        return items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }
	
}
