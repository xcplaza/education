import telran.view.InputOutput;
import telran.view.Item;

public class ThreadsRaceItem implements Item {
	protected InputOutput inOut;
	protected ThreadsGame threadsGame;

	public ThreadsRaceItem(InputOutput inOut, ThreadsGame threadsGame) {
		super();
		this.inOut = inOut;
		this.threadsGame = threadsGame;
	}

	@Override
	public String displayName() {
		return "Game run";
	}

	@Override
	public void perform() {
		Integer distance = inOut.inputInteger("Enter distance ");
		if (distance == null)
			return;
		
		ThreadsGame game = new ThreadsGame(distance);
		game.start();
//		inOut.outputLine(game);
	}
}
