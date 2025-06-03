package com.rpg.services;

import com.rpg.models.Player;

import com.rpg.engine.GameEngine;

import com.rpg.models.Enemy;

import java.util.Random;
import java.util.Scanner;


public class BattleService {

	private final Scanner scanner = new Scanner(System.in);
	private GameEngine gameEngine;
	boolean fleeFromBattle = false;
	private Random random = new Random();
	
	public BattleService(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }
	
	public void startBattle(Player player, Enemy enemy) {
		System.out.printf("A wild %s appears!\n", enemy.getName());
		
		boolean isPlayerTurn = player.getSpeed() >= enemy.getSpeed();
		
		while(!fleeFromBattle) {
			if(isPlayerTurn) {
				playerTurn(player, enemy);
			}else {
				enemyTurn(player, enemy);
			}
			
			//Toggle turn
			
			isPlayerTurn = !isPlayerTurn;
		}
		
		if (player.isAlive() && enemy.getHealth() <= 0) {
			System.out.printf("---> You defeated %s!\n", enemy.getName());
		} else if(player.getHealth() <= 0 && enemy.isAlive()){
			System.out.println("You were defeated...");
		} else {
			System.out.println();
		}
		
	}
	
	private void playerTurn(Player player, Enemy enemy) {
		System.out.println("========================================\n");
		System.out.println("Your turn!");
		System.out.printf("\nChoose your move against %s !"
				+ "\n================================"
				+ "\n> 1- Attack\n> 2- Item\n> 3- Run\n"
				+ "=================================\n", enemy.getName());
		float crit = random.nextInt(11) * (enemy.getSpeed());
		
		int inputUser = scanner.nextInt();
		
		switch(inputUser) {
		case 1:
			int damage = player.getAttack() - enemy.getDefense();
			float chancesCrit = random.nextFloat(11);
			if (chancesCrit >= 8.5) {
				damage *= crit;
				System.out.println("Crit Hit!");
			}
			
			enemy.takeDamage(damage);
			System.out.printf("You have dealth %d damage to %s!\n", damage, enemy.getName());
		case 2:
			System.out.println(gameEngine.showInventory());
			System.out.println("Do you want to use any item?");
			System.out.println(player.getInventory().getItems());
			for (int i= 0; i < player.getInventory().getItems().size(); i++) {
				System.out.printf("%d index of items - \n", i);
			}
			break;
		case 3:
			int chances = random.nextInt(11);
			float chancesToEscapeEnemy = (chances > 0) ? chances * enemy.getSpeed() :  2 * enemy.getSpeed() + player.getSpeed();
			float chancesPlayer = (chances > 0) ? chances * player.getSpeed() : player.getSpeed() * (enemy.getSpeed() / 2);
			System.out.println("Chances To escape: " + chancesToEscapeEnemy + "\nChange player: "+ chancesPlayer);
			if (chancesPlayer > (0.2 * chancesToEscapeEnemy) + chancesToEscapeEnemy) {
				System.out.println("You have escaped from " + enemy.getName());
				fleeFromBattle = true;
				break;
			} else {
				System.out.println("You have failed to escape!");
				enemyTurn(player, enemy);
				return;
			}
		
	}
		}
	private void enemyTurn(Player player, Enemy enemy) {
		float crit = random.nextInt(11) * (enemy.getSpeed());
		int damage = enemy.getAttack() - player.getDefense();
		int chancesCrit = random.nextInt(21);
		if (chancesCrit > 16) {
			damage *= crit;
		}
		player.takeDamage(damage);
		
	}
	
}
