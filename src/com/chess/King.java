package com.chess;

public class King extends Piece {

	@Override
	public boolean isValidPosition(Position p, Board b) {
		Position p1 = getDifference(p, this.position);
		int z = Math.abs(p1.x) + Math.abs(p1.y);
		if (z == 1 || z == 2) {
			Piece pp = b.getPiece(p);
			if (pp.color != this.color) {
				return true;
			}
		}
		return false;
	}

}
