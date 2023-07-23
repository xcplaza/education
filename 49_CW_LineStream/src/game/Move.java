package game;

public class Move {
	public Integer bullsCows[];
	public String guessNumber;

	public Move(Integer[] bullsCows, String guessNumber) {
		super();
		this.bullsCows = bullsCows;
		this.guessNumber = guessNumber;
	}

	@Override
	public String toString() {
		return String.format("guess number:%s, bulls:%d, cows:%d", guessNumber, bullsCows[0], bullsCows[1]);
	}
}