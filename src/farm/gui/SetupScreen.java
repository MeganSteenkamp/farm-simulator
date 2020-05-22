package farm.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

import farm.game.AfricanFarm;
import farm.game.GameEnvironment;
import farm.game.MediterraneanFarm;
import farm.game.NewZealandFarm;
import farm.game.NorthKoreanFarm;

/**
 * This application window displays first screen that sets up the game with
 * input from the user.
 * 
 * @author Megan Steenkamp
 * @version 1.0
 */
public class SetupScreen {

	private JFrame window;
	private JTextField nameInput;
	private JTextField ageInput;
	private JTextField farmNameInput;
	private ApplicationManager manager;
	private GameEnvironment game;

	private int numDays;
	private String farmType;
	private int age;
	private String farmerName;
	private String farmName;

	private JTextArea farmDescription;
	private JTextArea bonusesDescription;
	
	private JButton btnNorthKorea;
	private JButton btnAfrica;
	private JButton btnMediterranean;
	private JButton btnNewZealand;

	/**
	 * Create the application.
	 * 
	 * @param application The application managing windows
	 * @param g           The game environment
	 */
	public SetupScreen(ApplicationManager application, GameEnvironment g) {
		game = g;
		manager = application;
		initialize();
		window.setVisible(true);
		JOptionPane.showMessageDialog(window, game.getGameInstructions(), "Welcome", JOptionPane.INFORMATION_MESSAGE);
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
		manager.closeSetupScreen(this);
	}

	/**
	 * Validates the names given by a user. Used to validate the farmer name and the
	 * name of the farm.
	 * 
	 * @param inputString The string to be validated.
	 * @param fieldName   The field for which the input has been given.
	 * @return The string capitalized if it is valid. Else, an exception will be
	 *         thrown.
	 */
	private String validateName(String inputString, String fieldName) {
		// Regular expression to check for no numbers of special characters
		String pattern = "^[a-zA-Z\\s]+$";
		Pattern r = Pattern.compile(pattern);

		Matcher m = r.matcher(inputString);
		if (m.matches()) {
			if (!(inputString.length() >= 3 && inputString.length() <= 15)) {
				if (fieldName.equals("farmer name")) {
					nameInput.setText("");
				} else {
					farmNameInput.setText("");
				}
				throw new IllegalArgumentException(
						"Please enter a " + fieldName + " that is between 3 and 15 characters long");
			}
		} else {
			if (fieldName.equals("farmer name")) {
				nameInput.setText("");
			} else {
				farmNameInput.setText("");
			}
			throw new IllegalArgumentException(
					"Please enter a " + fieldName + " that does not contain any special characters");
		}

		// Capitalize string
		return inputString.substring(0, 1).toUpperCase() + inputString.substring(1);
	}

	/**
	 * Validates the age input by a user.
	 * 
	 * @param number The age that has been input as a String.
	 * @return The age as an integer if it is valid. Else, an exception will be
	 *         thrown.
	 */
	public int validateAge(String number) {
		try {
			return Integer.parseInt(number);
		} catch (Exception e) {
			ageInput.setText("");
			throw new NumberFormatException("Please enter the age as a whole number");
		}
	}

	/**
	 * Validates that all required fields on the start up screen have been entered
	 * before a user can progress to the next screen.
	 */
	public void validateInput() {
		if (!(nameInput.getText().length() > 0 && ageInput.getText().length() > 0
				&& farmNameInput.getText().length() > 0)) {
			throw new IllegalArgumentException("Please enter input for all fields");
		}
		if (!(farmType.length() > 0)) {
			throw new IllegalArgumentException("Please select a farm");
		}

		farmerName = validateName(nameInput.getText(), "farmer name");
		farmName = validateName(farmNameInput.getText(), "farm name");
		age = validateAge(ageInput.getText());
	}

	/**
	 * Updates the screen to show the user the details of the farm they have
	 * selected with definitions of the meaning of the bonuses.
	 * 
	 * @param selectedFarm The farm type selected.
	 */
	private void updateSelectedFarm(String selectedFarm) {
		farmType = selectedFarm;
		farmDescription.setVisible(true);
		bonusesDescription.setVisible(true);
		farmDescription.setText(game.getFarmDescription(farmType));
	}
	
