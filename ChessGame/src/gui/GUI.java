package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame
{
	
	private boolean wasClicked;
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
		this.wasClicked = false;
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
	
	public void resetClick()
	{
		this.wasClicked = false;
	}
	
	public void click()
	{
		this.wasClicked = true;
	}
	public boolean wasClicked()
	{
		return this.wasClicked;
	}
	
	/**
	 * 
	 * @return the coordinates of the GUI button the clicked on
	 */
	public int[] getMoveGUI()
	{
		int[] userMove = new int[2];
		while(!this.wasClicked())
		{
			boolean breakOut = false; // used to breakout of nested loop
			int i = 0;
			while(i < 8) // checks through for action listener change
			{
				int j = 0;
				while(j < 8)
				{
					if(this.buttons[i][j].getUserClick()[0] >= 0 && this.buttons[i][j].getUserClick()[1] >= 0) // each button has default of -1, -1, when clicked they are change to their coordinate
					{
						// stores the click 
						userMove[0] = this.buttons[i][j].getUserClick()[0];
						userMove[1] = this.buttons[i][j].getUserClick()[1];
						
						buttons[i][j].resetUserClick(); // resets the button to default -1, -1
						breakOut = true;
						break;
					}
					j++;
				}
				if(breakOut)
				{
					break;
				}
				i++;
			}
		}
		this.resetClick();
		return userMove;
	}
}
