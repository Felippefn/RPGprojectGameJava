package com.rpg.utils;

import com.rpg.models.Enemy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnemyManager {
    private List<Enemy> enemies;
    private Random random = new Random();

    public EnemyManager() { 
    	// Enemy(String name, int health, int attack, int defense, float speed, float level, int xp, float rarity, int coins)
        enemies = Arrays.asList(
        	new Enemy("Goblin", 30, 10, 5, 1.0f, 1.0f, 20, 1, 15),
            new Enemy("Ghost", 35, 10, 5, 1.0f, 1.0f, 20, 5, 15),
            new Enemy("Skeleton", 35, 10, 5, 1.0f, 1.0f, 20, 3, 15)
        );
    }

    public Enemy getRandomEnemy() {
    	System.out.println(random.nextInt(101));
    	for (int i =0; i<enemies.size(); i++) {
    		System.out.println(enemies.get(i).getRarity());
    	}
        return enemies.get(random.nextInt(enemies.size()));
    	 
    }
    

}
