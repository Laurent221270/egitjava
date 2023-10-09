package com.arv.arrayeater.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.arv.arrayeater.controller.GameController;

public class GameSwingView implements GameViewable {

	GameController controller;
	JTextArea textArea;
	JFrame frame;
	ArrayEaterGridPanel eaterGrid;

	public void createAndShowGUI() {

		int width=500;
		
		// create main frame
		frame = new JFrame("MVC-SOLID-Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, 800);
		//frame.setMaximumSize(new Dimension(500,700));

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		
		// 2 modes de fonctionnement
		eaterGrid= new ArrayEaterGridPanel(EatColorMode.HIGHEST_CELL_VALUE_KEEP);
		//eaterGrid= new ArrayEaterGridPanel(EatColorMode.CELL_VALUE);
		contentPane.add(eaterGrid, BorderLayout.NORTH);		

		addControllerCommandTracker(contentPane);

		addControlPanel(contentPane, width);
		
		//frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Création du Panneau de controle avec champs texte pour définir les 
	 * paramètres du jeu 
	 * - Nb moves
	 * - temporisation
	 * - ... 
	 * @param contentPane
	 * @param width
	 */
	private void addControlPanel(Container contentPane, int width) {
		Container panelCtrl = new JPanel();
		panelCtrl.setSize(width, 20);
		panelCtrl.setLayout(new GridBagLayout());
		
		JTextField txtNbMoves = new JTextField("NbMoves");
		txtNbMoves.setColumns(300);
		txtNbMoves.setMinimumSize(new Dimension(80, 25));
		JTextField txtXXXXX = new JTextField("XXXXXX");
		txtXXXXX.setMinimumSize(new Dimension(80, 25));
		
		JButton btnLaunch = new JButton("Lancer");
		btnLaunch.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	int nbmoves=100;
		    	try {
		    		nbmoves= Integer.parseInt(txtNbMoves.getText());
		    	} catch (Exception exc) {
					// on garde la valeur par défaut
				}
		    	controller.setNumberOfMoves(nbmoves);
				controller.startGame();
		    }
		});
		
		panelCtrl.add(txtNbMoves);
		panelCtrl.add(txtXXXXX);
		panelCtrl.add(btnLaunch);
		
		contentPane.add(panelCtrl, BorderLayout.PAGE_END);
		
	}


	/**
	 * a simple place to display what the controller is telling us
	 * @param contentPane
	 */
	private void addControllerCommandTracker(Container contentPane) {
		textArea = new JTextArea("Game Status \n", 10, 300);
		textArea.setBackground(new Color(220,220,200));

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(5, 5, 200, 100);
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

	// all controls are added so they are centered horizontally in the area
//	private void addCenteredComponent(JComponent component, Container contentPane) {
//		component.setAlignmentX(Component.CENTER_ALIGNMENT);
//		contentPane.add(component);
//	}

	private void appendText(String text) {
		textArea.append(text + "\n");
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}

	@Override
	public void setController(GameController controller) {

		this.controller = controller;

	}

	@Override
	public void promptForArrayDim() {

		boolean dimOk = false;
		while (!dimOk) {
			String result = (String) JOptionPane.showInputDialog(frame, "Give a Array dimension", "Size",
					JOptionPane.PLAIN_MESSAGE, null, null, "");

			if (result == null || result.isEmpty()) {
				controller.nextAction("q");
			}
			int dim = 0;
			try {
				dim = Integer.parseInt(result);
				dimOk = true;
				controller.setArrayDim(dim);
				controller.startGame();
			}
			catch (NumberFormatException nfe) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void promptForNumberOfMoves() {
		boolean nbmovesOk = false;
		while (!nbmovesOk) {
			String result = (String) JOptionPane.showInputDialog(frame, "Give Number of Moves", "Moves",
					JOptionPane.PLAIN_MESSAGE, null, null, "");

			if (result == null || result.isEmpty()) {
				controller.nextAction("q");
			}
			int nbr = 0;
			try {
				nbr = Integer.parseInt(result);
				nbmovesOk = true;
				controller.setNumberOfMoves(nbr);
				controller.startGame();
			}
			catch (NumberFormatException nfe) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void promptForNewGame() {
		/*
		 */
		int newGame = JOptionPane.showConfirmDialog(frame, "Play again ?", "Play again", JOptionPane.YES_NO_OPTION);
		controller.nextAction(newGame == JOptionPane.NO_OPTION ? "q" : "");
	}

	@Override
	public void displayMessage(String string) {
		appendText(string);
	}

	@Override
	public void displayStatistics(String[] statistics) {
		for (String line : statistics) {
			displayMessage(line);
		}
		
	}

	@Override
	public void updateArray(int[][] tab) {
		eaterGrid.display(tab);
		frame.setVisible(true);
	}


	@Override
	public boolean isCellUpdatable() {
		return true;
	}


	@Override
	public void updateCell(int[] cell) {
		eaterGrid.update(cell);
		frame.setVisible(true);
	}

	@Override
	public void reset(int[][] tab) {
		eaterGrid.reset(tab);
		
	}

}
