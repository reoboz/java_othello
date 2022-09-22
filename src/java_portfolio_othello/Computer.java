package java_portfolio_othello;

import java.util.ArrayList;

public class Computer {
	Board board;
	
	public Computer (Board board) {
		this.board = board;
	}
	public void putOnRandomPlace() {
		ArrayList<int[]> checkedPositionList = board.findPlaceablePosition();
		if (checkedPositionList.size() == 0) {
			return;
		}
		int rnd = new java.util.Random().nextInt(checkedPositionList.size());
		int[] position = checkedPositionList.get(rnd);
		board.putPiece(position);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}
}
