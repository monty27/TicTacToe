package com.monty27.TicTacToe;

import java.util.Scanner;

public class tictactoeDemo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a name of first player :");
	    String user1 = in.nextLine();
	    System.out.println("Enter a name of Second player :");
	    String user2 = in.nextLine();
	    Game G = new Game(user1, user2);
	    G.Run();
	    in.close();
	}
}
