package com.rpg.engine;

import com.rpg.models.*;
//import com.rpg.services.Inventory;
import com.rpg.utils.EnemyManager;
import com.rpg.utils.ItemManager;



import java.util.Scanner;


public class GameEngine {
		
	private Player player;
    private Scanner scanner;
    private EnemyManager enemyManager;
    private ItemManager itemManager;

    public GameEngine() {
        scanner = new Scanner(System.in);
        enemyManager = new EnemyManager();
        itemManager = new ItemManager();
    }
    
    
    public void start() {
    	System.out.println("Welcome to the RPG!");
    	System.out.print("Enter your Hero Name: ");
    	String name = scanner.nextLine();
    	
    	System.out.printf("You chose %s as your hero name, is that right?\n=> 1-Yes 2-No", name);
    	int choiceName = scanner.nextInt();
    	
    	if(choiceName != 1)
    		start();
    	player = new Player(name);
    	System.out.println("Hello, " + player.getName() + "! Let’s begin your adventure.");
        mainMenu();
    }
    
    private void mainMenu() {
    	while(player.isAlive()) {
    		System.out.println("\n-- Main Menu --");
            System.out.println("1. View Inventory");
            System.out.println("2. Fight Enemy");
            System.out.println("3. Exit");
            System.out.print("Choose an action: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch(choice) {
            case 1:
                showInventory();
                break;
            case 2:
                fightEnemy();
                break;
            case 3:
                System.out.println("Thanks for playing!");
                return;
            default:
                System.out.println("Invalid choice.");
            } 
    	}
    }
    
    public void showInventory() {
    	System.out.println("-- Your Inventory --");
    	  if (player.getInventory().getItems().isEmpty()) {
    		  System.out.println("You have no items.");
    	  } else {
    		  player.getInventory().getItems().forEach(item -> System.out.println("- " + item.getName()));
    	  }
    		  
    }
    private void fightEnemy() {
        Enemy enemy = enemyManager.getRandomEnemy();
        System.out.println("You encountered a " + enemy.getName() + " with " + enemy.getHealth() + " HP!");

        System.out.println("You defeated the enemy!");
        Item loot = itemManager.getRandomItem();
        System.out.println("You received a loot item: " + loot.getName());
        player.addToInventory(loot);
    }
}
