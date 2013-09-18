package com.chess;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

public class Partner {
	Socket socket;
	private final Logger LOGGER = Logger.getLogger(Partner.class.getName());

	// private boolean isReceived=false;
	public Partner(Socket s) {
		this.socket = s;
	}

	public void send(Position oldPosition, Position newPosition) {

		DataOutputStream out = null;

		try {
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.writeInt(oldPosition.x);
			out.writeInt(oldPosition.y);
			out.writeInt(newPosition.x);
			out.writeInt(newPosition.y);
			LOGGER.info("send");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
