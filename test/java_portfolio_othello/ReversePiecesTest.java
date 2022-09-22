package java_portfolio_othello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReversePiecesTest {
	private Board board;
	private ArrayList<int[]> checkedPositionList;

	private int[][] defaultBoard = {
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 2, 0, 0, 0 },
			{ 0, 0, 0, 2, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
	};
	
	@BeforeEach
	void setup() {
		board = new Board();
		
		Game.playerTurn = 1;
		
		checkedPositionList = new ArrayList<>();

	}
	
	/* reverseSpecifiedDirectionTest */
	@Test
	void reverseOnePiece() {
		checkedPositionList.add(new int[] {5,3});
		board.reverseSpecifiedDirection(checkedPositionList, -1, 0);
		
		int[][] expectedBoard = {
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 2, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 },
		};
		
		int[][] resultBoard = board.getSquareList();
		
		assertTrue(isSameBoard(expectedBoard, resultBoard));
	}
	@Test
	void reverseNoPiece_1() {
		checkedPositionList.add(new int[] {5,3});
		board.reverseSpecifiedDirection(checkedPositionList, -1, -1);
		
		int[][] resultBoard = board.getSquareList();
		
		assertTrue(isSameBoard(defaultBoard, resultBoard));
	}
	
	@Test
	void reverseNoPiece_2() {
		checkedPositionList.add(new int[] {5,3});
		board.reverseSpecifiedDirection(checkedPositionList, -1, 1);
		
		int[][] resultBoard = board.getSquareList();
		
		assertTrue(isSameBoard(defaultBoard, resultBoard));
	}
	
	@Test
	void reverseNoPiece_3() {
		checkedPositionList.add(new int[] {5,3});
		board.reverseSpecifiedDirection(checkedPositionList, 0, -1);
		
		int[][] resultBoard = board.getSquareList();
		
		assertTrue(isSameBoard(defaultBoard, resultBoard));
	}
	
	@Test
	void reverseNoPiece_4() {
		checkedPositionList.add(new int[] {5,3});
		board.reverseSpecifiedDirection(checkedPositionList, 0, 0);
		
		int[][] resultBoard = board.getSquareList();
		
		assertTrue(isSameBoard(defaultBoard, resultBoard));
	}
	
	@Test
	void reverseNoPiece_5() {
		checkedPositionList.add(new int[] {5,3});
		board.reverseSpecifiedDirection(checkedPositionList, 0, 1);
		
		int[][] resultBoard = board.getSquareList();
		
		assertTrue(isSameBoard(defaultBoard, resultBoard));
	}
	
	@Test
	void reverseNoPiece_6() {
		checkedPositionList.add(new int[] {5,3});
		board.reverseSpecifiedDirection(checkedPositionList, 1, -1);
		
		int[][] resultBoard = board.getSquareList();
		
		assertTrue(isSameBoard(defaultBoard, resultBoard));
	}
	
	@Test
	void reverseNoPiece_7() {
		checkedPositionList.add(new int[] {5,3});
		board.reverseSpecifiedDirection(checkedPositionList, 1, 0);
		
		int[][] resultBoard = board.getSquareList();
		
		assertTrue(isSameBoard(defaultBoard, resultBoard));
	}
	
	@Test
	void reverseNoPiece_8() {
		checkedPositionList.add(new int[] {5,3});
		board.reverseSpecifiedDirection(checkedPositionList, 1, 1);
		
		int[][] resultBoard = board.getSquareList();
		
		assertTrue(isSameBoard(defaultBoard, resultBoard));
	}
	
	private boolean isSameBoard(int[][] expectedBoard, int[][] resultBoard) {
		board.display();
		for (int i = 0; i < 8; i++) {
			if(!(Arrays.equals(expectedBoard[i], resultBoard[i]))) {
				return false;
			}
		}
		return true;
	}

}
