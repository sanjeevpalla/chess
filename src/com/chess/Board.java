package com.chess;

public class Board {
	Piece pieces[];
	boolean isBlacksTurn;

	public Piece getPiece(Position p) {
		//Another
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i].position.x == p.x && pieces[i].position.y == p.y)
				return pieces[i];
		}
		return null;
	}

	public void start() {
		int i = 0;
		for (; i < 8; i++) {
			pieces[i] = new Pawn();
			pieces[i].color = Color.WHITE;
			pieces[i].alive = true;
			pieces[i].position.y = 2;
			pieces[i].position.x = i + 1;

		}
		for (; i < 16; i++) {
			pieces[i] = new Pawn();
			pieces[i].color = Color.BLACK;
			pieces[i].alive = true;
			pieces[i].position.y = 7;
			pieces[i].position.x = i - 7;

		}
		for (; i < 18; i++) {
			pieces[i] = new Rook();
			pieces[i].color = Color.WHITE;
			pieces[i].alive = true;
			pieces[i].position.y = 1;
		}

		for (; i < 20; i++) {
			pieces[i] = new Rook();
			pieces[i].color = Color.BLACK;
			pieces[i].alive = true;
			pieces[i].position.y = 8;

		}

		pieces[16].position.x = 1;
		pieces[17].position.x = 8;
		pieces[18].position.x = 1;
		pieces[19].position.x = 8;

		for (; i < 22; i++) {
			pieces[i] = new Knight();
			pieces[i].color = Color.WHITE;
			pieces[i].alive = true;
			pieces[i].position.y = 1;
		}

		for (; i < 24; i++) {
			pieces[i] = new Knight();
			pieces[i].color = Color.BLACK;
			pieces[i].alive = true;
			pieces[i].position.y = 8;
		}

		pieces[20].position.x = 2;
		pieces[21].position.x = 7;
		pieces[22].position.x = 2;
		pieces[23].position.x = 7;

		for (; i < 26; i++) {
			pieces[i] = new Bishop();
			pieces[i].color = Color.WHITE;
			pieces[i].alive = true;
			pieces[i].position.y = 1;
		}
		for (; i < 28; i++) {
			pieces[i] = new Bishop();
			pieces[i].color = Color.BLACK;
			pieces[i].alive = true;
			pieces[i].position.y = 8;
		}

		pieces[24].position.x = 3;
		pieces[25].position.x = 6;
		pieces[26].position.x = 3;
		pieces[27].position.x = 6;

		pieces[i] = new Minister();
		pieces[i].color = Color.WHITE;
		pieces[i].alive = true;
		pieces[i].position.x = 4;
		pieces[i].position.y = 1;
		i++;
		pieces[i] = new Minister();
		pieces[i].color = Color.BLACK;
		pieces[i].alive = true;
		pieces[i].position.x = 4;
		pieces[i].position.y = 8;
		i++;
		pieces[i] = new King();
		pieces[i].color = Color.WHITE;
		pieces[i].alive = true;
		pieces[i].position.x = 5;
		pieces[i].position.y = 1;
		i++;
		pieces[i] = new King();
		pieces[i].color = Color.BLACK;
		pieces[i].alive = true;
		pieces[i].position.x = 5;
		pieces[i].position.y = 8;

	}
}
