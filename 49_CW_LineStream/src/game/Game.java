package game;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	ArrayList<Character> randomNumber = new ArrayList<>();

	public Game() {
		new Random().ints(0, 10).distinct().limit(4).mapToObj(num -> (char) ('0' + num)).forEach(randomNumber::add);
	}

	public Integer[] getMoveResult(String move) {
		char[] temp = move.toCharArray();

		return null;

	}

}
