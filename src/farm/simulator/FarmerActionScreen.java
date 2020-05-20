package farm.simulator;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;

/**
 * This application window displays the available actions for a farmer to
 * perform.
 * 
 * @author Megan Steenkamp
 * @version 1.0
 */
public class FarmerActionScreen {

	private ApplicationManager manager;
	private GameEnvironment game;
	private JFrame window;

	// Buttons
	private JButton btnTendToCrops;
	private JButton btnFeedAnimals;
	private JButton btnPlayWithAnimals;
	private JButton btnHarvestCrops;
	private JButton btnTendToFarmland;

	// Items for actions
	ArrayList<FarmItem> food;
	ArrayList<FarmItem> tools;
	ArrayList<FarmItem> crops;
	private JList<String> foodList;
	private JLabel lblSelectFood;
	private JLabel lblSelectCrop;
	private JList<String> cropList;
	private JLabel lblSelectAnItem;
	private JList<String> itemList;
	private JButton btnConfirmFood;
	private JButton btnConfirmTending;

	/**
	 * Create the application.
	 * 
	 * @param application The application managing windows
	 * @param g           The game environment
	 */
	public FarmerActionScreen(ApplicationManager application, GameEnvironment g) {
		game = g;
		manager = application;
		initialize();
		window.setVisible(true);
	}

	/**
	 * Close the window, returning the game environment to the manager.
	 * 
	 * @return The game environment.
	 */
	public GameEnvironment closeWindow() {
		window.dispose();
		return game;
	}

	/**
	 * Calls the window manager to close this screen.
	 */
	public void finishedWindow() {
		manager.closeFarmerActionScreen(this);
	}

	/**
	 * Calls the game environment to implement feeding animals with food selected by
	 * the player. On completion of the action, an information message will show the
	 * user the status of their animals.
	 * 
	 * @param selectedFoodId The type ID associated with the selected food.
	 */
	public void feedAnimals(int selectedFoodId) {
		String outcome = game.feedAnimals(selectedFoodId);
		JOptionPane.showMessageDialog(window, outcome, "Action complete", JOptionPane.INFORMATION_MESSAGE);
		finishedWindow();
	}

	/**
	 * Used if a user wants to tend to crops. Makes the crop and item selection
	 * lists visible so that a user can pick their crop and item of choice. Buttons
	 * to confirm actions set to visible.
	 */
	public void displayTendToCrops() {
		lblSelectCrop.setVisible(true);
		cropList.setVisible(true);
		lblSelectAnItem.setVisible(true);
		itemList.setVisible(true);
		btnConfirmTending.setVisible(true);
		btnConfirmTending.setEnabled(false);
	}

	/**
	 * Used if a user wants to feed animals. Makes the list of food and confirmation
	 * button visible for a user to pick the food item to use.
	 */
	public void displayFeedAnimals() {
		// Get user to select food item
		lblSelectFood.setVisible(true);
		foodList.setVisible(true);
		btnConfirmFood.setVisible(true);
		btnConfirmFood.setEnabled(false);
	}

	/**
	 * Hides all specific lists on the GUI involved with a farming action.
	 */
	public void hideLists() {
		lblSelectFood.setVisible(false);
		foodList.setVisible(false);
		lblSelectCrop.setVisible(false);
		cropList.setVisible(false);
		lblSelectAnItem.setVisible(false);
		itemList.setVisible(false);
		btnConfirmFood.setVisible(false);
		btnConfirmTending.setVisible(false);
	}

	/**
	 * Resets all button background colors to their default color.
	 */
	public void revertButtonColours() {
		btnTendToCrops.setBackground(null);
		btnFeedAnimals.setBackground(null);
		btnPlayWithAnimals.setBackground(null);
		btnHarvestCrops.setBackground(null);
		btnTendToFarmland.setBackground(null);
	}

