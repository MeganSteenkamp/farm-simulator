package farm.simulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Font;

public class SetupScreen {

	private JFrame window;
	private JTextField nameInput;
	private JTextField ageInput;
	private JTextField farmNameInput;
	private ApplicationManager manager;
	private GameEnvironment game;

	private int numDays;
	private String farmType = "";
	private int age;
	private String farmerName;
	private String farmName;

	/**
	 * Create the application.
	 */
	public SetupScreen(ApplicationManager application, GameEnvironment g) {
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
		manager.closeSetupScreen(this);
	}
	
	private String validateName(String inputString, String fieldName) {
		// Regex to check for no numbers of special characters
		String pattern = "^[a-zA-Z\\s]+$";
		Pattern r = Pattern.compile(pattern);
		
		Matcher m = r.matcher(inputString);
		if (m.matches()) {
			if (! (inputString.length() >= 3 && inputString.length() <= 15)) {
				if (fieldName.equals("farmer name")) {
					nameInput.setText("");
				} else {
					farmNameInput.setText("");
				}
				throw new IllegalArgumentException("Please enter a " + fieldName + " that is between 3 and 15 characters long");
			}
		} else {
			if (fieldName.equals("farmer name")) {
				nameInput.setText("");
			} else {
				farmNameInput.setText("");
			}
			throw new IllegalArgumentException("Please enter a " + fieldName + " that does not contain any special characters");
		}
		return inputString;
	}

	public int validateAge(String number) {
		try {
			return Integer.parseInt(number);
		} catch (Exception e) {
			ageInput.setText("");
			throw new NumberFormatException("Please enter the age as a whole number");
		}
	}

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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Farm Simulator Setup");
		window.setBounds(100, 100, 700, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);

		JLabel welcomeLabel = new JLabel("Welcome to 'Mowing Before Hoeing'. Here you will begin a new life on a farm.");
		welcomeLabel.setBounds(12, 12, 650, 15);
		window.getContentPane().add(welcomeLabel);

		JLabel ageLabel = new JLabel("Enter farmer's age:");
		ageLabel.setBounds(12, 113, 339, 15);
		window.getContentPane().add(ageLabel);

		JLabel nameLabel = new JLabel("Name your farmer:");
		nameLabel.setBounds(12, 79, 339, 15);
		window.getContentPane().add(nameLabel);

		JLabel numDaysLabel = new JLabel("How many days would you like the game to last?");
		numDaysLabel.setBounds(12, 44, 403, 15);
		window.getContentPane().add(numDaysLabel);
		
		JSlider numDaysSlider = new JSlider();
		numDaysSlider.setPaintLabels(true);
		numDaysSlider.setMajorTickSpacing(1);
		numDaysSlider.setMinorTickSpacing(1);
		numDaysSlider.setMaximum(10);
		numDaysSlider.setMinimum(5);
		numDaysSlider.setBounds(391, 39, 285, 31);
		window.getContentPane().add(numDaysSlider);

		JLabel farmNameLabel = new JLabel("Give your farm a name:");
		farmNameLabel.setBounds(12, 152, 339, 15);
		window.getContentPane().add(farmNameLabel);

		JLabel farmSelectLabel = new JLabel("Select a farm type:");
		farmSelectLabel.setBounds(12, 196, 339, 15);
		window.getContentPane().add(farmSelectLabel);

		JTextArea farmDescription = new JTextArea("");
		farmDescription.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 14));
		farmDescription.setEditable(false);
		farmDescription.setBounds(391, 206, 285, 116);
		window.getContentPane().add(farmDescription);
		
		JTextArea bonusesDescription = new JTextArea(GameEnvironment.getBonusesDescription());
		bonusesDescription.setVisible(false);
		bonusesDescription.setWrapStyleWord(true);
		bonusesDescription.setFont(new Font("Dialog", Font.ITALIC, 9));
		bonusesDescription.setLineWrap(true);
		bonusesDescription.setEnabled(true);
		bonusesDescription.setEditable(false);
		bonusesDescription.setBounds(391, 325, 285, 95);
		window.getContentPane().add(bonusesDescription);

		JButton btnBeginGame = new JButton("Begin game");
		btnBeginGame.setEnabled(true);
		btnBeginGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					validateInput();
					numDays = numDaysSlider.getValue();
					
					// Set up farm
					game.setUpGame(numDays, farmType, farmerName, age, farmName);
					JOptionPane.showMessageDialog(window, game.getWelcomeMessage(), "Welcome", JOptionPane.INFORMATION_MESSAGE);
					
					// Move on to main window
					finishedWindow();
					closeWindow();
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(window, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBeginGame.setBounds(559, 432, 117, 25);
		window.getContentPane().add(btnBeginGame);

		JButton btnNorthKorea = new JButton("North Korea");
		btnNorthKorea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bonusesDescription.setVisible(true);
				farmDescription.setText(NorthKoreanFarm.getTypeDescription());
				farmType = "North Korea";
			}
		});
		btnNorthKorea.setBounds(12, 223, 156, 104);
		window.getContentPane().add(btnNorthKorea);

		JButton btnAfrica = new JButton("Africa");
		btnAfrica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bonusesDescription.setVisible(true);
				farmDescription.setText(AfricanFarm.getTypeDescription());
				farmType = "Africa";
			}
		});
		btnAfrica.setBounds(193, 223, 158, 104);
		window.getContentPane().add(btnAfrica);

		JButton btnMediterranean = new JButton("Mediterranean");
		btnMediterranean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bonusesDescription.setVisible(true);
				farmDescription.setText(MediterraneanFarm.getTypeDescription());
				farmType = "Mediterranean";
			}
		});
		btnMediterranean.setBounds(12, 354, 156, 104);
		window.getContentPane().add(btnMediterranean);

		JButton btnNewZealand = new JButton("New Zealand");
		btnNewZealand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bonusesDescription.setVisible(true);
				farmDescription.setText(NewZealandFarm.getTypeDescription());
				farmType = "New Zealand";
			}
		});
		btnNewZealand.setBounds(193, 354, 158, 103);
		window.getContentPane().add(btnNewZealand);

		nameInput = new JTextField();
		nameInput.setBounds(391, 75, 285, 24);
		window.getContentPane().add(nameInput);
		nameInput.setColumns(10);

		ageInput = new JTextField();
		ageInput.setColumns(10);
		ageInput.setBounds(391, 109, 285, 24);
		window.getContentPane().add(ageInput);

		farmNameInput = new JTextField();
		farmNameInput.setColumns(10);
		farmNameInput.setBounds(391, 148, 285, 24);
		window.getContentPane().add(farmNameInput);
	}
}