	/**
	 * Resets all button background colors to their default color.
	 */
	public void revertButtonColours() {
		btnNorthKorea.setBackground(null);
		btnAfrica.setBackground(null);
		btnMediterranean.setBackground(null);
		btnNewZealand.setBackground(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Game Setup");
		window.setBounds(100, 100, 700, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);

		JLabel welcomeLabel = new JLabel(
				"Welcome to 'Mowing Before Hoeing'. Here you will begin a new life on a farm.");
		welcomeLabel.setBounds(12, 12, 650, 15);
		window.getContentPane().add(welcomeLabel);

		JLabel ageLabel = new JLabel("Enter farmer's age:");
		ageLabel.setBounds(12, 123, 339, 15);
		window.getContentPane().add(ageLabel);

		JLabel nameLabel = new JLabel("Name your farmer:");
		nameLabel.setBounds(12, 89, 339, 15);
		window.getContentPane().add(nameLabel);

		JLabel numDaysLabel = new JLabel("How many days would you like the game to last?");
		numDaysLabel.setBounds(12, 55, 403, 15);
		window.getContentPane().add(numDaysLabel);

		JSlider numDaysSlider = new JSlider();
		numDaysSlider.setPaintLabels(true);
		numDaysSlider.setMajorTickSpacing(1);
		numDaysSlider.setMinorTickSpacing(1);
		numDaysSlider.setMaximum(10);
		numDaysSlider.setMinimum(5);
		numDaysSlider.setBounds(391, 49, 285, 31);
		window.getContentPane().add(numDaysSlider);

		JLabel farmNameLabel = new JLabel("Give your farm a name:");
		farmNameLabel.setBounds(12, 162, 339, 15);
		window.getContentPane().add(farmNameLabel);

		JLabel farmSelectLabel = new JLabel("Select a farm type:");
		farmSelectLabel.setBounds(12, 196, 339, 15);
		window.getContentPane().add(farmSelectLabel);

		farmDescription = new JTextArea("");
		farmDescription.setWrapStyleWord(true);
		farmDescription.setLineWrap(true);
		farmDescription.setEditable(false);
		farmDescription.setVisible(false);
		farmDescription.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 14));
		farmDescription.setBounds(391, 223, 285, 66);
		window.getContentPane().add(farmDescription);

		bonusesDescription = new JTextArea(GameEnvironment.getBonusesDescription());
		bonusesDescription.setVisible(false);
		bonusesDescription.setWrapStyleWord(true);
		bonusesDescription.setFont(new Font("Dialog", Font.PLAIN, 10));
		bonusesDescription.setLineWrap(true);
		bonusesDescription.setEnabled(true);
		bonusesDescription.setEditable(false);
		bonusesDescription.setBounds(391, 289, 285, 143);
		window.getContentPane().add(bonusesDescription);

		JButton btnBeginGame = new JButton("Begin game");
		btnBeginGame.setBackground(UIManager.getColor("Button.background"));
		btnBeginGame.setEnabled(true);
		btnBeginGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validateInput();
					numDays = numDaysSlider.getValue();

					// Set up farm
					game.setUpGame(numDays, farmType, farmerName, age, farmName);
					JOptionPane.showMessageDialog(window, game.getWelcomeMessage(), "Welcome",
							JOptionPane.INFORMATION_MESSAGE);
					game.beginNewDay();

					// Move on to main window
					finishedWindow();
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(window, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBeginGame.setBounds(559, 438, 117, 25);
		window.getContentPane().add(btnBeginGame);

		btnNorthKorea = new JButton("North Korea");
		btnNorthKorea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revertButtonColours();
				btnNorthKorea.setBackground(Color.GREEN);
				updateSelectedFarm("North Korea");
			}
		});
		btnNorthKorea.setBounds(12, 223, 156, 104);
		window.getContentPane().add(btnNorthKorea);

		btnAfrica = new JButton("Africa");
		btnAfrica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revertButtonColours();
				btnAfrica.setBackground(Color.GREEN);
				updateSelectedFarm("Africa");
			}
		});
		btnAfrica.setBounds(193, 223, 158, 104);
		window.getContentPane().add(btnAfrica);

		btnMediterranean = new JButton("Mediterranean");
		btnMediterranean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revertButtonColours();
				btnMediterranean.setBackground(Color.GREEN);
				updateSelectedFarm("Mediterranean");
			}
		});
		btnMediterranean.setBounds(12, 354, 156, 104);
		window.getContentPane().add(btnMediterranean);

		btnNewZealand = new JButton("New Zealand");
		btnNewZealand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revertButtonColours();
				btnNewZealand.setBackground(Color.GREEN);
				updateSelectedFarm("New Zealand");
			}
		});
		btnNewZealand.setBounds(193, 354, 158, 103);
		window.getContentPane().add(btnNewZealand);

		nameInput = new JTextField();
		nameInput.setBounds(391, 85, 285, 24);
		window.getContentPane().add(nameInput);
		nameInput.setColumns(10);

		ageInput = new JTextField();
		ageInput.setColumns(10);
		ageInput.setBounds(391, 119, 285, 24);
		window.getContentPane().add(ageInput);

		farmNameInput = new JTextField();
		farmNameInput.setColumns(10);
		farmNameInput.setBounds(391, 158, 285, 24);
		window.getContentPane().add(farmNameInput);
	}
}
