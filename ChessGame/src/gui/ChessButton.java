package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import board.Game;
import pieces.ChessPiece;

public class ChessButton extends JButton implements ActionListener
{

	//image icons
	private ImageIcon blackBishopIcon = new ImageIcon(this.getClass().getResource("Chess_bdt60.png"));
	private ImageIcon whiteBishopIcon = new ImageIcon(this.getClass().getResource("Chess_blt60.png"));
	private ImageIcon blackKingIcon = new ImageIcon(this.getClass().getResource("Chess_kdt60.png"));
	private ImageIcon whiteKingIcon = new ImageIcon(this.getClass().getResource("Chess_klt60.png"));
	private ImageIcon blackKnightIcon = new ImageIcon(this.getClass().getResource("Chess_ndt60.png"));
	private ImageIcon whiteKnightIcon = new ImageIcon(this.getClass().getResource("Chess_nlt60.png"));
	private ImageIcon blackPawnIcon = new ImageIcon(this.getClass().getResource("Chess_pdt60.png"));
	private ImageIcon whitePawnIcon = new ImageIcon(this.getClass().getResource("Chess_plt60.png"));
	private ImageIcon blackQueenIcon = new ImageIcon(this.getClass().getResource("Chess_qdt60.png"));
	private ImageIcon whiteQueenIcon = new ImageIcon(this.getClass().getResource("Chess_qlt60.png"));
	private ImageIcon blackRookIcon = new ImageIcon(this.getClass().getResource("Chess_rdt60.png"));
	private ImageIcon whiteRookIcon = new ImageIcon(this.getClass().getResource("Chess_rlt60.png"));
	
	
	private int[]userClick;
	private ChessPiece[][] currentBoard;
	public ChessButton()
	{
		addActionListener(this);//gives each ChessButton the ability to read clicks are user input
	}

	private int clickNumber = 0;//even means first click, odd means 2nd click
	public void actionPerformed(ActionEvent e) 
	{	
		this.userClick[0] = e.getActionCommand().charAt(1);//stores x coordinate of user click
		this.userClick[1] = e.getActionCommand().charAt(2);//stores y coordinate of user click
		
		if(clickNumber % 2 == 0)
		{
			Game.x1 = this.userClick[0];
			Game.y1 = this.userClick[1];		
		}
		else if(clickNumber % 2 == 1)
		{
			Game.x2 = this.userClick[0];
			Game.y2 = this.userClick[1];
		}
		this.clickNumber ++;
		
	}
	
	public int[] getUserClick()
	{
		return this.userClick;
	}
	
	public void iconSetting(int x, int y)
	{
		this.currentBoard = Game.mainChessBoard.getBoard();
		int colour = this.currentBoard[x][y].getColour();
		String type = this.currentBoard[x][y].getType();
		
		if(type.compareTo("Bishop") == 0 && colour == 1)
		{
			setIcon(this.blackBishopIcon);
		}
		else if(type.compareTo("Bishop") == 0 && colour == 0)
		{
			setIcon(this.whiteBishopIcon);
		}
		else if(type.compareTo("Knight") == 0 && colour == 1)
		{
			setIcon(this.blackKnightIcon);
		}
		else if(type.compareTo("Knight") == 0 && colour == 0)
		{
			setIcon(this.whiteKnightIcon);
		}
		else if(type.compareTo("Pawn") == 0 && colour == 1)
		{
			setIcon(this.blackPawnIcon);
		}
		else if(type.compareTo("Pawn") == 0 && colour == 0)
		{
			setIcon(this.whitePawnIcon);
		}
		else if(type.compareTo("Queen") == 0 && colour == 1)
		{
			setIcon(this.blackQueenIcon);
		}
		else if(type.compareTo("Queen") == 0 && colour == 0)
		{
			setIcon(this.whiteQueenIcon);
		}
		else if(type.compareTo("Rook") == 0 && colour == 1)
		{
			setIcon(this.blackRookIcon);
		}
		else if(type.compareTo("Rook") == 0 && colour == 0)
		{
			setIcon(this.whiteRookIcon);
		}
		else if(type.compareTo("King") == 0 && colour == 1)
		{
			setIcon(this.blackKingIcon);
		}
		else if(type.compareTo("King") == 0 && colour == 0)
		{
			setIcon(this.whiteKingIcon);
		}
		else if(colour == -1)
		{
			setIcon(null);
		}
		else
		{
			System.out.println("ERROR: ChessButton no Icon");
		}
	
	}

}
