package com.chess;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ChessBoard {

	// private final Logger LOGGER =
	// Logger.getLogger(ChessBoard.class.getName());
	private static final int CELL_WIDTH = 80;
	Image img[] = new Image[12];
	private Board board;
	private Partner partner;
	private Piece selectedPiece = null;
	private JPanel chessPanel;

	public ChessBoard(Board b, Partner p) {
		this.partner = p;
		new Receiver(partner.socket, this).start();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException ex) {
				} catch (InstantiationException ex) {
				} catch (IllegalAccessException ex) {
				} catch (UnsupportedLookAndFeelException ex) {
				}
				chessPanel = new ChessPanel();
				JFrame frame = new JFrame("Test");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				frame.add(chessPanel);
				frame.setSize(660, 680);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		this.board = b;

		String str1[] = new String[12];
		String str2 = "C:/Users/Vimukti_2/Desktop/CodeSchool/chess icons/chess_piece_";
		str1[0] = "white_king.png";
		str1[1] = "white_queen.png";
		str1[2] = "white_knight.png";
		str1[3] = "white_rook.png";
		str1[4] = "white_bishop.png";
		str1[5] = "white_pawn.png";
		str1[6] = "black_king.png";
		str1[7] = "black_queen.png";
		str1[8] = "black_knight.png";
		str1[9] = "black_rook.png";
		str1[10] = "black_bishop.png";
		str1[11] = "black_pawn.png";

		for (int i = 0; i < 12; i++) {
			img[i] = Toolkit.getDefaultToolkit().createImage(str2 + str1[i]);

		}

	}

	protected Position getPositionInBoard(Position p) {
		Position p1 = new Position();
		p1.x = (int) Math.floor(p.x / CELL_WIDTH);
		p1.y = (int) Math.floor(p.y / CELL_WIDTH);
		return p1;
	}

	protected Position getPositionInFrame(Position p) {
		Position p1 = new Position();
		p1.x = p.x * CELL_WIDTH + CELL_WIDTH / 5;
		p1.y = p.y * CELL_WIDTH + CELL_WIDTH / 5;
		return p1;
	}

	protected class ChessPanel extends JPanel {

		ChessPanel() {
			this.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					Position p = new Position(e.getX(), e.getY());

					p = getPositionInBoard(p);
					repaint();
					if (selectedPiece == null) {

						forFirstClick(p);

					} else {
						Position newPosition = selectedPiece.getPosition();
						if (forSecondClick(p)) {
							partner.send(newPosition, p);
						}

					}

				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);

			Graphics2D g2d = (Graphics2D) g.create();
			drawBoard(g2d);
			drawPieces(g2d);
			g2d.dispose();

		}

		private void drawPieces(Graphics2D g) {

			for (Piece p : board.getPieces()) {
				Position position = p.getPosition();
				position = getPositionInFrame(position);
				Image image = null;
				Color c = p.getColor();
				if (c == Color.BLACK) {
					if (p instanceof King && p.isAlive()) {
						image = img[6];
					} else if (p instanceof Bishop && p.isAlive()) {
						image = img[10];
					} else if (p instanceof Minister && p.isAlive()) {
						image = img[7];
					} else if (p instanceof Rook && p.isAlive()) {
						image = img[9];
					} else if (p instanceof Knight && p.isAlive()) {
						image = img[8];
					} else if (p instanceof Pawn && p.isAlive()) {
						image = img[11];
					}
				} else {
					if (p instanceof King && p.isAlive()) {
						image = img[0];
					} else if (p instanceof Bishop && p.isAlive()) {
						image = img[4];
					} else if (p instanceof Minister && p.isAlive()) {
						image = img[1];
					} else if (p instanceof Rook && p.isAlive()) {
						image = img[3];
					} else if (p instanceof Knight && p.isAlive()) {
						image = img[2];
					} else if (p instanceof Pawn && p.isAlive()) {
						image = img[5];
					}
				}

				g.drawImage(image, position.x, position.y, CELL_WIDTH / 2,
						CELL_WIDTH / 2, this);
				if (p == selectedPiece) {
					g.setColor(java.awt.Color.red);
					g.drawRect(position.x, position.y, CELL_WIDTH / 2,
							CELL_WIDTH / 2);

				}
			}

		}

		private void drawBoard(Graphics2D g) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					int y = i * CELL_WIDTH;
					int x = j * CELL_WIDTH;
					if ((i * 7 + j) % 2 != 0) {
						g.fillRect(x, y, CELL_WIDTH, CELL_WIDTH);
					} else {
						g.drawRect(x, y, CELL_WIDTH, CELL_WIDTH);
					}
				}
			}

		}

	}

	public void forFirstClick(Position p) {
		selectedPiece = board.getPiece(p);
		if ((selectedPiece.getColor() == Color.WHITE && board.isBlacksTurn == true)
				|| (selectedPiece.getColor() == Color.BLACK && board.isBlacksTurn == false)) {
			selectedPiece = null;
		}
	}

	public boolean forSecondClick(Position p) {

		if (selectedPiece.isValidPosition(p, board)) {
			if ((selectedPiece.getColor() == Color.WHITE && board.isBlacksTurn == false)
					|| (selectedPiece.getColor() == Color.BLACK && board.isBlacksTurn == true)) {
				Piece oldPiece = board.getPiece(p);
				if (oldPiece != null) {
					oldPiece.setAlive(false);
				}
				selectedPiece.setPosition(p);
				this.chessPanel.repaint();
				// board.isBlacksTurn = !board.isBlacksTurn;
				selectedPiece = null;
				return true;
			}
		}

		return false;

	}

}
