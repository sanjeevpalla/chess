package com.chess;

public class Minister extends Piece {

	@Override
	public boolean isValidPosition(Position p, Board b) {
		Position p2 = new Position();
		p2.x = this.position.x;
		p2.y = this.position.y;
		Position p1 = getDifference(p, this.position);
		Piece pp = b.getPiece(p);
		if (pp != null && pp.color == this.color) {
			return false;
		}
		if (p1.x == 0 && p1.y == 0) {
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

		if (Math.abs(p1.x) == Math.abs(p1.y)) {
			if (p.x > p2.x && p.y > p2.y) {

				while (p.x > ++p2.x && p.y > ++p2.y) {
					pp = b.getPiece(p2);
					if (pp != null) {
						return false;
					}
				}
				return true;
			} else if (p.x < p2.x && p.y < p2.y) {

				while (p.x < --p2.x && p.y < --p2.y) {
					pp = b.getPiece(p2);
					if (pp != null) {
						return false;
					}
				}
				return true;
			} else if (p.x > p2.x && p.y < p2.y) {

				while (p.x > ++p2.x && p.y < --p2.y) {
					pp = b.getPiece(p2);
					if (pp != null) {
						return false;
					}
				}
				return true;
			} else if (p.x < p2.x && p.y > p2.y) {

				while (p.x < --p2.x && p.y > ++p2.y) {
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
