package view;

import javax.swing.*;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ViewGame extends JFrame implements ActionListener {

	private static String player1Name;
	private static String player2Name;

	private JPanel window;
	private JPanel one;
	private JPanel two;

	private JLabel p1;
	private JTextField p1Name;
	private JLabel p2;
	private JTextField p2Name;
	private JButton startBt;

	private GameBoard g;
	
	
	public ViewGame() throws IOException {
		g = new GameBoard();
		p1 = new JLabel("Player 1 : ");
		p2 = new JLabel("Player 2 : ");
		startBt = new JButton("Start");
		p1Name = new JTextField();
		p1Name.addActionListener(this);
		p2Name = new JTextField();
		p2Name.addActionListener(this);
		startBt.addActionListener(this);
		p1Name.addActionListener(this);
		p2Name.addActionListener(this);

		setPanels();
		setWindow();

		this.setSize(800, 10000);
		this.setLocation(350, 0);
		this.setLayout(new GridLayout(3,3));
		this.add(window,0,0);
		this.setVisible(true);
		this.setTitle("TO BE DECIDED");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static String getPlayer1Name() {
		return player1Name;
	}

	@SuppressWarnings("static-access")
	public void setPlayer1Name(String player1Name) {
		this.player1Name = player1Name;
	}

	public static String getPlayer2Name() {
		return player2Name;
	}

	@SuppressWarnings("static-access")
	public void setPlayer2Name(String player2Name) {
		this.player2Name = player2Name;
	}

	private void setWindow() {
		window = new JPanel();
		window.setMaximumSize(new Dimension(500, 800));
		window.setMinimumSize(new Dimension(500, 800));
		window.setPreferredSize(new Dimension(500, 800));
		window.setSize(500, 800);

		window.setLayout(new BorderLayout());
		window.add(one, BorderLayout.NORTH);
		window.add(two, BorderLayout.CENTER);
	}

	private void setPanels() {
		one = new JPanel();
		two = new JPanel();

		one.setLayout(new GridLayout(2, 2));
		one.add(p1);
		one.add(p1Name);
		one.add(p2);
		one.add(p2Name);
		two.add(startBt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setPlayer1Name(p1Name.getText());
		setPlayer2Name(p2Name.getText());

		if (e.getSource() == this.startBt) {
			this.setVisible(false);
			g.setVisible(true);
		}

	}
	public static void main(String[] args) throws IOException {
		new ViewGame();
	}
}
