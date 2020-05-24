package farm.gui;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import farm.game.GameEnvironment;

import java.awt.Font;

/**
 * This application window displays the final score at the cessation of a game.
 * 
 * @author Megan Steenkamp
 * @version 1.0
 */
public class FinalScreen {

	private ApplicationManager manager;
	private GameEnvironment game;

	private JFrame window;

	/**
	 * Create the application.
	 * 
	 * @param application The application managing windows
	 * @param g           The game environment
	 */
	public FinalScreen(ApplicationManager application, GameEnvironment g) {
		game = g;
		manager = application;
		initialize();
		window.setVisible(true);
	}

	/**
	 * Close the final screen, finishing the game.
	 */
	public void closeWindow() {
		window.dispose();
	}

	/**
	 * Notify the window manager that the use of this window is finished.
	 */
	public void finishedWindow() {
		manager.closeFinalScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Game over");
		window.setBounds(100, 100, 700, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);

		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setFont(new Font("Dialog", Font.BOLD, 19));
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setBounds(0, 12, 700, 42);
		window.getContentPane().add(lblGameOver);

		JTextArea textFinalScore = new JTextArea();
		textFinalScore.setWrapStyleWord(true);
		textFinalScore.setLineWrap(true);
		textFinalScore.setEditable(false);
		textFinalScore.setBounds(169, 59, 361, 191);
		textFinalScore.setText(game.getFinalResults());
		window.getContentPane().add(textFinalScore);

		JLabel lblFinalScore = new JLabel("FINAL SCORE: " + game.calculateFinalScore());
		lblFinalScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalScore.setFont(new Font("Dialog", Font.BOLD, 19));
		lblFinalScore.setBounds(0, 250, 700, 42);
		window.getContentPane().add(lblFinalScore);
	}
}
