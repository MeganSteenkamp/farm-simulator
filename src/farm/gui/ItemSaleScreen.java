package farm.gui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import farm.game.FarmItem;
import farm.game.GameEnvironment;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This application window displays the items for sale in the general store.
 * 
 * @author Megan Steenkamp
 * @version 1.0
 */
public class ItemSaleScreen {

	private ApplicationManager manager;
	private GameEnvironment game;
	private JTextArea itemDescription;
	private JButton btnBuyItem;
	private int selectedItemId;

	private JFrame window;

	/**
	 * Create the application.
	 * 
	 * @param application The application managing windows
	 * @param g           The game environment
	 */
	public ItemSaleScreen(ApplicationManager application, GameEnvironment g) {
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
		manager.closeItemSaleScreen(this);
	}

	/**
	 * Display the description of the selected item in the GUI. Enable the button
	 * that confirms buying the item.
	 */
	public void displayDescription() {
		itemDescription.setVisible(true);
		if (selectedItemId < 4) {
			itemDescription.setText(getFarmItemDescription() + "\n" + game.getFarmItemDescription(selectedItemId));
		} else {
			itemDescription.setText(getFoodDescription() + "\n" + game.getFarmItemDescription(selectedItemId));
		}
		btnBuyItem.setEnabled(true);
	}

	/**
	 * Returns the description of the purpose of farm items, used on crops, in the
	 * game.
	 * 
	 * @return The description of what farming items are used for.
	 */
	public String getFarmItemDescription() {
		return "Farm items can be used to decrease the amount of time until your crop is ready for harvest.\n\n";
	}

	/**
	 * Returns the description of the purpose of food items in the game.
	 * 
	 * @return The description of what food items are used for.
	 */
	public String getFoodDescription() {
		return "Food is used to feed animals which incrases their health. The health of each animal at the end of a day"
				+ "contributes to a money bonus at the end of each day.\n\n";
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Farming items for sale");
		window.setBounds(100, 100, 700, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);

		JButton btnReturnToGeneralStore = new JButton("Return to General Store");
		btnReturnToGeneralStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnReturnToGeneralStore.setBounds(12, 288, 240, 25);
		window.getContentPane().add(btnReturnToGeneralStore);

		JLabel lblInfo = new JLabel("Select an item to learn more about it:");
		lblInfo.setBounds(25, 12, 314, 15);
		window.getContentPane().add(lblInfo);

		itemDescription = new JTextArea();
		itemDescription.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 14));
		itemDescription.setVisible(false);
		itemDescription.setLineWrap(true);
		itemDescription.setWrapStyleWord(true);
		itemDescription.setEnabled(true);
		itemDescription.setEditable(false);
		itemDescription.setBounds(400, 53, 267, 223);
		window.getContentPane().add(itemDescription);

		btnBuyItem = new JButton("Buy item");
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FarmItem item = game.processItemSale(selectedItemId);
				if (item == null) {
					JOptionPane.showMessageDialog(window, game.getErrorMessage(), "Error", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(window, game.getSuccessMessage(item), "Success",
							JOptionPane.INFORMATION_MESSAGE);
				}
				finishedWindow();
			}
		});
		btnBuyItem.setEnabled(false);
		btnBuyItem.setBounds(550, 288, 117, 25);
		window.getContentPane().add(btnBuyItem);

		JButton btnFertilizer = new JButton("Fertilizer");
		btnFertilizer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemId = 1;
				displayDescription();
			}
		});
		btnFertilizer.setBounds(28, 67, 146, 57);
		window.getContentPane().add(btnFertilizer);

		JButton btnCompost = new JButton("Compost");
		btnCompost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemId = 2;
				displayDescription();
			}
		});
		btnCompost.setBounds(28, 219, 146, 57);
		window.getContentPane().add(btnCompost);

		JButton btnHoe = new JButton("Hoe");
		btnHoe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemId = 3;
				displayDescription();
			}
		});
		btnHoe.setBounds(28, 144, 146, 57);
		window.getContentPane().add(btnHoe);

		JButton btnSteroid = new JButton("Steroids");
		btnSteroid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemId = 4;
				displayDescription();
			}
		});
		btnSteroid.setBounds(212, 144, 146, 57);
		window.getContentPane().add(btnSteroid);

		JButton btnGrain = new JButton("Grain");
		btnGrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemId = 5;
				displayDescription();
			}
		});
		btnGrain.setBounds(212, 67, 146, 57);
		window.getContentPane().add(btnGrain);

		JButton btnSilage = new JButton("Silage");
		btnSilage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedItemId = 6;
				displayDescription();
			}
		});
		btnSilage.setBounds(212, 219, 146, 57);
		window.getContentPane().add(btnSilage);

		JLabel lblFarmItems = new JLabel("Farm items:");
		lblFarmItems.setBounds(35, 40, 93, 15);
		window.getContentPane().add(lblFarmItems);

		JLabel lblAnimalFood = new JLabel("Animal food:");
		lblAnimalFood.setBounds(212, 40, 93, 15);
		window.getContentPane().add(lblAnimalFood);
	}
}
