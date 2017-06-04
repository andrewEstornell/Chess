package board;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import gui.ChessButton;
import gui.GUI;
import pieces.ChessPiece;

public class Game extends ChessBoard
{

	public static GUI newGUI = new GUI();
	public static ChessButton[][] userGUI = new ChessButton[8][8];
	public static  ChessBoard mainChessBoard = new ChessBoard();
	public static  ChessPiece[][] mainBoard = new ChessPiece[8][8];
	
	
	public static int x1;
	public static int x2;
	public static int y1;
	public static int y2;
	
	public static void main(String[] args) throws InterruptedException
	{
		Scanner scan = new Scanner(System.in); 
		mainBoard = mainChessBoard.getBoard();
		userGUI = newGUI.getGUI();
		for(int i = 0; i < 8; i++)//sets icons of all pieces
		{
			for(int j = 0; j < 8; j++)
			{
				userGUI[i][j].iconSetting(i, j);
			}
		}
		//plays chess and displays it to the user via the terminal
		while(true)
		{
			//prints out current state of the board
			for(int i = 0; i < 8; i ++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(mainBoard[i][j].getColour() == -1)
					{
						System.out.print("   ");
					}
					else
					{
						System.out.print(mainBoard[i][j].getType().charAt(0) + "" + mainBoard[i][j].getColour() + " ");
					}
				}
				System.out.print("\n");
			}
			
			
			//gets next move
			//need a better method but this will do for now
			
			
			/*int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			*/
			
			
			TimeUnit.SECONDS.sleep(10);
			mainChessBoard.move(x1, y1, x2, y2);
		}
	}
	
	
	
	
}
