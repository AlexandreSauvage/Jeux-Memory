package com.JeuxMemory.java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChoixBoard {

	private JFrame frame;
	private JButton btnEasy;
	private JButton btnMedium;
	private JButton btnHard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoixBoard window = new ChoixBoard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChoixBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnEasy = new JButton("Easy (10)");
		btnEasy.addActionListener(choixNiveauHandler);
		frame.getContentPane().add(btnEasy, BorderLayout.WEST);
		
		btnMedium = new JButton("Medium (14)");
		btnMedium.addActionListener(choixNiveauHandler);
		frame.getContentPane().add(btnMedium, BorderLayout.CENTER);
		
		btnHard = new JButton("Hard (20)");
		btnHard.addActionListener(choixNiveauHandler);
		frame.getContentPane().add(btnHard, BorderLayout.EAST);
	}

	public JButton getBtnEasy() {
		return btnEasy;
	}
	public JButton getBtnMedium() {
		return btnMedium;
	}
	public JButton getBtnHard() {
		return btnHard;
	}
	
	private ActionListener choixNiveauHandler =  new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int tailleBoard = 0;
			if(btnEasy == e.getSource()){
				tailleBoard = 10;
			}else if(btnMedium == e.getSource()){
				tailleBoard = 14;
			}else {
				tailleBoard = 20;
			}
	        Board b = new Board(tailleBoard);
	        b.setPreferredSize(new Dimension(500,500)); //à la place de setSize
	        b.setLocation(500, 250);
	        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        b.pack();
	        b.setVisible(true);
	        ChoixBoard.this.frame.setVisible(false);
		}
	};
}