	/**
	 * Enables the button to perform the tending to crops action once a crop and
	 * item have been selected.
	 */
	public void confirmTending() {
		if ((cropList.getSelectedIndex() != -1) && (itemList.getSelectedIndex() != -1)) {
			btnConfirmTending.setEnabled(true);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Farmer Actions");
		window.setBounds(100, 100, 700, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);

		JButton btnReturnToMain = new JButton("Return to main screen");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnReturnToMain.setBounds(24, 438, 213, 25);
		window.getContentPane().add(btnReturnToMain);

		btnTendToCrops = new JButton("Tend to crops");
		btnTendToCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideLists();
				revertButtonColours();
				btnTendToCrops.setBackground(Color.GREEN);
				if (JOptionPane.showConfirmDialog(window, game.getCropTendingDescription(), "Decide Action",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					displayTendToCrops();
				}
			}
		});
		if (!game.canTendToCrops()) {
			btnTendToCrops.setEnabled(false);
		}
		btnTendToCrops.setBounds(24, 27, 240, 59);
		window.getContentPane().add(btnTendToCrops);

		btnFeedAnimals = new JButton("Feed animals");
		btnFeedAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideLists();
				revertButtonColours();
				btnFeedAnimals.setBackground(Color.GREEN);
				if (JOptionPane.showConfirmDialog(window, game.getFeedingAnimalsDescription(), "Decide Action",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					displayFeedAnimals();
				}
			}
		});
		if (!game.canFeedAnimals()) {
			btnFeedAnimals.setEnabled(false);
		}
		btnFeedAnimals.setBounds(24, 105, 240, 59);
		window.getContentPane().add(btnFeedAnimals);

		btnPlayWithAnimals = new JButton("Play with animals");
		btnPlayWithAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideLists();
				revertButtonColours();
				btnPlayWithAnimals.setBackground(Color.GREEN);
				if (JOptionPane.showConfirmDialog(window, game.getPlayWithAnimalsDescription(), "Decide Action",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					String outcome = game.playWithAnimals();
					JOptionPane.showMessageDialog(window, outcome, "Action complete", JOptionPane.INFORMATION_MESSAGE);
					finishedWindow();
				}
			}
		});
		if (!game.canPlayWithAnimals()) {
			btnPlayWithAnimals.setEnabled(false);
		}
		btnPlayWithAnimals.setBounds(24, 190, 240, 59);
		window.getContentPane().add(btnPlayWithAnimals);

		btnHarvestCrops = new JButton("Harvest crops");
		btnHarvestCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideLists();
				revertButtonColours();
				btnHarvestCrops.setBackground(Color.GREEN);
				if (JOptionPane.showConfirmDialog(window, game.getHarvestCropsDescription(), "Decide Action",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					btnHarvestCrops.setBackground(Color.GREEN);
					String outcome = game.harvestCrops();
					JOptionPane.showMessageDialog(window, outcome, "Action complete", JOptionPane.INFORMATION_MESSAGE);
					finishedWindow();
				}
			}
		});
		if (!game.canHarvestCrops()) {
			btnHarvestCrops.setEnabled(false);
		}
		btnHarvestCrops.setBounds(24, 277, 240, 59);
		window.getContentPane().add(btnHarvestCrops);

		btnTendToFarmland = new JButton("Tend to farm land");
		btnTendToFarmland.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hideLists();
				revertButtonColours();
				btnTendToFarmland.setBackground(Color.GREEN);
				if (JOptionPane.showConfirmDialog(window, game.getTendToFarmLandDescription(), "Decide Action",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					btnTendToFarmland.setBackground(Color.GREEN);
					String outcome = game.tendToFarmland();
					JOptionPane.showMessageDialog(window, outcome, "Action complete", JOptionPane.INFORMATION_MESSAGE);
					finishedWindow();
				}
			}
		});
		btnTendToFarmland.setBounds(24, 356, 240, 59);
		window.getContentPane().add(btnTendToFarmland);

		// Initialize and hide lists that might be needed to pick items
		// Food list for feeding animals
		DefaultListModel<String> listModelFood = new DefaultListModel<String>();
		food = game.getFoodItems();
		for (FarmItem f : food) {
			listModelFood.addElement(
					((Item) f).getName() + ", Bonus health: " + ((Item) f).getAnimalHealthFactor() + " point(s)");
		}
		foodList = new JList<String>(listModelFood);
		foodList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (foodList.getValueIsAdjusting()) {
					btnConfirmFood.setEnabled(true);
				}
			}
		});
		foodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		foodList.setFont(new Font("Dialog", Font.BOLD, 14));
		foodList.setBounds(320, 102, 316, 313);
		foodList.setVisible(false);
		window.getContentPane().add(foodList);

		lblSelectFood = new JLabel("Select a food item to use:");
		lblSelectFood.setBounds(320, 71, 240, 15);
		lblSelectFood.setVisible(false);
		window.getContentPane().add(lblSelectFood);

		// List of crops that can be tended to
		lblSelectCrop = new JLabel("Select a crop variety:");
		lblSelectCrop.setBounds(315, 71, 310, 15);
		lblSelectCrop.setVisible(false);
		window.getContentPane().add(lblSelectCrop);

		DefaultListModel<String> listModelCrop = new DefaultListModel<String>();
		// Change to hash set and back to array to get unique crop types
		HashSet<FarmItem> uniqueCrops = new HashSet<FarmItem>(game.getCrops());
		crops = new ArrayList<FarmItem>(uniqueCrops);
		for (FarmItem c : crops) {
			listModelCrop.addElement(
					((Crop) c).getName() + ", Time until harvest: " + ((Crop) c).getTimeUntilHarvest() + " day(s)");
		}
		cropList = new JList<String>(listModelCrop);
		cropList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (cropList.getValueIsAdjusting()) {
					confirmTending();
				}
			}
		});
		cropList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cropList.setFont(new Font("Dialog", Font.BOLD, 14));
		cropList.setBounds(315, 103, 337, 126);
		cropList.setVisible(false);
		window.getContentPane().add(cropList);

		// List of items for use
		lblSelectAnItem = new JLabel("Select an item to use:");
		lblSelectAnItem.setBounds(315, 241, 310, 15);
		lblSelectAnItem.setVisible(false);
		window.getContentPane().add(lblSelectAnItem);

		DefaultListModel<String> listModelTools = new DefaultListModel<String>();
		tools = game.getToolItems();
		listModelTools.addElement("Water, Added crop growth: -1 day(s)");
		for (FarmItem i : tools) {
			listModelTools.addElement(
					((Item) i).getName() + ", Added crop growth: " + ((Item) i).getCropGrowthFactor() + " day(s)");
		}
		itemList = new JList<String>(listModelTools);
		itemList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (itemList.getValueIsAdjusting()) {
					confirmTending();
				}
			}
		});
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemList.setFont(new Font("Dialog", Font.BOLD, 14));
		itemList.setBounds(315, 277, 337, 141);
		itemList.setVisible(false);
		window.getContentPane().add(itemList);

		btnConfirmFood = new JButton("Confirm Selection");
		btnConfirmFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(window,
						"Would you like to feed the animals with this item?\n\n"
								+ food.get(foodList.getSelectedIndex()),
						"Confirm Action", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					// Get food item
					feedAnimals(food.get(foodList.getSelectedIndex()).getId());
				}
			}
		});
		btnConfirmFood.setBounds(480, 438, 172, 25);
		btnConfirmFood.setVisible(false);
		window.getContentPane().add(btnConfirmFood);

		btnConfirmTending = new JButton("Confirm Selection");
		btnConfirmTending.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crop crop = (Crop) crops.get(cropList.getSelectedIndex());
				if (itemList.getSelectedIndex() == 0) {
					if (JOptionPane.showConfirmDialog(
							window, "Please confirm your action:\nCrop to tend to: " + crop.getName()
									+ "\nItem used: Water" + "\n\n",
							"Confirm Action", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

						// Perform action
						String outcome = game.tendToCrops(crop.getId());
						JOptionPane.showMessageDialog(window, outcome, "Action complete",
								JOptionPane.INFORMATION_MESSAGE);
						finishedWindow();
					}
				} else {
					Item item = (Item) tools.get(itemList.getSelectedIndex() - 1);
					if (JOptionPane.showConfirmDialog(window,
							"Please confirm your action:\nCrop to tend to: " + crop.getName() + "\nItem used: "
									+ item.getName() + "\n\n",
							"Confirm Action", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

						// Perform action
						String outcome = game.tendToCrops(crop.getId(), item.getId());
						JOptionPane.showMessageDialog(window, outcome, "Action complete",
								JOptionPane.INFORMATION_MESSAGE);
						finishedWindow();
					}
				}
			}
		});
		btnConfirmTending.setBounds(480, 438, 172, 25);
		btnConfirmTending.setVisible(false);
		window.getContentPane().add(btnConfirmTending);
	}
}
