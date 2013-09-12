package com.chess;

public class Pawn extends Piece {
	/**
	 * A pawn can initially move 2steps/1step left to player choice. from the
	 * second move a pawn has to move only one step in the forward direction,
	 * incase of a peice present exactly one box diagnol belonging to the other
	 * player then the pawn can kill/replace the peice present at that position
	 */
	public boolean isValidPosition(Position p, Board b) {
		Piece pp;
		Position p1 = getDifference(p, this.position);
		Position p2 = new Position();
		p2.x = this.position.x;
		p2.y = this.position.y;
		Piece p4 = b.getPiece(p);
		if (p4 != null) {
			return false;
		}
		if (this.color == Color.WHITE) {
			if (this.position.y == 2) {
				if (p1.x == 0 && (p1.y == 1 || p1.y == 2)) {
					if (p1.y == 2) {
						p2.x++;
						p2.y++;
						pp = b.getPiece(p2);
						if (pp != null) {
							return false;
						}
					}
					return true;
				}
			} else if (p1.x == 0 && p1.y == 1) {
				pp = b.getPiece(p);
				if (pp != null) {
					return false;
				}
				return true;
			} else if ((p1.x == 1 && p1.y == 1) || (p1.x == -1 && p1.y == -1)) {
				Piece p3 = b.getPiece(p);
				if (p3.color == Color.BLACK)
					return true;
			}
			/*
			 * if ((p.y == this.position.y + 1 || p.y == this.position.y + 2) &&
			 * (this.position.x == p.x)) { return true; } } else if ((p.y ==
			 * this.position.y + 1) && (this.position.x == p.x)) { return true;
			 * } else if (p.x == this.position.x + 1 && p.y == this.position.y +
			 * 1) { Piece p1 = b.getPiece(p); if (p1.color == Color.BLACK)
			 * return true;
			 */

		} else {
			if (this.position.y == 7) {
				if (p1.x == 0 && (p1.y == -1 || p1.y == -2)) {
					if (p1.y == 7) {
						p2.x--;
						p2.y--;
						pp = b.getPiece(p2);
						if (pp != null) {
							return false;
						}

						return true;
					}
				}
			} else if (p1.x == 0 && p1.y == -1) {
				pp = b.getPiece(p);
				if (pp != null) {
					return false;
				}
				return true;
			} else if ((p1.x == 1 && p1.y == 1) || (p1.x == -1 && p1.y == -1)) {
				Piece p3 = b.getPiece(p);
				if (p3.color == Color.WHITE)
					return true;
			}
			/*
			 * if (this.position.y == 7) { if ((p.y == this.position.y - 1 ||
			 * p.y == this.position.y - 2) && (this.position.x == p.x)) { return
			 * true; } } else if ((p.y == this.position.y - 1) &&
			 * (this.position.x == p.x)) { return true; } else if (p.x ==
			 * this.position.x - 1 && p.y == this.position.y - 1) { Piece p2 =
			 * b.getPiece(p); if (p2.color == Color.WHITE) return true; }
			 */
		}

		return false;
	}
}
