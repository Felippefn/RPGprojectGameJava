package com.rpg.engine;

import com.rpg.models.*;
//import com.rpg.services.Inventory;
import com.rpg.utils.EnemyManager;
import com.rpg.utils.ItemManager;
import com.rpg.services.BattleService;


import java.util.Scanner;


public class GameEngine {
		
	private Player player;
    private Scanner scanner;
    private EnemyManager enemyManager;
    private ItemManager itemManager;
    private BattleService battleService;

    public GameEngine() {
        scanner = new Scanner(System.in);
        enemyManager = new EnemyManager();
        itemManager = new ItemManager();
        battleService = new BattleService(this); // pass GameEngine to it
    }
    
    
    public void start() {
        System.out.println("Welcome to the RPG!");
        System.out.print("Enter your Hero Name: ");
        String name = scanner.nextLine();

        System.out.printf("You chose %s as your hero name, is that right?\n=> 1-Yes 2-No\n", name);
        int choiceName = 0;
        
        // Validate input and consume leftover newline
        while (true) {
            if (scanner.hasNextInt()) {
                choiceName = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newline
                if (choiceName == 1 || choiceName == 2) break;
            } else {
                scanner.nextLine(); // discard invalid input
            }
            System.out.println("Please enter 1 for Yes or 2 for No:");
        }
        
        if (choiceName != 1) {
            start();  // restart the process if not confirmed
            return;   // important to stop further execution
        }

        player = new Player(name);
        System.out.println("Hello, " + player.getName() + "! Let’s begin your adventure.");
        mainMenu();
    }

    
    private void mainMenu() {
    	while(player.isAlive()) {
    		System.out.println("\n-- Main Menu --");
            System.out.println("1. Open Inventory");
            System.out.println("2. Explore dark woods");
            System.out.println("3. Go to Shop in City");
            System.out.println("4. Exit");
            System.out.print("\nChoose an action: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch(choice) {
            case 1:
                System.out.println(showInventory()); 
                break;
            case 2:
                encountersEnemy();
                break;
            case 3:
            	System.out.println("yygy");
                break;
            case 4:
            	System.out.println("Thanks for playing!");
                summaryStats();
                return;
            default:
                System.out.println("Invalid choice.");
            } 
    	}
    }
    
    public String showInventory() {
        StringBuilder inventoryText = new StringBuilder("-- Your Inventory --\n");
        if (player.getInventory().getItems().isEmpty()) {
            inventoryText.append("You have no items.");
        } else {
            player.getInventory().getItems().forEach(item -> 
                inventoryText.append("- ").append(item.getName()).append("\n"));
        }
        return inventoryText.toString();
    }

    private void encountersEnemy() {
        Enemy enemy = enemyManager.getRandomEnemy();
        System.out.println("You encountered a " + enemy.getName() + " with " + enemy.getHealth() + " HP!");
        
        
        Item loot = itemManager.getRandomItem();
        System.out.println("You received a loot item: " + loot.getName());
        player.addToInventory(loot);
        
        battleService.startBattle(player, enemy);
    }
    
    void summaryStats() {
    	System.out.printf("Your character is resting in peace with:\n-%d HP\n-Level %f", player.getHealth(), player.getLevel()); 
    }
}
