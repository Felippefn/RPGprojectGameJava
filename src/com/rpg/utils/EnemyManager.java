package com.rpg.utils;

import com.rpg.models.Enemy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnemyManager {
    private List<Enemy> enemies;
    private Random random = new Random();

    public EnemyManager() {
        enemies = Arrays.asList(
        	new Enemy("Goblin", 30, 10, 5, 1.0f, 1.0f, 20, 0.5f),
            new Enemy("Ghost", 35, 10, 5, 1.0f, 1.0f, 20, 0.5f),
            new Enemy("Skeleton", 35, 10, 5, 1.0f, 1.0f, 20, 0.5f)
        );
    }

    public Enemy getRandomEnemy() {
        return enemies.get(random.nextInt(enemies.size()));
    }
}
