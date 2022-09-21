package java_portfolio_othello;

import java.util.Scanner;

public class Input {
	static final int EXPECTED_DIGIT = 2;
	private Scanner s = new Scanner(System.in);

	public int[] receivePosition(){
		System.out.print("座標を入力(例:A1) >>");
		String position = s.nextLine();
		int[] numericPosition = getNumericPosition(position);
		return numericPosition;
	}
	
	public int[] getNumericPosition(String pos) {
		if (pos.length() != EXPECTED_DIGIT) {
			return new int[] {-1,-1};
		}
		int x = getXPosition(pos.charAt(0));
		int y = getYPosition(pos.charAt(1));
		return new int[] {x,y};
	}
	public int getXPosition(char pos) {
		pos = Character.toUpperCase(pos);
		int x = -1;
		switch(pos) {
		case 'A':
			x = 0;
			break;
		case 'B':
			x = 1;
			break;
		case 'C':
			x = 2;
			break;
		case 'D':
			x = 3;
			break;
		case 'E':
			x = 4;
			break;
		case 'F':
			x = 5;
			break;
		case 'G':
			x = 6;
			break;
		case 'H':
			x = 7;
			break;
		}
		
		return x;
	}
	public int getYPosition(char pos) {
		int y = Character.getNumericValue(pos-1);
		if (y >= Board.BOARD_SIZE || 0 > y) {
			y = -1;
		}
		return y;
	}
	
	public boolean playAnotherGame() {
		while(true) {
			char answer = s.next().charAt(0);
			if (answer == 'Y' || answer == 'y') {
				return true;
			} else if (answer == 'N' || answer == 'n') {
				return false;
			}
		}
	}
}
