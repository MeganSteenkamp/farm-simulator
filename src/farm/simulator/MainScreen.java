package farm.simulator;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
	
	public void finishedWindow() {
		manager.closeMainScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 450, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
