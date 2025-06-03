package com.rpg.utils;

import com.rpg.models.Item;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ItemManager {
    private List<Item> itemsLoot;
    private Random random = new Random();

    public ItemManager() {
        itemsLoot = Arrays.asList(
            new Item("Health Potion", "Health", 100),
            new Item("Iron Sword", "Combat", 30),
            new Item("Leather Armor", "Combat", 20),
            new Item("Speed Elixir", "Combat", 10)
        );
    }

    public Item getRandomItem() {
        return itemsLoot.get(random.nextInt(itemsLoot.size()));
    }
}
