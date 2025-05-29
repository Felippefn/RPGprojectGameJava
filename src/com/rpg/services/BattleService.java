package com.rpg.services;

import com.rpg.models.Player;

import com.rpg.engine.GameEngine;

import com.rpg.models.Enemy;

import java.util.Scanner;


public class BattleService {

	private final Scanner scanner = new Scanner(System.in);
	private GameEngine gameEngine;
	boolean fleeFromBattle = false;
	
	public BattleService(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }
	
	public void startBattle(Player player, Enemy enemy) {
		System.out.printf("A wild %s appears!\n", enemy.getName());
		
		boolean isPlayerTurn = player.getSpeed() >= enemy.getSpeed();
		
		while(player.isAlive() && enemy.isAlive() ) {
			if(isPlayerTurn) {
				playerTurn(player, enemy);
			}else {
				//enemyTurn(player, enemy);
			}
			
			//Toggle turn
			
			isPlayerTurn = !isPlayerTurn;
		}
		
		if (player.isAlive() && enemy.getHealth() <= 0) {
			System.out.printf("✨ you defeated %s!\n", enemy.getName());
		} else {
			System.out.println("You were defeated...");
		}
		
	}
	
	private void playerTurn(Player player, Enemy enemy) {
		System.out.println("Your turn!");
		System.out.println("Choose your move!\n1- Attack\n2- Item\n3- Run");
		
		int inputUser = scanner.nextInt();
		
		switch(inputUser) {
		case 1:
			int damage = player.getAttack();
			enemy.takeDamage(damage);
			System.out.printf("You have dealth %d damage to %s!", damage, enemy.getName());
		case 2:
			System.out.println(gameEngine.showInventory());
			System.out.println("Do you want to use any item?");
			for (int i= 0; i < player.getInventory().getItems().size(); i++) {
				System.out.printf("%d index of items", i);
			}
		case 3:
			break;
		
	}
		}
	
}
