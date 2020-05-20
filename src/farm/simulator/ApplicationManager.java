package farm.simulator;

/**
 * The ApplicationManager class manages the order of execution of GUI windows.
 * It instantiates the game environment and runs game until completion, passing
 * the state of the game between windows.
 * 
 * @author Megan Steenkamp
 * @version 1.0
 */
public class ApplicationManager {

	/**
	 * Launches the set up screen to initialize the game.
	 * 
	 * @param g The game environment
	 */
	public void launchSetupScreen(GameEnvironment g) {
		new SetupScreen(this, g);
	}

	/**
	 * Launches the main screen of the game.
	 * 
	 * @param g The game environment.
	 */
	public void launchMainScreen(GameEnvironment g) {
		new MainScreen(this, g);
	}

	/**
	 * Launches the screen belonging to the county general store.
	 * 
	 * @param g The game environment.
	 */
	public void launchGeneralStoreScreen(GameEnvironment g) {
		new GeneralStoreScreen(this, g);
	}

	/**
	 * Launches the screen where a player can pick actions for the farmer to
	 * perform.
	 * 
	 * @param g The game environment.
	 */
	public void launchFarmerActionScreen(GameEnvironment g) {
		new FarmerActionScreen(this, g);
	}

	/**
	 * Launches the screen where a player can purchase animals.
	 * 
	 * @param g The game environment.
	 */
	public void launchAnimalSaleScreen(GameEnvironment g) {
		new AnimalSaleScreen(this, g);
	}

	/**
	 * Launches the screen where a player can purchase crops.
	 * 
	 * @param g The game environment.
	 */
	public void launchCropSaleScreen(GameEnvironment g) {
		new CropSaleScreen(this, g);
	}

	/**
	 * Launches the screen where a player can purchase farming items.
	 * 
	 * @param g The game environment.
	 */
	public void launchItemSaleScreen(GameEnvironment g) {
		new ItemSaleScreen(this, g);
	}

	/**
	 * Launches the final screen displaying the results of the game.
	 * 
	 * @param g The game environment.
	 */
	public void launchFinalScreen(GameEnvironment g) {
		new FinalScreen(this, g);
	}

	/**
	 * Closes the main screen and launches a new screen, depending on what is passed
	 * in as the next screen.
	 * 
	 * @param mainWindow The main window that is currently open.
	 * @param nextScreen A string declaring the next screen to be opened.
	 */
	public void closeMainScreen(MainScreen mainWindow, String nextScreen) {
		GameEnvironment g = mainWindow.closeWindow();
		if (nextScreen.equals("General Store")) {
			launchGeneralStoreScreen(g);
		} else if (nextScreen.equals("Final")) {
			launchFinalScreen(g);
		} else {
			launchFarmerActionScreen(g);
		}
	}

	/**
	 * Closes the Setup screen once the game has been initialized.
	 * 
	 * @param setupWindow The setup window.
	 */
	public void closeSetupScreen(SetupScreen setupWindow) {
		GameEnvironment g = setupWindow.closeWindow();
		launchMainScreen(g);
	}

	/**
	 * Closes the screen where a player can pick actions for the farmer to perform.
	 * 
	 * @param farmerActionWindow The window where a player can pick actions for a
	 *                           farmer.
	 */
	public void closeFarmerActionScreen(FarmerActionScreen farmerActionWindow) {
		GameEnvironment g = farmerActionWindow.closeWindow();
		launchMainScreen(g);

	}

	/**
	 * Closes the screen associated with the general store.
	 * 
	 * @param generalStoreWindow The current screen that represents the general
	 *                           store.
	 * @param nextScreen         The next screen to be opened depending on the
	 *                           player's choice of action.
	 */
	public void closeGeneralStoreScreen(GeneralStoreScreen generalStoreWindow, String nextScreen) {
		GameEnvironment g = generalStoreWindow.closeWindow();
		if (nextScreen.equals("Animals")) {
			launchAnimalSaleScreen(g);
		} else if (nextScreen.equals("Crops")) {
			launchCropSaleScreen(g);
		} else if (nextScreen.equals("Items")) {
			launchItemSaleScreen(g);
		} else {
			launchMainScreen(g);
		}
	}

	/**
	 * Closes the screen associated with the purchase of animals.
	 * 
	 * @param animalSaleWindow The current window to be closed.
	 */
	public void closeAnimalSaleScreen(AnimalSaleScreen animalSaleWindow) {
		GameEnvironment g = animalSaleWindow.closeWindow();
		launchGeneralStoreScreen(g);
	}

	/**
	 * Closes the screen associated with the purchase of farming items.
	 * 
	 * @param itemSaleWindow The current window to be closed.
	 */
	public void closeItemSaleScreen(ItemSaleScreen itemSaleWindow) {
		GameEnvironment g = itemSaleWindow.closeWindow();
		launchGeneralStoreScreen(g);
	}

	/**
	 * Closes the screen associated with the purchase of crops.
	 * 
	 * @param cropSaleWindow The current window to be closed.
	 */
	public void closeCropSaleScreen(CropSaleScreen cropSaleWindow) {
		GameEnvironment g = cropSaleWindow.closeWindow();
		launchGeneralStoreScreen(g);
	}

	/**
	 * Closes the final screen, finishing the game.
	 * 
	 * @param finalWindow The current window to be closed.
	 */
	public void closeFinalScreen(FinalScreen finalWindow) {
		finalWindow.closeWindow();
	}

	/**
	 * Main function to access the farm simulator game. This instantiates the game
	 * and controls the GUI windows displayed to a user.
	 * 
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		ApplicationManager manager = new ApplicationManager();
		GameEnvironment g = new GameEnvironment();
		manager.launchSetupScreen(g);
	}
}
