package farm.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import farm.game.FarmItem;
import farm.game.GameEnvironment;

import java.awt.Font;

/**
 * This application window displays the animals for sale in the general store.
 * 
 * @author Megan Steenkamp
 * @version 1.0
 */
public class AnimalSaleScreen {

	private ApplicationManager manager;
	private GameEnvironment game;
	private JTextArea animalDescription;
	private JButton btnBuyAnimal;

	private JFrame window;
	int selectedAnimalId;

	/**
	 * Create the application.
	 * 
	 * @param application The application managing windows
	 * @param g           The game environment
	 */
	public AnimalSaleScreen(ApplicationManager application, GameEnvironment g) {
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
		manager.closeAnimalSaleScreen(this);
	}

	/**
	 * Set the animal description to be visible and display the description of the
	 * selected animal.
	 */
	public void displayDescription() {
		animalDescription.setVisible(true);
		animalDescription.setText(game.getFarmItemDescription(selectedAnimalId));
		btnBuyAnimal.setEnabled(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Animals for sale");
		window.setBounds(100, 100, 700, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);

		JButton btnReturnToGeneralStore = new JButton("Return to General Store");
		btnReturnToGeneralStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnReturnToGeneralStore.setBounds(24, 288, 240, 25);
		window.getContentPane().add(btnReturnToGeneralStore);

		JLabel lblInfo = new JLabel("Click on an animal to learn more about it:");
		lblInfo.setBounds(25, 12, 314, 15);
		window.getContentPane().add(lblInfo);

		animalDescription = new JTextArea();
		animalDescription.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 14));
		animalDescription.setVisible(false);
		animalDescription.setLineWrap(true);
		animalDescription.setWrapStyleWord(true);
		animalDescription.setEnabled(true);
		animalDescription.setEditable(false);
		animalDescription.setBounds(383, 53, 267, 208);
		window.getContentPane().add(animalDescription);

		btnBuyAnimal = new JButton("Buy animal");
		btnBuyAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FarmItem animal = game.processAnimalSale(selectedAnimalId);
				if (animal == null) {
					JOptionPane.showMessageDialog(window, game.getErrorMessage(), "Error", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(window, game.getSuccessMessage(animal), "Success",
							JOptionPane.INFORMATION_MESSAGE);
				}
				finishedWindow();
			}
		});
		btnBuyAnimal.setEnabled(false);
		btnBuyAnimal.setBounds(556, 288, 117, 25);
		window.getContentPane().add(btnBuyAnimal);

		JButton btnChicken = new JButton("Chicken");
		btnChicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedAnimalId = 13;
				displayDescription();
			}
		});
		btnChicken.setBounds(25, 53, 280, 57);
		window.getContentPane().add(btnChicken);

		JButton btnPig = new JButton("Pig");
		btnPig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedAnimalId = 14;
				displayDescription();
			}
		});
		btnPig.setBounds(25, 134, 280, 57);
		window.getContentPane().add(btnPig);

		JButton btnHorse = new JButton("Horse");
		btnHorse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedAnimalId = 15;
				displayDescription();
			}
		});
		btnHorse.setBounds(25, 210, 280, 57);
		window.getContentPane().add(btnHorse);
	}
}
