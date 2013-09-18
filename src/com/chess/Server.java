package com.chess;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	Socket socket;
	private static final int PORT_NUMBER = 8888;

	public Server() {
		try {
			serverSocket = new ServerSocket(PORT_NUMBER);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			socket = serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}