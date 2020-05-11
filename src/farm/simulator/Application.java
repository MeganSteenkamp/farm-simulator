package farm.simulator;

/**
 * This class instantiates the game environment and runs the main loop.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Application {
	
	/**
	 * Main function to access the farm simulator game.
	 * @param args
	 */
	public static void main(String[] args) {
		GameEnvironment g = new GameEnvironment();
		g.run();
	}

}
