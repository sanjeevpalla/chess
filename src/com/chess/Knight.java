package com.chess;

public class Knight extends Piece {

	@Override
	public boolean isValidPosition(Position p, Board b) {// TODO Auto-generated
		Position p1 = getDifference(p, this.position);
		if (Math.abs(p1.x) + Math.abs(p1.y) == 3) {
			Piece pp = b.getPiece(p);
			if (pp != null && pp.color == this.color) {
				return false;
			}
			return true;
		}

		return false;
	}
}
