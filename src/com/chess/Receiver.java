package com.chess;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver extends Thread {
	private Socket socket;
	private ChessBoard chessBoard;

	public Receiver(Socket s, ChessBoard cb) {
		this.socket = s;
		this.chessBoard = cb;
	}

	@Override
	public void run() {
		DataInputStream in = null;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Position oldPosition = new Position();
		Position newPosition = new Position();
		try {
			oldPosition.x = in.readInt();
			oldPosition.y = in.readInt();
			newPosition.x = in.readInt();
			newPosition.y = in.readInt();
			chessBoard.forFirstClick(oldPosition);
			chessBoard.forSecondClick(newPosition);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
