package com.monty27.TicTacToe;

public class sample {

	public static void main(String[] args) {
		int n = 7;
		for(int i=1;i<n;i++){
			for(int j=i+1;j<n;j++){
				for(int k=j+1;k<n;k++){
					System.out.println(i + " " + j + " " + k);
				}
			}
		}
	}

}
