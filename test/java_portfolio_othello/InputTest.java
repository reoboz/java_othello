package java_portfolio_othello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputTest {
	private Input input;
	
	@BeforeEach
	void setup() {
		input = new Input();	
	}

	/* validatePositionの正常パターンはA~H + 1~8 */
	@Test
	void getNumericPositionDeniesTwoDigitsPosition() {
		int[] numericPosition = input.getNumericPosition("A12");
		assertTrue(Arrays.equals(numericPosition,new int[] {-1,-1}));
	}
	
	@Test
	void getNumericPositionConvertsA1to00() {
		int[] numericPosition = input.getNumericPosition("A1");
		assertTrue(Arrays.equals(numericPosition,new int[] {0,0}));
	}
	
	
	@Test
	void getYPositionAnswersSmallerNumber() {
		int y = input.getYPosition('6');
		assertTrue(y == 5);
	}

}
