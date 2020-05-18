package farm.simulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JButton btnReturnToMain = new JButton("Return to main screen");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("");
			}
		});
		btnReturnToMain.setBounds(12, 438, 240, 25);
		window.getContentPane().add(btnReturnToMain);
		
		JButton btnViewMyItems = new JButton("View my items");
		btnViewMyItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(window, game.displayCurrentlyOwnedItems(), "Currently owned items",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnViewMyItems.setBounds(31, 32, 202, 25);
		window.getContentPane().add(btnViewMyItems);
		
		JButton btnBuyAnimals = new JButton("Buy animals");
		btnBuyAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Animals");
			}
		});
		btnBuyAnimals.setBounds(64, 94, 188, 25);
		window.getContentPane().add(btnBuyAnimals);
		
		JButton btnBuyCrops = new JButton("Buy crops");
		btnBuyCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Crops");
			}
		});
		btnBuyCrops.setBounds(100, 152, 117, 25);
		window.getContentPane().add(btnBuyCrops);
		
		JButton btnBuyItems = new JButton("Buy farming items");
		btnBuyItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Items");
			}
		});
		btnBuyItems.setBounds(100, 255, 207, 25);
		window.getContentPane().add(btnBuyItems);
	}
}
