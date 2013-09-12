package com.chess;

public class Bishop extends Piece {

	@Override
	public boolean isValidPosition(Position p, Board b) {
		Position p2 = new Position();
		p2.x = this.position.x;
		p2.y = this.position.y;
		Position p1 = getDifference(p, this.position);
		Piece p4 = b.getPiece(p);
		if (p4 != null && p4.color == this.color) {
			return false;
		}
		if (p1.x == 0 || p1.y == 0) {
			return false;
		}
		if (Math.abs(p1.x) == Math.abs(p1.y)) {
			if (p.x > p2.x && p.y > p2.y) {

				while (p.x > ++p2.x && p.y > ++p2.y) {
					Piece pp = b.getPiece(p2);
					if (pp != null) {
						return false;
					}
				}
				return true;
			} else if (p.x < p2.x && p.y < p2.y) {

				while (p.x < --p2.x && p.y < --p2.y) {
					Piece pp = b.getPiece(p2);
					if (pp != null) {
						return false;
					}
				}
				return true;
			} else if (p.x > p2.x && p.y < p2.y) {

				while (p.x > ++p2.x && p.y < --p2.y) {
					Piece pp = b.getPiece(p2);
					if (pp != null) {
						return false;
					}
				}
				return true;
			} else if (p.x < p2.x && p.y > p2.y) {

				while (p.x < --p2.x && p.y > ++p2.y) {
					Piece pp = b.getPiece(p2);
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
