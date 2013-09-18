package com.chess;

public class Rook extends Piece {

	@Override
	public boolean isValidPosition(Position p, Board b) {
		/*
		 * if ((this.position.x == p.x) || (this.position.y == p.y)) return
		 * true;
		 */
		Position p2 = new Position();
		p2.x = this.getPosition().x;
		p2.y = this.getPosition().y;
		Position p1 = getDifference(p, this.getPosition());

		if (p1.x == 0 && p1.y == 0) {
			return false;
		}
		Piece pp = b.getPiece(p);
		if (pp != null && pp.getColor() == this.getColor()) {

			return false;
		}
		if (p1.x == 0) {
			if (p.y > p2.y) {
				while (p.y > ++p2.y) {
					pp = b.getPiece(p2);
					if (pp != null) {
						return false;
					}
				}
				return true;
			}

			else if (p.y < p2.y) {
				while (p.y < --p2.y) {
					pp = b.getPiece(p2);
					if (pp != null) {
						return false;
					}
				}
				return true;

			}
		} else if (p1.y == 0) {
			if (p.x > p2.x) {
				while (p.x > ++p2.x) {
					pp = b.getPiece(p2);
					if (pp != null) {
						return false;
					}
				}
				return true;
			}

			else if (p.x < p2.x) {
				while (p.x < --p2.x) {
					pp = b.getPiece(p2);
					if (pp != null) {
						return false;
					}
				}
				return true;

			}
		}

		return false;
	}

}
