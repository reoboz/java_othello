package java_portfolio_othello;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidateSpecifiedPositionTest {
	private Board board;

	private int[][] situationBoard = {
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 2, 0, 0, 2, 0, 0, 0 },
			{ 0, 1, 1, 1, 2, 0, 0, 0 },
			{ 0, 0, 0, 2, 2, 1, 0, 0 },
			{ 0, 0, 2, 2, 2, 2, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
	};
	
	private int[][] situationBoard_2 = {
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 2, 1, 0, 0, 0, 0 },
			{ 0, 1, 2, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 2, 2, 2, 0, 0 },
			{ 0, 0, 2, 1, 2, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
	};

	@BeforeEach
	void setup() {
		Game.playerTurn = 1;
	}
	/* A1に置けなくてなんで？と思って書いたテスト。
	 * 原因は左上のマスは0,0を指定するはずなのにisInRangeで0以下を盤の外としていた。 */
	@Test
	void putPieceWithoutError() {
		board = new Board(situationBoard);
		assertTrue(board.validateSpecifiedPosition(new int[] {0,0}));
	}
	
	/* G5に置けちゃってなんで？と思って書いたテスト。
	 * 原因はcheckSpecifiedDirectionで左上にある相手のコマを見つけた後、
	 * 何も置かれていないマスを飛ばしてその次の自分のコマを見て挟めるというロジックになっていた */
	@Test
	void putPieceReturnsFalseOnInappropriatePosition() {
		board = new Board(situationBoard_2);
		assertFalse(board.validateSpecifiedPosition(new int[] {6,4}));
	}
}


