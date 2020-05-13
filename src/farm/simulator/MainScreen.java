package farm.simulator;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainScreen {

	private JFrame window;
	private ApplicationManager manager;
	private GameEnvironment game;

	public MainScreen(ApplicationManager application, GameEnvironment g) {
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
		manager.closeMainScreen(this, nextScreen);
	}
	
	private String getScreenTitle() {
		return "Main Screen - Day " + game.getCurrentDay();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle(getScreenTitle());
		window.setBounds(100, 100, 700, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);

		JButton btnGeneralStore = new JButton("Visit the general store");
		btnGeneralStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("General Store");
			}
		});
		btnGeneralStore.setBounds(364, 64, 303, 344);
		window.getContentPane().add(btnGeneralStore);
		
		JButton btnViewCropAndAnimals = new JButton("View crop and animal status");
		btnViewCropAndAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(window, game.getCropAndAnimalStatus(), "Crops and Animal Status",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnViewCropAndAnimals.setBounds(35, 64, 291, 97);
		window.getContentPane().add(btnViewCropAndAnimals);
		
		JButton btnViewFarmStatus = new JButton("View farm status");
		btnViewFarmStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(window, game.getFarmStatus(), "Farm Status",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnViewFarmStatus.setBounds(35, 187, 291, 97);
		window.getContentPane().add(btnViewFarmStatus);

		JButton btnNextDay = new JButton("Move to next day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getNumActions() > 0) {
					if (JOptionPane.showConfirmDialog(window,
							"WARNING: You still have " + game.getNumActions() + " action(s) remaining today."
									+ "\nAre you sure you want to continue?",
							"Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
						return;
					}
					game.moveToNextDay();
					window.setTitle(getScreenTitle());
					JOptionPane.showMessageDialog(window, game.getDayWelcomeMessage(), "New day", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNextDay.setBounds(483, 428, 184, 25);
		window.getContentPane().add(btnNextDay);

		JLabel mainScreenDescription = new JLabel("Select a button to find out more.");
		mainScreenDescription.setBounds(35, 28, 291, 15);
		window.getContentPane().add(mainScreenDescription);

		JButton btnPerformAnAction = new JButton("Perform an action on the farm*");
		btnPerformAnAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("Farm Action");
			}
		});
		btnPerformAnAction.setBounds(35, 311, 291, 97);
		window.getContentPane().add(btnPerformAnAction);

		JLabel lblActionsWarning = new JLabel("*These actions count towards a daily action");
		lblActionsWarning.setFont(new Font("Dialog", Font.ITALIC, 9));
		lblActionsWarning.setBounds(35, 420, 291, 15);
		window.getContentPane().add(lblActionsWarning);

		JLabel lblNumActions = new JLabel("Number of actions remaining: " + game.getNumActions());
		lblNumActions.setFont(new Font("Dialog", Font.ITALIC, 9));
		lblNumActions.setBounds(35, 435, 291, 15);
		window.getContentPane().add(lblNumActions);
	}
}
