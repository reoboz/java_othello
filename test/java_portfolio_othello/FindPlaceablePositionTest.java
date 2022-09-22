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
		board = new Board();
		
		Game.playerTurn = 2;

	}

	/* findPlaceablePositionTest */
	@Test
	void returnsThreeOnDefaultBoard() {
		checkedPositionList = board.findPlaceablePosition();
		assertTrue(checkedPositionList.size() == 4);
	}

}
