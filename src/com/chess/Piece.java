package com.chess;

public abstract class Piece {
	Color color;
	Position position;
	boolean alive;

	public abstract boolean isValidPosition(Position position, Board b);

	public Position getDifference(Position newPosition, Position currentPosition) {
		Position p = new Position();
		p.x = newPosition.x - currentPosition.x;
		p.y = newPosition.y - currentPosition.y;
		return p;

	}

}