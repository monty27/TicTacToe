package com.monty27.TicTacToe;

import java.util.Scanner;

public class tictactoeDemo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a name of first player :");
		String user1 = in.nextLine();
		Game G = new Game(user1);
		G.Start();
		in.close();
	}
}
