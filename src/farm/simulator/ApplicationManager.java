package farm.simulator;

/**
 * This class instantiates the game environment and runs the main loop.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class ApplicationManager {
	
	public void launchMainScreen(GameEnvironment g) {
		MainScreen mainWindow = new MainScreen(this, g);
	}
	
	public void closeMainScreen(MainScreen mainWindow) {
		GameEnvironment g = mainWindow.closeWindow();
	}
	
	public void launchSetupScreen(GameEnvironment g) {
		SetupScreen setupWindow = new SetupScreen(this, g);
	}
	
	public void closeSetupScreen(SetupScreen setupWindow) {
		GameEnvironment g = setupWindow.closeWindow();
		launchMainScreen(g);
	}

	/**
	 * Main function to access the farm simulator game.
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationManager manager = new ApplicationManager();
		GameEnvironment g = new GameEnvironment();
		manager.launchSetupScreen(g);
		
		//GameEnvironment g = new GameEnvironment();
		//g.run();
	}
}
