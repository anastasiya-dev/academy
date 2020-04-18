package by.academy.lesson4.Homework2;

import java.util.Random;
import java.util.Scanner;

public class HW2_Task6_Deal {
	
	public static void main (String[] args) {
		
		final int deckSize = 52;
		int cardNumber = 0;
		final int cardsForOne = 5;
		
		//create and shuffle the deck	
		int deck[] = new int[deckSize];
		Random rnd = new Random();
		for (int i = 0; i < deckSize; i++) {
			deck[i] = i + 1;
		}
		for (int i = 0; i < deckSize; i++) {
			int j = rnd.nextInt(deckSize);
			int tech = deck[j];
			deck[j] = deck[i];
			deck[i] = tech;			
		}
						
		//give cards to the players		
		String poker [][] = new String [getNumberOfPlayers()][cardsForOne];
		
		for (int i = 0; i < poker.length; i++) {
			System.out.println("Cards of the Player" + (i + 1) + ":");
			for (int j = 0; j < poker[i].length; j++) {
				String type = defineType (deck[cardNumber]);
				String value = defineValue (deck[cardNumber]);
				poker[i][j] = type + "-" + value;
				System.out.print(poker[i][j] + " ");
				cardNumber++;
			}
			System.out.print("\n" + "\n");
		}
	}	

	public static int getNumberOfPlayers () {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter number of players:");
		int playersN = sc.nextInt();
		System.out.println("***");
		sc.close();
		return playersN;
	}
	
	public static String defineType (int cardCode) {
		String type = "";
		int typeNumber = cardCode / 13;
		switch (typeNumber) {
		case 0:
			type = "Clubs";
			break;
		case 1:
			type = "Diamonds";
			break;
		case 2:
			type = "Hearts";
			break;
		case 3:
			type = "Spades";
			break;
		}
		return type;
	}
	
	public static String defineValue (int cardCode) {
		String value = "";
		int valueNumber = cardCode % 13;
		switch (valueNumber) {
		case 0:
			value = "Ace";
			break;
		case 1:
			value = "2";
			break;
		case 2:
			value = "3";
			break;
		case 3:
			value = "4";
			break;
		case 4:
			value = "5";
			break;
		case 5:
			value = "6";
			break;
		case 6:
			value = "7";
			break;
		case 7:
			value = "8";
			break;
		case 8:
			value = "9";
			break;
		case 9:
			value = "10";
			break;
		case 10:
			value = "Jack";
			break;
		case 11:
			value = "Queen";
			break;
		case 12:
			value = "King";
			break;
		}
		return value;
	}
}
