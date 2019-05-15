package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;

public class GameBoard extends JFrame implements ActionListener, MouseListener {

	private BoardPanel board;
	private JLabel comment;
	private JButton restart;
	private JPanel lowerSection;

	public GameBoard() {

		board = new BoardPanel();
		comment = new JLabel();

		restart = new JButton("Restart");

		lowerSection = new JPanel();
		lowerSection.setLayout(new BorderLayout());
		lowerSection.add(comment, BorderLayout.NORTH);
		lowerSection.add(restart, BorderLayout.CENTER);
		restart.addActionListener(this);
		board.addMouseListener(this);

		this.setSize(1000, 1000);
		this.setLocation(300, 0);
		this.setTitle("SUPER HERO CHESS");
		this.setLayout(new FlowLayout());
		this.add(board);
		this.add(lowerSection);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

	}

	private class BoardPanel extends JPanel {
		private Tile[][] tiles;
		private Game game;
		private final Dimension DIM = new Dimension(950, 900);

		public BoardPanel() {
			super();
			game = new Game(new Player(""), new Player(""));
			tiles = new Tile[7][6];
			this.setMaximumSize(DIM);
			this.setMinimumSize(DIM);
			this.setPreferredSize(DIM);
			this.setSize(DIM);
			this.setLayout(new GridLayout(8, 8));
			this.refactorcells();

		}

		public void refactorcells() {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 6; j++) {
					if (i != 1 && i != 2 && i != 4 && i != 5) {
						tiles[i][j] = new Tile();
						JLabel tile = new JLabel(new ImageIcon("src/Tile.jpg"));
						tiles[i][j].add(tile);
						this.add(tiles[i][j]);
						continue;
					}
					Piece current = this.game.getCellAt(i, j).getPiece();
					if (current instanceof Tech) {
						tiles[i][j] = new Tile();
						JLabel tech = new JLabel(
								new ImageIcon("src/Aizawa.jpg"));
						tiles[i][j].add(tech);
					}
					if (current instanceof Speedster) {
						tiles[i][j] = new Tile();
						JLabel speed = new JLabel(new ImageIcon("src/Iida.jpg"));
						tiles[i][j].add(speed);

					}
					if (current instanceof Medic) {
						tiles[i][j] = new Tile();
						JLabel speed = new JLabel(
								new ImageIcon("src/medic.jpg"));
						tiles[i][j].add(speed);

					}
					if (current instanceof Ranged) {
						tiles[i][j] = new Tile();
						JLabel speed = new JLabel(new ImageIcon("src/lazer"));
						tiles[i][j].add(speed);

					}
					if (current instanceof Super) {
						tiles[i][j] = new Tile();
						JLabel speed = new JLabel(new ImageIcon("src/onepunch"));
						tiles[i][j].add(speed);

					}
					if (current instanceof Armored) {
						tiles[i][j] = new Tile();
						JLabel speed = new JLabel(new ImageIcon("src/temp"));
						tiles[i][j].add(speed);
					}
					if (current instanceof SideKick) {
						tiles[i][j] = new Tile();
						JLabel speed = new JLabel(new ImageIcon("src/Shouto"));
						tiles[i][j].add(speed);
					}

					this.add(tiles[i][j]);
				}
			}
		}

	}

	private class Tile extends JButton {
		public Tile() {
			super();
			this.setSize(new Dimension(150, 150));
			this.setPreferredSize(new Dimension(150, 150));
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
