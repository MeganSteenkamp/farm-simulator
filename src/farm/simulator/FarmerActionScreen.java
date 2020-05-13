package farm.simulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FarmerActionScreen {

	private ApplicationManager manager;
	private GameEnvironment game;

	private JFrame window;

	/**
	 * Create the application.
	 */
	public FarmerActionScreen(ApplicationManager application, GameEnvironment g) {
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
		manager.closeFarmerActionScreen(this);
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
		
		JButton btnTendToCrops = new JButton("Tend to crops");
		btnTendToCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(window, game.getCropTendingDescription(),
						"Decide Action", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
					return;
				} else {
					//TODO
				}
			}
		});
		btnTendToCrops.setBounds(24, 27, 240, 59);
		window.getContentPane().add(btnTendToCrops);
		
		JButton btnFeedAnimals = new JButton("Feed animals");
		btnFeedAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(window, game.getFeedingAnimalsDescription(),
						"Decide Action", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
					return;
				} else {
					//TODO
				}
			}
		});

		btnFeedAnimals.setBounds(24, 105, 240, 59);
		window.getContentPane().add(btnFeedAnimals);
		
		JButton btnPlayWithAnimals = new JButton("Play with animals");
		btnPlayWithAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(window, game.getPlayWithAnimalsDescription(),
						"Decide Action", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
					return;
				} else {
					//TODO
				}
			}
		});
		btnPlayWithAnimals.setBounds(24, 190, 240, 59);
		window.getContentPane().add(btnPlayWithAnimals);
		
		JButton btnHarvestCrops = new JButton("Harvest crops");
		btnHarvestCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(window, game.getHarvestCropsDescription(),
						"Decide Action", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
					return;
				} else {
					//TODO
				}
			}
		});
		btnHarvestCrops.setBounds(24, 277, 240, 59);
		window.getContentPane().add(btnHarvestCrops);
		
		JButton btnTendToFarmland = new JButton("Tend to farm land");
		btnTendToFarmland.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(window, game.getTendToFarmLandDescription(),
						"Decide Action", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
					return;
				} else {
					
				}
			}
		});
		btnTendToFarmland.setBounds(24, 356, 240, 59);
		window.getContentPane().add(btnTendToFarmland);
	}
}
