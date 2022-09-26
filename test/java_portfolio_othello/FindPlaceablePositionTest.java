package java_portfolio_othello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FindPlaceablePositionTest {
	private Board board;
	private ArrayList<int[]> checkedPositionList;
	
	@BeforeEach
	void setup() {
		
		Game.playerTurn = 2;

	}

	/* findPlaceablePositionTest */
	@Test
	void returnsFourOnDefaultBoard() {
		board = new Board();
		checkedPositionList = board.findPlaceablePosition();
		assertTrue(checkedPositionList.size() == 4);
	}

	@Test
	void returnsZeroOnGivenBoard() {
		int[][] situation_board = {
				{0,0,0,0,0,0,0,0},
				{0,2,2,2,0,0,0,0},
				{0,2,1,2,0,0,0,0},
				{0,2,2,2,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0}
				};
		board = new Board(situation_board);
		checkedPositionList = board.findPlaceablePosition();
		assertTrue(checkedPositionList.size() == 0);
	}
}
