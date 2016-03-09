package com.monty27.TicTacToe;

import java.util.Scanner;

public class Game {
	private String user1;
	private String user2;
	Board b = new Board();
	
	Game(String user1, String user2){
		this.user1 = user1;
		this.user2 = user2;
	}

	public String getUser1() {
		return user1;
	}

	public String getUser2() {
		return user2;
	}
	
	public boolean isGameOver(){
		return false;
	}
	
	public void Run(){
		Scanner in = new Scanner(System.in);
		System.out.println("Initial setup with positions of board :");
	    System.out.println("1 2 3");
	    System.out.println("4 5 6");
	    System.out.println("7 8 9");
	    int flag = 0; // To take alternative turns
	    while(true){
	    	if(flag == 0){
	    		System.out.println(user1 + ", please enter your position");
	    		int pos = Integer.parseInt(in.nextLine());
	    		if(!b.checkPresence(pos)){
	    			System.out.println("OOPS!! You have entered an invalid input please enter again,");
	    			continue;
	    		}else{
	    			b.update(pos, b.getPlayerOne());
		    		b.displayState();
	    		}
	    		flag = 1;
	    	}else{
	    		System.out.println(user2 + ", please enter your position");
	    		int pos = Integer.parseInt(in.nextLine());
	    		if(!b.checkPresence(pos)){
	    			System.out.println("OOPS!! You have entered an invalid input please enter again,");
	    			continue;
	    		}else{
	    			b.update(pos, b.getPlayerTwo());
		    		b.displayState();
	    		}
	    		flag = 0;
	    	}
	    	if(b.isGameOver()){ 
    			int winner = b.getWinner();
    			if(winner == 3){
    				System.out.println("OOPS!! Match tied try again");
    			}else if(winner == 1){
    				System.out.println("Congrats " + user1  + ", you won the match!!");
    			}else if(winner == 2){
    				System.out.println("Congrats " + user2  + ", you won the match!!");
    			}
    			break;
    		}
	    }
	    in.close();
	}
}
