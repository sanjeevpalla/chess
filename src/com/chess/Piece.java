package com.chess;

public abstract class Piece {

	private Color color;
	private Position position;
	private boolean alive;
	public abstract boolean isValidPosition(Position position, Board b);
	public Position getDifference(Position newPosition, Position currentPosition) {
		Position p = new Position();
		p.x = newPosition.x - currentPosition.x;
		p.y = newPosition.y - currentPosition.y;
		return p;

	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean isAlive() {
		return alive;

	}

}