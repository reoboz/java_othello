package java_portfolio_othello;

import java.util.ArrayList;

public class Board {
	static final int BOARD_SIZE = 8;
	private int[][] squareList = new int[8][8];
	
	
	public Board() {
		squareList[3][3] = 1;
		squareList[4][4] = 1;
		squareList[3][4] = 2;
		squareList[4][3] = 2;
	}
	
	public Board(int[][] situationBoard) {
		squareList = situationBoard;
	}
	
	public void display() {
		System.out.println("  ＡＢＣＤＥＦＧＨ");
		for (int i = 0; i < BOARD_SIZE; i++) {
			StringBuilder print = new StringBuilder();
			print.append(i+1+ " ");
			for (int j = 0; j < BOARD_SIZE; j++) {
				switch(squareList[i][j]) {
				case 0:
					print.append("・");
					break;
				case 1:
					print.append("●");
					break;
				case 2:
					print.append("○");
					break;
				}
			}
			System.out.println(print);
		}
	}
	
	public boolean putPiece(int[] position) {
		if (validateSpecifiedPosition(position)) {
			setSquareList(position);
			reverseSurroundedSquare(position);
			return true;
		} else {
			System.out.println("そこには置けません");
			return false;
		}
	}
	
	public boolean validateSpecifiedPosition(int[] position) {
		int x = position[0];
		int y = position[1];
		if (!(isInRange(x,y))){
			return false;
		}
		if (squareList[y][x] != 0) {
			return false;
		}
		if (checkSurroundedSquare(position)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkSurroundedSquare(int[] position) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (checkSpecifiedDirection(position, i, j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkSpecifiedDirection(int[] position, int directionX, int directionY) {
		int x = position[0] + directionX;
		int y = position[1] + directionY;
		if (!(isInRange(x,y))) {
			return false;
		}
		if (squareList[y][x] == 0) {
			return false;
		}
		if (squareList[y][x] == Game.playerTurn) {
			return false;
		}
		while (true) {
			x += directionX;
			y += directionY;
			if (!(isInRange(x,y))){
				return false;
			}
			if (squareList[y][x] == 0) {
				return false;
			}
			if (squareList[y][x] == Game.playerTurn) {
				return true;
			}
		}
	}
	
	public void reverseSurroundedSquare(int[] position) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				ArrayList<int[]> checkedPositionList = new ArrayList<>();
				checkedPositionList.add(position);
				reverseSpecifiedDirection(checkedPositionList, i,j);
			}
		}
	}
	
	public void reverseSpecifiedDirection(ArrayList<int[]> checkedPositionList, int directionX, int directionY){
		int x = Misc.getLastElement(checkedPositionList)[0] + directionX;
		int y = Misc.getLastElement(checkedPositionList)[1] + directionY;
		if (!(isInRange(x,y))) {
			return;
		}
		if (squareList[y][x] == 0) {
			return;
		}
		if (squareList[y][x] != Game.playerTurn) {
			checkedPositionList.add(new int[] {x,y});
			reverseSpecifiedDirection(checkedPositionList, directionX, directionY);
		} else {
			reversePieces(checkedPositionList);
		}
	}
	
	public void reversePieces(ArrayList<int[]> checkedPositionList) {
		checkedPositionList.remove(0);
		checkedPositionList.forEach(position -> {
			int x = position[0];
			int y = position[1];
			squareList[y][x] = Game.playerTurn;
		});
	}
	
	public ArrayList<int[]> findPlaceablePosition() {
		ArrayList<int[]> checkedPositionList = new ArrayList<>();
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				int[] pos = new int[] {i, j};
				if(validateSpecifiedPosition(pos)) {
					checkedPositionList.add(pos);
				};
			}
		}
		return checkedPositionList;
	}

	
	public boolean isBoardFilled() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (squareList[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public int[] countPieces() {
		int[] pieceList = new int[2];
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (squareList[i][j] == 0) {
					continue;
				}
				int playerNum = squareList[i][j]-1;
				pieceList[playerNum] += 1;
			}
		}
		return pieceList;
	}
	
	public boolean isInRange(int x, int y) {
		if (y >= Board.BOARD_SIZE || 0 > y
				|| x >= Board.BOARD_SIZE || 0 > x) {
			return false;
		} else {
			return true;
		}
	}
	
	public void setSquareList(int[] position) {
		int x = position[0];
		int y = position[1];
		squareList[y][x] = Game.playerTurn;
	}
	
	public int[][] getSquareList(){
		return this.squareList;
	}
}
