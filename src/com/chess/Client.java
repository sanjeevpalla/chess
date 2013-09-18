package com.chess;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client {
	Socket socket;

	public Client(String ipaddress, int port) {
		try {
			socket = new Socket(ipaddress, port);
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "invalid ip adress");
			// e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			// e.printStackTrace();
		}

	}

}
