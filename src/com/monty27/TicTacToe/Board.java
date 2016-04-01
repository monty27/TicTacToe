package com.monty27.TicTacToe;

import java.util.ArrayList;

public class Board {
	private final int NoOfRows = 3;
	private final int NoOfCols = 3;
	private final char EMPTY = '_';
	private final char playerOne = 'X';
	private final char playerTwo = 'O';
	private char[] contents = new char[9];
	private int[] posVals = { 2, 9, 4, 7, 5, 3, 6, 1, 8 };

	public int[] getPosVals() {
		return posVals;
	}

	private int winner = 0;

	Board() {
		for (int i = 0; i < NoOfRows * NoOfCols; i++)
			contents[i] = EMPTY;
	}

	public char getPlayerOne() {
		return playerOne;
	}

	public char getPlayerTwo() {
		return playerTwo;
	}

	public char[] getContents() {
		return contents;
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public void update(int position, char player) {
		contents[position - 1] = player;
	}

	public void displayState() {
		System.out.println("Current State is : ");
		System.out.println(contents[0] + " " + contents[1] + " " + contents[2]);
		System.out.println(contents[3] + " " + contents[4] + " " + contents[5]);
		System.out.println(contents[6] + " " + contents[7] + " " + contents[8]);
	}

	public ArrayList<Integer> seperatePositions(char player) {
		ArrayList<Integer> positions = new ArrayList<Integer>();
		int j = 0;
		for (int i = 0; i < 9; i++) {
			if (contents[i] == player) {
				positions.add(posVals[i]);
				j++;
			}
		}
		positions.add(0, j);
		//System.out.println(positions);
		return positions;
	}

	public ArrayList<Integer> positionsAvailable() {
		ArrayList<Integer> positions = new ArrayList<Integer>();
		for (int i = 0; i < NoOfRows * NoOfCols; i++) {
			if (contents[i] == EMPTY) {
				positions.add(posVals[i]);
			}
		}
		return positions;
	}

	public boolean checkPresence(int pos) {
		if (pos > 0 && pos < 10) {
			if (contents[pos - 1] == '_')
				return true;
		}
		return false;
	}

}
