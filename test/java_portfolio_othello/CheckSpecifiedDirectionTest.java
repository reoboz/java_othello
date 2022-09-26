package java_portfolio_othello;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckSpecifiedDirectionTest {
	private Board board;
	
	@BeforeEach
	void setup() {
		board = new Board();
		
		Game.playerTurn = 1;
	}

	/* checkSpecifiedDirectionTest */
	@Test
	void returnsFalseOnFindingOutOfBoard() {
		int[] position = new int[] {0,0};
		int directionX = -1;
		int directionY = 0;
		
		assertFalse(board.checkSpecifiedDirection(position, directionX, directionY));
		
	}
	@Test
	void returnsFalseOnFindingZero() {
		int[] position = new int[] {0,0};
		int directionX = 1;
		int directionY = 0;
		
		assertFalse(board.checkSpecifiedDirection(position, directionX, directionY));
		
	}
	@Test
	void returnsFalseOnFindingPlayerNumber() {
		int[] position = new int[] {2,3};
		int directionX = 1;
		int directionY = 0;
		
		assertFalse(board.checkSpecifiedDirection(position, directionX, directionY));
		
	}
	
	@Test
	void returnsTrueOnFindingCorrectPattern() {
		int[] position = new int[] {5,3};
		int directionX = -1;
		int directionY = 0;
		assertTrue(board.checkSpecifiedDirection(position, directionX, directionY));
	}
	
}
