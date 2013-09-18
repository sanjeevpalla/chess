package com.chess;

import java.util.logging.Logger;
import java.util.logging.Level;

public class Pawn extends Piece {
	/**
	 * A pawn can initially move 2steps/1step left to player choice. from the
	 * second move a pawn has to move only one step in the forward direction,
	 * incase of a peice present exactly one box diagnol belonging to the other
	 * player then the pawn can kill/replace the peice present at that position
	 */
	private final Logger LOGGER = Logger.getLogger(ChessBoard.class.getName());

	public boolean isValidPosition(Position p, Board b) {
		Piece pp;
		Position p1 = getDifference(p, this.getPosition());
		Position p2 = new Position();
		p2.x = this.getPosition().x;

		p2.y = this.getPosition().y;
		Piece p4 = b.getPiece(p);

		if (this.getColor() == Color.BLACK) {
			if (p4 != null && p4.getColor() == Color.BLACK) {
			LOGGER.setLevel(Level.INFO);
			LOGGER.warning("returning false because of black coin presence");
			return false;
		} else if (p4 != null && p1.x == 0) {
			LOGGER.warning("obstruction");
			return false;
		} else if ((p4 != null) && (p4.getColor() == Color.WHITE)
				&& ((p1.x == 1 && p1.y == 1) || (p1.x == -1 && p1.y == 1))) {
			LOGGER.warning("killing white");
			return true;
		} else if (p1.x == 0 && p1.y == 1) {
			LOGGER.warning("moving black one step");
			return true;
		} else if (p1.x == 0 && p1.y == 2 && p2.y == 1) {
			p2.y++;
			pp = b.getPiece(p2);
			if (pp != null) {
				LOGGER.warning("black one step obstruction");
				return false;
			} else {
				LOGGER.warning("black moving two steps");
				return true;
				}
			}
		}

		else if (this.getColor() == Color.WHITE) {
			if (p4 != null && p4.getColor() == Color.WHITE) {
			LOGGER.warning("returning false because of white coin presence");
			return false;
		} else if (p4 != null && p1.x == 0) {
			LOGGER.warning("obstruction");
			return false;
		} else if ((p4 != null) && (p4.getColor() == Color.BLACK)
				&& ((p1.x == 1 && p1.y == -1) || (p1.x == -1 && p1.y == -1))) {
			LOGGER.warning("killing black");
			return true;
		} else if (p1.x == 0 && p1.y == -1) {
			LOGGER.warning("moving white one step");
			return true;
		} else if (p1.x == 0 && p1.y == -2 && p2.y == 6) {
			p2.y--;
			pp = b.getPiece(p2);
			if (pp != null) {
				LOGGER.warning("moving two steps failed");
				return false;
			} else {
				LOGGER.warning("moving white two steps");
				return true;
				}
			}
		}
		LOGGER.warning("outerfalsee");
return false;
}
}


		/*
		 * if (this.getColor() == Color.BLACK) { if (this.getPosition().y == 1)
		 * { if (p1.x == 0 && p1.y==2) { if (p1.y == 2) { // p2.x; p2.y++; pp =
		 * b.getPiece(p2); if (pp != null) { return false; } else { return true;
		 * } } else { return false; } } } else if (p1.x == 0 && p1.y == 1) { pp
		 * = b.getPiece(p); if (pp != null) { return false; } return true; }
		 * else if ((p1.x == 1 && p1.y == 1) || (p1.x == -1 && p1.y == 1)) {
		 * Piece p3 = b.getPiece(p); if (p3 != null && (p3.getColor() ==
		 * Color.WHITE)) return true; }
		 * 
		 * }
		 */
		
		/*	else {
			if (this.getPosition().y == 6) {
				if (p1.x == 0) {
					if (p1.y == -2) {
						// p2.x--;
						p2.y--;
						pp = b.getPiece(p2);
						if (pp != null) {
							return false;
						}

						return true;
					} else {
						return false;
					}
				}
			} else if (p1.x == 0 && p1.y == -1) {
				pp = b.getPiece(p);
				if (pp != null) {
					return false;
				}
				return true;
			} else if ((p1.x == 1 && p1.y == -1) || (p1.x == -1 && p1.y == -1)) {
				Piece p3 = b.getPiece(p);
				if (p3 != null && (p3.getColor() == Color.BLACK))
					return true;
			}
		}
		return false;
	}
}
*/