package com.monty27.TicTacToe;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private String user1;
	private String user2;
	Board b = new Board();

	Game(String user1) {
		this.user1 = user1;
	}

	public String getUser1() {
		return user1;
	}

	public String getUser2() {
		return user2;
	}

	public void Start() {
		Scanner in = new Scanner(System.in);
		System.out.println("Initial setup with positions of board :");
		System.out.println("1 2 3");
		System.out.println("4 5 6");
		System.out.println("7 8 9");
		int flag = 0; // To take alternative turns
		while (true) {
			if (flag == 0) {
				System.out.println(user1 + ", please enter your position");
				int pos = Integer.parseInt(in.nextLine());
				if (!b.checkPresence(pos)) {
					System.out.println("OOPS!! You have entered an invalid input please enter again,");
					continue;
				} else {
					b.update(pos, b.getPlayerOne());
					b.displayState();
				}
				flag = 1;
			} else {
				System.out.println("I am Thinking....my position is as follows:");
				int pos = getCleverMove();
				b.update(pos, b.getPlayerTwo());
				b.displayState();

				flag = 0;
			}
			if (isGameOver()) {
				int winner = b.getWinner();
				if (winner == 3) {
					System.out.println("OOPS!! Match tied try again");
				} else if (winner == 1) {
					System.out.println("Congrats " + user1 + ", you won the match!!");
				} else if (winner == 2) {
					System.out.println("Sorry you lost the match!!");
				}
				break;
			}
		}
		in.close();
	}

	public boolean isAWinner(ArrayList<Integer> scores) {
		int total = scores.get(0) + 1;

		for (int i = 1; i < total; i++) {
			for (int j = i + 1; j < total; j++) {
				for (int k = j + 1; k < total; k++) {
					// System.out.println(scores.get(i) + " " + scores.get(j) +
					// " " + scores.get(k));
					if (scores.get(i) + scores.get(j) + scores.get(k) == 15) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean isGameOver() {
		ArrayList<Integer> scoreOfOne = b.seperatePositions(b.getPlayerOne());
		ArrayList<Integer> scoreOfTwo = b.seperatePositions(b.getPlayerTwo());
		if (isAWinner(scoreOfOne)) {
			b.setWinner(1);
			return true;
		} else if (isAWinner(scoreOfTwo)) {
			b.setWinner(2);
			return true;
		} else if (scoreOfOne.get(0) + scoreOfTwo.get(0) == 9) {
			b.setWinner(3);
			return true;
		}
		return false;
	}

	public int getCleverMove() {
		int position = 0;
		position = searchBestMove(b.seperatePositions(b.getPlayerTwo()), b.positionsAvailable());
		//System.out.println("Player twos focus score is : " + position);
		if (position == 0) {
			position = searchBestMove(b.seperatePositions(b.getPlayerOne()), b.positionsAvailable());
			//System.out.println("Player ones focus score is : " + position);
		}
		if (position == 0) {
			ArrayList<Integer> available = b.positionsAvailable();
			int randomIndex = (int) (Math.random() * available.size());
			position = available.get(randomIndex);
			//System.out.println("Random focus score is : " + position);
		}
		int[] posvals = b.getPosVals();
		for (int i = 0; i < 9; i++) {
			if (posvals[i] == position) {
				return i + 1;
			}
		}
		return position;
	}

	public int searchBestMove(ArrayList<Integer> used, ArrayList<Integer> available) {
		int noturns = used.get(0);

		for (int i = 1; i < noturns + 1; i++) {
			for (int j = i + 1; j < noturns + 1; j++) {
				int bal = 15 - (used.get(i) + used.get(j));
				if (available.contains(bal)) {
					return bal;
				}
			}
		}

		return 0;
	}
}
