package farm.simulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemSaleScreen {

	private ApplicationManager manager;
	private GameEnvironment game;

	private JFrame window;

	/**
	 * Create the application.
	 */
	public ItemSaleScreen(ApplicationManager application, GameEnvironment g) {
		game = g;
		manager = application;
		initialize();
		window.setVisible(true);
	}

	public GameEnvironment closeWindow() {
		window.dispose();
		return game;
	}

	public void finishedWindow() {
		manager.closeItemSaleScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Farming items for sale");
		window.setBounds(100, 100, 700, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JButton btnReturnToGeneralStore = new JButton("Return to General Store");
		btnReturnToGeneralStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnReturnToGeneralStore.setBounds(12, 438, 240, 25);
		window.getContentPane().add(btnReturnToGeneralStore);
	}
}
