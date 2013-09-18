package com.chess;

public class Knight extends Piece {

	@Override
	public boolean isValidPosition(Position p, Board b) {// TODO Auto-generated

		Position p1 = getDifference(p, this.getPosition());
		if ((Math.abs(p1.x) + Math.abs(p1.y) == 3)
				&& ((Math.abs(p1.x) != 0) && (Math.abs(p1.y) != 0))) {
			Piece pp = b.getPiece(p);
			if (pp != null && pp.getColor() == this.getColor()) {
				return false;
			}
			return true;
		}

		return false;
	}
}
