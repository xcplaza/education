package game;

import java.util.ArrayList;
import java.util.Random;

public class Game
{
	ArrayList<Character> randomNumber = new ArrayList<>();
	
	public Game()
	{
		new Random().ints(0, 10).distinct().limit(4).mapToObj(num -> (char)('0'+num))
			.forEach(randomNumber::add);
		System.out.println(randomNumber);
	}
	
	public Integer[] getMoveResult(String move)
	{
		char[] temp = move.toCharArray();
		int limit = temp.length < 4 ? temp.length : 4;
		Integer bulls = 0;
		Integer cows = 0;
		for(int i=0; i<limit; i++)
		{
			int index = randomNumber.indexOf(temp[i]);
			if(index >= 0)
			{
				if(index == i)
					bulls++;
				else
					cows++;
			}
		}
		return new Integer[] {bulls, cows};
	}
}
