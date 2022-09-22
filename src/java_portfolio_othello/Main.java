package java_portfolio_othello;

public class Main {

	public static void main(String[] args) {
		while(true) {
			Game game = new Game();
			game.play();
			game.checkRestart();
		}
	}

}
