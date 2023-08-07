import telran.view.InputOutput;
import telran.view.Item;

public class ThreadsRaceItem implements Item {
	protected InputOutput inOut;
	protected ThreadsGame game;

	public ThreadsRaceItem(InputOutput inOut, ThreadsGame game) {
		super();
		this.inOut = inOut;
		this.game = game;
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

//		game = new ThreadsGame(distance);
		game.start();
//		inOut.outputLine(game);
	}
}
