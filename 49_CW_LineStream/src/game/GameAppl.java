package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GameAppl
{
	private static List<Move> moves = new ArrayList<>();
//	private static int count = 0;
	private static Game game;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) 
	{
		while(startGame()) {}
	}

	private static boolean startGame() 
	{
		game = new Game();
		moves.clear();
		String answer = "";
		try
		{
			runGame();
			System.out.println("Do you want to start new game? Y/N");
			answer = reader.readLine();
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		return answer.equalsIgnoreCase("Y");
	}

	private static void runGame() throws IOException
	{
		while(true)
		{
			System.out.println("Enter guess number 4 unrepeated digits from 0 to 9 without spaces");
			String res = reader.readLine();
			Integer[] bullCows = game.getMoveResult(res);
			nextMove(res, bullCows);
			moves.forEach(System.out::println);
			if(bullCows[0] == 4)
			{
				finishGame();
				break;
			}
		}
	}

	private static void finishGame() throws IOException
	{
		System.out.println("!!!Congradulations you have guessed number for " + moves.size() + " moves!!!!");
		try(PrintWriter writer = new PrintWriter(getFileName()))
		{
			moves.forEach(writer::println);
		}
	}

	private static String getFileName() throws IOException
	{
		System.out.println("Enter path to save file or Enter to save in current directory");
		String path = reader.readLine();
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm");
		String fileName = time.format(form) + "_" + moves.size();
		return path.isBlank() ? fileName : path + File.separator + fileName;
	}
//(example: 2020-12-31_23_59_1000000) 
	
	private static void nextMove(String res, Integer[] bullCows)
	{
		Move move = new Move(bullCows, res);
		moves.add(move);		
	}

}
