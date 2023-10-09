package com.arv.arrayeater.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.ColorModel;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ArrayEaterGridPanel extends JPanel {

	private static final long serialVersionUID= 1234567L;
	
	private JButton[][] tabButtons;
	private int currentDim;
	private EatColorMode eatColorMode= EatColorMode.CELL_VALUE;
	private int highestCellValue;
	private Color currentColor;
	
	public ArrayEaterGridPanel() {
		super();
		currentDim=-1;
		highestCellValue= -1;
	}

	public ArrayEaterGridPanel(EatColorMode mode) {
		this();
		eatColorMode= mode;
	}
	
	private void addAButton(int y, int x, GridBagConstraints c, int val) {
		JButton button = new JButton(val+"");		
		Font font= (button.getFont()).deriveFont(8.0f);
		button.setFont(font);
		button.setMargin(new Insets(1, 1, 1, 1));
		//button.setMinimumSize(new Dimension(20,20));
		c.gridx = x;
		c.gridy = y;
		add(button, c);
		tabButtons[y][x]= button;
	}

	private void populateButtons(int[][] tab) {

		GridBagConstraints c = new GridBagConstraints();
		// natural height, maximum width
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.1;
		c.weighty = 0.1;

		int dim = tab.length;
		setLayout(new GridBagLayout());
		for (int y = 0; y < dim; y++) {
			for (int x = 0; x < dim; x++) {
				addAButton(y, x, c, tab[y][x]);
			}
		}
	}

	private void updateButtons(int[][] tab) {
		int dim = tab.length;
		for (int y = 0; y < dim; y++) {
			for (int x = 0; x < dim; x++) {
				JButton b= tabButtons[y][x];
				int bVal= Integer.parseInt(b.getText());
				if(tab[y][x] != bVal) {
					b.setText(tab[y][x]+"");
					updateButtonColor(b);
				}
			}
		}
	}
	
	/**
	 * Reset de la grille
	 */
	public void reset(int[][] tab) {
		resetButtons(tab);
	}
	
	private void resetButtons(int[][] tab) {
		int dim = tabButtons.length;
		for (int y = 0; y < dim; y++) {
			for (int x = 0; x < dim; x++) {
				JButton b= tabButtons[y][x];				
				b.setBackground(new Color(250, 250, 250));
				b.setText(tab[y][x]+"");
			}
		}
	}
	

	private void updateButtonColor(JButton b) {
		int bVal = Integer.parseInt(b.getText());
		/*
		 * boolean isOp= b.isOpaque(); //Color color= b.getBackground(); Graphics
		 * graphics= b.getGraphics(); Color color= graphics.getColor();
		 * graphics.setColor(new Color(color.getRed()+20, color.getGreen()+10,
		 * color.getBlue()+10)); b.update(graphics);
		 */
		// System.out.println("prev color="+color);
		// color= new Color(color.getRed(), color.getGreen(), color.getBlue()+2);
		// System.out.println("new color="+color);

		switch (eatColorMode) {
			case CELL_VALUE:
				computeCurrentColor(bVal);
				break;
			case HIGHEST_CELL_VALUE_KEEP:
				if(highestCellValue ==-1 || bVal > highestCellValue) {
					highestCellValue = bVal;
					computeCurrentColor(bVal);
				}
				break;
			default:
				this.currentColor = Color.getHSBColor(0.5f, 0.1f, 0.3f);
				break;
		}
		b.setBackground(this.currentColor);
	}

	private void computeCurrentColor(int bVal) {
		//float hue = 0.58f + (8f/360 * bVal); //210° + (8° x bVal)
		float hue = 0.50f + (bVal * bVal * 15f/360 ); //180° + (bVal^2 * 15°)
		float saturation= 0.09f;
		float brightness= 0.8f;
		float angle = (float)(360 * (hue - Math.floor(hue)));
		this.currentColor = Color.getHSBColor(hue, saturation, brightness);
		System.out.println("hue=" + hue + " (angle= " + angle + ") - saturation=" + saturation + " - brightness=" + brightness);
	}

	/**
	 * update 1 seul bouton 
	 * cell = [y, x, val]
	 * @param cell
	 */
	private void updateButton(int[] cell) {
		int y= cell[0];
		int x= cell[1];
		JButton b= tabButtons[y][x];
		b.setText(cell[2]+"");
		updateButtonColor(b);
	}

	public void display(int[][] tab) {
		int dim= tab.length;
		if(dim != currentDim) {
			tabButtons = new JButton[dim][dim];
			populateButtons(tab);
			currentDim= dim;
		} else {
			pause(100);
			updateButtons(tab);
		}
	}


	private void pause(int duree) {
		try {
			Thread.sleep(duree);
			//System.out.println("finPause");
		}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}


	public void update(int[] cell) {
		pause(100);
		updateButton(cell);
		
	}



	
	
	
}
