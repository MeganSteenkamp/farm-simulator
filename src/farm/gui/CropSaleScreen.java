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
 * This application window displays the crops for sale in the general store.
 * 
 * @author Megan Steenkamp
 * @version 1.0
 */
public class CropSaleScreen {

	private ApplicationManager manager;
	private GameEnvironment game;
	private JTextArea cropDescription;
	private JButton btnBuyCrop;
	private int selectedCropId;

	private JFrame window;

	/**
	 * Create the application.
	 * 
	 * @param application The application managing windows
	 * @param g           The game environment
	 */
	public CropSaleScreen(ApplicationManager application, GameEnvironment g) {
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
		manager.closeCropSaleScreen(this);
	}

	/**
	 * Set the crop description to be visible and display the description of the
	 * selected crop.
	 */
	public void displayDescription() {
		cropDescription.setVisible(true);
		cropDescription.setText(game.getFarmItemDescription(selectedCropId));
		btnBuyCrop.setEnabled(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Crops for sale");
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

		JLabel lblInfo = new JLabel("Click on a crop type to learn more about it:");
		lblInfo.setBounds(25, 12, 314, 15);
		window.getContentPane().add(lblInfo);

		cropDescription = new JTextArea();
		cropDescription.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 14));
		cropDescription.setVisible(false);
		cropDescription.setLineWrap(true);
		cropDescription.setWrapStyleWord(true);
		cropDescription.setEnabled(true);
		cropDescription.setEditable(false);
		cropDescription.setBounds(400, 53, 267, 223);
		window.getContentPane().add(cropDescription);

		btnBuyCrop = new JButton("Buy crop");
		btnBuyCrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FarmItem crop = game.processCropSale(selectedCropId);
				if (crop == null) {
					JOptionPane.showMessageDialog(window, game.getErrorMessage(), "Error", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(window, game.getSuccessMessage(crop), "Success",
							JOptionPane.INFORMATION_MESSAGE);
				}
				finishedWindow();
			}
		});
		btnBuyCrop.setEnabled(false);
		btnBuyCrop.setBounds(550, 288, 117, 25);
		window.getContentPane().add(btnBuyCrop);

		JButton btnRice = new JButton("Rice");
		btnRice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedCropId = 7;
				displayDescription();
			}
		});
		btnRice.setBounds(25, 53, 146, 57);
		window.getContentPane().add(btnRice);

		JButton btnWheat = new JButton("Wheat");
		btnWheat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedCropId = 8;
				displayDescription();
			}
		});
		btnWheat.setBounds(209, 53, 146, 57);
		window.getContentPane().add(btnWheat);

		JButton btnCotton = new JButton("Cotton");
		btnCotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedCropId = 9;
				displayDescription();
			}
		});
		btnCotton.setBounds(25, 130, 146, 57);
		window.getContentPane().add(btnCotton);

		JButton btnCoffee = new JButton("Coffee");
		btnCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedCropId = 10;
				displayDescription();
			}
		});
		btnCoffee.setBounds(209, 130, 146, 57);
		window.getContentPane().add(btnCoffee);

		JButton btnOlive = new JButton("Olive");
		btnOlive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedCropId = 11;
				displayDescription();
			}
		});
		btnOlive.setBounds(25, 205, 146, 57);
		window.getContentPane().add(btnOlive);

		JButton btnAvocado = new JButton("Avocado");
		btnAvocado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedCropId = 12;
				displayDescription();
			}
		});
		btnAvocado.setBounds(209, 205, 146, 57);
		window.getContentPane().add(btnAvocado);
	}
}
