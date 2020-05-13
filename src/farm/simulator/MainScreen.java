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

public class MainScreen {

	private JFrame window;
	private ApplicationManager manager;
	private GameEnvironment game;

	public MainScreen(ApplicationManager application, GameEnvironment g) {
		game = g;
		manager = application;
		initialize();
		window.setVisible(true);
		JOptionPane.showMessageDialog(window, game.getDayWelcomeMessage(), "New day", JOptionPane.INFORMATION_MESSAGE);
	}

	public GameEnvironment closeWindow() {
		window.dispose();
		return game;
	}

	public void finishedWindow() {
		manager.closeMainScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Main Screen");
		window.setBounds(100, 100, 700, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);

		JButton btnGeneralStore = new JButton("Visit the general store");
		btnGeneralStore.setBounds(35, 246, 291, 75);
		window.getContentPane().add(btnGeneralStore);

		JTextArea actionDescription = new JTextArea();
		actionDescription.setFont(new Font("Dialog", Font.BOLD, 12));
		actionDescription.setWrapStyleWord(true);
		actionDescription.setLineWrap(true);
		actionDescription.setBounds(355, 28, 312, 390);
		window.getContentPane().add(actionDescription);

		JButton btnViewCropAndAnimals = new JButton("View crop and animal status");
		btnViewCropAndAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionDescription.setText(game.getCropAndAnimalStatus());
			}
		});
		btnViewCropAndAnimals.setBounds(35, 39, 291, 75);
		window.getContentPane().add(btnViewCropAndAnimals);

		JButton btnViewFarmStatus = new JButton("View farm status");
		btnViewFarmStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnViewFarmStatus.setBounds(35, 126, 291, 70);
		window.getContentPane().add(btnViewFarmStatus);

		JButton btnNextDay = new JButton("Move to next day");
		btnNextDay.setBounds(364, 438, 184, 25);
		window.getContentPane().add(btnNextDay);

		JButton btnGo = new JButton("Go");
		btnGo.setBackground(UIManager.getColor("Button.background"));
		btnGo.setBounds(560, 438, 117, 25);
		window.getContentPane().add(btnGo);

		JLabel mainScreenDescription = new JLabel("Select a button to find out more.");
		mainScreenDescription.setBounds(35, 12, 632, 15);
		window.getContentPane().add(mainScreenDescription);

		JButton btnPerformAnAction = new JButton("Perform an action on the farm*");
		btnPerformAnAction.setBounds(35, 333, 291, 75);
		window.getContentPane().add(btnPerformAnAction);

		JLabel lblActionsWarning = new JLabel("*These actions count towards a daily action");
		lblActionsWarning.setFont(new Font("Dialog", Font.ITALIC, 9));
		lblActionsWarning.setBounds(35, 420, 291, 15);
		window.getContentPane().add(lblActionsWarning);

		JLabel lblNumActions = new JLabel("Number of actions remaining: " + game.getCurrentDay());
		lblNumActions.setFont(new Font("Dialog", Font.ITALIC, 9));
		lblNumActions.setBounds(35, 435, 291, 15);
		window.getContentPane().add(lblNumActions);
	}
}
