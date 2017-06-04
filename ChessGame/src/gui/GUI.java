package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame
{
	
	private JPanel panel = new JPanel();
	private ChessButton buttons[][] = new ChessButton[8][8];
	
	public GUI()
	{
		//ends program when window is exited
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//dimensions of the board
		setSize(700,700);
		//does not allow the user to resize the board, may change later if we get better with scaling
		setResizable(false);
		
		//sets up an 8x8 array that we will add buttons to\
		this.panel.setLayout(new GridLayout(8, 8));
		
		//creates the actual buttons
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//Initializes the button
				this.buttons[i][j] = new ChessButton();
				//colors every offset buttons black creating the checker board effect

				if((i + j) % 2 != 0)
				{
					//quite an accosting color, will need to change later
					this.buttons[i][j].setBackground(Color.BLUE);
				}
				this.panel.add(buttons[i][j]);
				this.buttons[i][j].setActionCommand(i +""+ j);
			}
		}
		//adds the grid of buttons to the window
		add(this.panel);
		
		//displays the window to the user
		setVisible(true);
	}
	
	public ChessButton[][] getGUI()
	{
		return this.buttons;
	}
}
