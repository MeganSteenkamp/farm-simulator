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

	public void launchSetupScreen(GameEnvironment g) {
		SetupScreen setupWindow = new SetupScreen(this, g);
	}

	public void launchGeneralStoreScreen(GameEnvironment g) {
		GeneralStoreScreen generalStoreWindow = new GeneralStoreScreen(this, g);
	}

	public void launchFarmerActionScreen(GameEnvironment g) {
		FarmerActionScreen farmerActionWindow = new FarmerActionScreen(this, g);
	}

	public void launchAnimalSaleScreen(GameEnvironment g) {
		AnimalSaleScreen animalSaleWindow = new AnimalSaleScreen(this, g);
	}

	public void launchCropSaleScreen(GameEnvironment g) {
		CropSaleScreen cropSaleWindow = new CropSaleScreen(this, g);
	}

	public void launchItemSaleScreen(GameEnvironment g) {
		ItemSaleScreen itemSaleWindow = new ItemSaleScreen(this, g);
	}

	public void closeMainScreen(MainScreen mainWindow, String nextScreen) {
		GameEnvironment g = mainWindow.closeWindow();
		if (nextScreen.equals("General Store")) {
			launchGeneralStoreScreen(g);
		} else {
			launchFarmerActionScreen(g);
		}
	}

	public void closeSetupScreen(SetupScreen setupWindow) {
		GameEnvironment g = setupWindow.closeWindow();
		launchMainScreen(g);
	}

	public void closeFarmerActionScreen(FarmerActionScreen farmerActionWindow) {
		GameEnvironment g = farmerActionWindow.closeWindow();
		launchMainScreen(g);

	}

	public void closeGeneralStoreScreen(GeneralStoreScreen generalStoreWindow, String nextScreen) {
		GameEnvironment g = generalStoreWindow.closeWindow();
		if (nextScreen.equals("Animals")) {
			launchAnimalSaleScreen(g);
		}
		else if (nextScreen.equals("Crops")) {
			launchCropSaleScreen(g);
		}
		else if (nextScreen.equals("Items")) {
			launchItemSaleScreen(g);
		} else {
			launchMainScreen(g);
		}
	}

	public void closeAnimalSaleScreen(AnimalSaleScreen animalSaleWindow) {
		GameEnvironment g = animalSaleWindow.closeWindow();
		launchGeneralStoreScreen(g);
	}

	public void closeItemSaleScreen(ItemSaleScreen itemSaleWindow) {
		GameEnvironment g = itemSaleWindow.closeWindow();
		launchGeneralStoreScreen(g);
	}

	public void closeCropSaleScreen(CropSaleScreen cropSaleWindow) {
		GameEnvironment g = cropSaleWindow.closeWindow();
		launchGeneralStoreScreen(g);
	}

	/**
	 * Main function to access the farm simulator game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationManager manager = new ApplicationManager();
		GameEnvironment g = new GameEnvironment();
		manager.launchSetupScreen(g);
	}
}
