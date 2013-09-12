package com.chess;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ChessBoard extends JFrame {

	Image img;

	public ChessBoard() {
		// setPreferredSize(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setBackground(Color.);
		img = Toolkit.getDefaultToolkit().createImage(
				"C:/Users/ASHOK/Desktop/FigurinesWin/black.ico");
		this.setSize(800, 800);
		this.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		int x = 0, y = 0;
		int x1 = 100, y1 = 0;
		for (int i = 0; i < 7; i++) {
			x = 0;
			x1 = 100;
			for (int j = 0; j < 7; j++) {
				if (i % 2 != 0) {
					g.drawRect(x, y, 100, 100);
					g.fillRect(x1, y1, 100, 100);
				} else {

					g.fillRect(x, y, 100, 100);
					g.drawRect(x1, y1, 100, 100);

				}
				x += 200;
				x1 += 200;
			}

			y += 100;
			y1 += 100;

		}
		g.drawImage(img, 100, 0, this);

	}

}
