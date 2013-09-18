package com.chess;

public class Board {
	Piece pieces[] = new Piece[32];
	boolean isBlacksTurn = false;

	public Piece getPiece(Position p) {
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i].getPosition().x == p.x
					&& pieces[i].getPosition().y == p.y && pieces[i].isAlive())

				return pieces[i];
		}
		return null;
	}

	public Board() {
		start();
		

	}


	public void start() {
		int i = 0;
		for (; i < 8; i++) {
			pieces[i] = new Pawn();
			pieces[i].setColor(Color.WHITE);
			pieces[i].setAlive(true);
			pieces[i].setPosition(new Position(i, 6));
			
			

		}

		for (; i < 16; i++) {
			pieces[i] = new Pawn();
			pieces[i].setColor(Color.BLACK);
			pieces[i].setAlive(true);
			pieces[i].setPosition(new Position(i - 8, 1));
			
		}
		for (; i < 18; i++) {
			pieces[i] = new Rook();
			pieces[i].setColor(Color.WHITE);
			pieces[i].setAlive(true);

		}

		for (; i < 20; i++) {
			pieces[i] = new Rook();
			pieces[i].setColor(Color.BLACK);
			pieces[i].setAlive(true);


		}
		pieces[16].setPosition(new Position(0, 7));
		pieces[17].setPosition(new Position(7, 7));
		pieces[18].setPosition(new Position(0, 0));
		pieces[19].setPosition(new Position(7, 0));

		for (; i < 22; i++) {
			pieces[i] = new Knight();
			pieces[i].setColor(Color.WHITE);
			pieces[i].setAlive(true);

		}

		for (; i < 24; i++) {
			pieces[i] = new Knight();

			pieces[i].setColor(Color.BLACK);
			pieces[i].setAlive(true);

		}

		pieces[20].setPosition(new Position(1, 7));
		pieces[21].setPosition(new Position(6, 7));
		pieces[22].setPosition(new Position(1, 0));
		pieces[23].setPosition(new Position(6, 0));

		for (; i < 26; i++) {
			pieces[i] = new Bishop();
			pieces[i].setColor(Color.WHITE);
			pieces[i].setAlive(true);
		}
		for (; i < 28; i++) {
			pieces[i] = new Bishop();
			pieces[i].setColor(Color.BLACK);
			pieces[i].setAlive(true);

		}

		pieces[24].setPosition(new Position(2, 7));
		pieces[25].setPosition(new Position(5, 7));
		pieces[26].setPosition(new Position(2, 0));
		pieces[27].setPosition(new Position(5, 0));

		pieces[i] = new Minister();
		pieces[i].setColor(Color.WHITE);
		pieces[i].setAlive(true);
		pieces[i].setPosition(new Position(3, 7));

		i++;
		pieces[i] = new Minister();
		pieces[i].setColor(Color.BLACK);
		pieces[i].setAlive(true);
		pieces[i].setPosition(new Position(3, 0));

		i++;
		pieces[i] = new King();
		pieces[i].setColor(Color.WHITE);
		pieces[i].setAlive(true);
		pieces[i].setPosition(new Position(4, 7));

		i++;
		pieces[i] = new King();
		pieces[i].setColor(Color.BLACK);
		pieces[i].setAlive(true);
		pieces[i].setPosition(new Position(4, 0));

	}

	public Piece[] getPieces() {
		return pieces;
	}
}
