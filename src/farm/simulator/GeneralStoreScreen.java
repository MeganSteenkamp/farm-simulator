package farm.simulator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GeneralStoreScreen {

	private ApplicationManager manager;
	private GameEnvironment game;

	private JFrame window;

	/**
	 * Create the application.
	 */
	public GeneralStoreScreen(ApplicationManager application, GameEnvironment g) {
		game = g;
		manager = application;
		initialize();
		window.setVisible(true);
	}

	public GameEnvironment closeWindow() {
		window.dispose();
		return game;
	}

	public void finishedWindow(String nextScreen) {
		manager.closeGeneralStoreScreen(this, nextScreen);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("General Store");
		window.setBounds(100, 100, 700, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblInfo = new JLabel("Select an action:");
		lblInfo.setBounds(31, 21, 314, 15);
		window.getContentPane().add(lblInfo);
		
		JTextArea txtCropWarning = new JTextArea();
		txtCropWarning.setEditable(false);
		txtCropWarning.setWrapStyleWord(true);
		txtCropWarning.setLineWrap(true);
		txtCropWarning.setVisible(false);
		txtCropWarning.setText("*You are unable to purchase crops at this time as your plots are full");
		txtCropWarning.setBounds(381, 400, 307, 34);
		window.getContentPane().add(txtCropWarning);
		
		JButton btnReturnToMain = new JButton("Return to main screen");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("");
			}
		});
		btnReturnToMain.setBounds(12, 438, 240, 25);
		window.getContentPane().add(btnReturnToMain);
		
		JButton btnViewMyItems = new JButton("View my farming items");
		btnViewMyItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(window, game.displayCurrentlyOwnedItems(), "Currently owned items",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnViewMyItems.setBounds(24, 48, 304, 159);
		window.getContentPane().add(btnViewMyItems);
		
		JButton btnBuyAnimals = new JButton("Buy animals");
		btnBuyAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Animals");
			}
		});
		btnBuyAnimals.setBounds(371, 48, 304, 159);
		window.getContentPane().add(btnBuyAnimals);
		
		JButton btnBuyCrops = new JButton("Buy crops");
		btnBuyCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Crops");
			}
		});
		if (game.getNumAvailableCrops() == 0) {
			btnBuyCrops.setEnabled(false);
			txtCropWarning.setVisible(true);
		}
		btnBuyCrops.setBounds(371, 238, 304, 159);
		window.getContentPane().add(btnBuyCrops);
		
		JButton btnBuyItems = new JButton("Buy farming items");
		btnBuyItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Items");
			}
		});
		btnBuyItems.setBounds(24, 238, 311, 159);
		window.getContentPane().add(btnBuyItems);
	}
}
