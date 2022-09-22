package java_portfolio_othello;

public class Game {
	Board board;
	Input input;
	Computer computer;
	Boolean inGame;
	int[] matchResult = new int[3];
	static final int CPU = 2;
	static int playerTurn;
	
	public Game() {
		this.board = new Board();
		this.input = new Input();
		this.computer = new Computer(board);
	}
	
	public void play() {
		inGame = true;
		playerTurn = 1;
		while (inGame) {
			playTurn();
			judgeWinner();
		}
	}
	
	private void playTurn() {
		board.display();
		System.out.println("Player " + playerTurn + "の番です");
		if (playerTurn == CPU) {
			computer.putOnRandomPlace();
			endTurn();
			return;
		}
		
		while(true) {
			int[] position = input.receivePosition();
			if(board.putPiece(position)) {
				endTurn();
				break;
			};
		}
	}
	
	public void endTurn() {
		playerTurn = playerTurn % 2 + 1;
	}
	
	private void judgeWinner() {
		int[] pieceList = board.countPieces();
		if (pieceList[0] == 0 || pieceList[1] == 0 || board.isBoardFilled()) {
			inGame = false;
		}
		if (inGame) {
			return;
		}
		if (pieceList[0] > pieceList[1]) {
			System.out.println("Player 1の勝利!" + pieceList[0] + " vs " + pieceList[1]);
			matchResult[0] += 1;
		} else if (pieceList[0] < pieceList[1]) {
			System.out.println("Player 2の勝利!" + pieceList[1] + " vs " + pieceList[0]);
			matchResult[1] += 1;
		} else if (pieceList[0] == pieceList[1]) {
			System.out.println("引き分け！");
		}
		System.out.println(getMatchResult());
	}
	
	private String getMatchResult() {
		return ("戦績:" + matchResult[0] + "勝 " + matchResult[1] + "敗 " + matchResult[2] + "分");
	}
	
	public boolean checkRestart() {
		return input.playAnotherGame();
	}
}
