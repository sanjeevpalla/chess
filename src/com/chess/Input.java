package com.chess;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Input extends JFrame implements ActionListener {
	private JRadioButton server, client;

	public Input() {
		JPanel radioPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		this.setLocation(300, 300);
		this.setSize(400, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		server = new JRadioButton("Server");
		client = new JRadioButton("Client");
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(server);
		buttonGroup.add(client);
		JButton submit = new JButton("Submit");
		submit.addActionListener(this);
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		radioPanel.add(server, BorderLayout.CENTER);
		radioPanel.add(client, BorderLayout.AFTER_LINE_ENDS);
		buttonPanel.add(submit, BorderLayout.CENTER);
		buttonPanel.add(cancel, BorderLayout.AFTER_LINE_ENDS);
		this.add(radioPanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.PAGE_END);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();
		if (button.getText().equals("Submit")) {
			if (server.isSelected()) {
				JOptionPane.showMessageDialog(this,
						"Server is waiting for client request.");
				Server s = new Server();
				this.setVisible(false);
				ChessBoard cb = new ChessBoard(new Board(), new Partner(
						s.socket));
			} else if (client.isSelected()) {
				String inetAdd = JOptionPane
						.showInputDialog("Enter IpAddress:");
				int port_number = Integer.parseInt(JOptionPane
						.showInputDialog("Enter port numbet:"));
				Client c = new Client(inetAdd, port_number);
				this.setVisible(false);
				Board b = new Board();
				b.isBlacksTurn = true;
				ChessBoard cb = new ChessBoard(b, new Partner(c.socket));

			} else {
				JOptionPane.showMessageDialog(this,
						"Please Select server or client.");
			}
		} else {
		}
	}
}
