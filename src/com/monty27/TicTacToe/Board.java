package com.monty27.TicTacToe;

import java.util.ArrayList;

public class Board {
	private final int NoOfRows = 3;
	private final int NoOfCols = 3;
	private final char EMPTY = '_';
	private final char playerOne = 'X';
	private final char playerTwo = 'O';
	private char[] contents = new char[9];
	private int[] posVals = {2, 9, 4, 7, 5, 3, 6, 1, 8};
	
	private int winner = 0;
	
	Board(){
		for(int i=0; i < NoOfRows*NoOfCols; i++)
				contents[i] = EMPTY;
	}
	
	public void update(int position, char player){
		contents[position-1] = player;
	}
	
	public void displayState(){
		System.out.println("Current State is : ");
		System.out.println(contents[0] + " " + contents[1] + " " + contents[2]);
		System.out.println(contents[3] + " " + contents[4] + " " + contents[5]);
		System.out.println(contents[6] + " " + contents[7] + " " + contents[8]);
	}
	
	public ArrayList<Integer> seperatePositions(char player){
		ArrayList<Integer> positions = new ArrayList<Integer>();
		int j = 0;
		for(int i = 0; i<9;i++){
			if(contents[i] == player){
				positions.add(posVals[i]);
				j++;
			}
		}
		positions.add(0, j);
		return positions;
	}
	
	public boolean isAWinner(ArrayList<Integer> scores){
		int total = scores.get(0)+1;
		
		for(int i=1;i<total;i++){
			for(int j=i+1;j<total;j++){
				for(int k=j+1;k<total;k++){
					//System.out.println(scores.get(i) + " " + scores.get(j) + " " + scores.get(k));
					if(scores.get(i) + scores.get(j) + scores.get(k) == 15){
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public int getWinner() {
		return winner;
	}

	public boolean isGameOver(){
		ArrayList<Integer> scoreOfOne = seperatePositions(playerOne);
		ArrayList<Integer> scoreOfTwo = seperatePositions(playerTwo);
		if(isAWinner(scoreOfOne)){
			winner = 1;
			return true;
		}else if(isAWinner(scoreOfTwo)){
			winner = 2;
			return true;
		}else if(scoreOfOne.get(0) + scoreOfTwo.get(0) == 9){
			winner = 3;
			return true;
		}
		return false;
	}
	
	public boolean checkPresence(int pos){
		if(pos > 0 && pos < 10){
			if(contents[pos-1] == '_')
				return true;
		}
		return false;
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
	
	 
}
