package board;

import java.util.Scanner;
import gui.ChessButton;
import gui.GUI;
import pieces.ChessPiece;
import pieces.King;

public class Game extends ChessBoard
{

	public static int[][] moveList = new int[200][4];
	
	public static GUI gui = new GUI();
	public static ChessButton[][] userGUI = new ChessButton[8][8];
	
	public static ChessBoard mainChessBoard = new ChessBoard(); // user facing chess board
	public static ChessPiece[][] mainBoard = new ChessPiece[8][8];

	public static ChessBoard testChessBoard = new ChessBoard();
	public static ChessPiece[][] testBoard = new ChessPiece[8][8];
	
	
	public static boolean blackLongCastle = true;
	public static boolean blackShortCastle = true;
	public static boolean whiteLongCastle = true;
	public static boolean whiteShortCastle = true;

	
	public static int x1;
	public static int x2;
	public static int y1;
	public static int y2;
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); 
		mainBoard = mainChessBoard.getBoard();
		userGUI = gui.getGUI();
		
		
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
			x1 = -1;//reset moves variables
			x2 = -1;
			y1 = -1;
			y2 = -1;
			
			
				int[] firstClick = gui.getMoveGUI();
				x1 = firstClick[0];
				y1 = firstClick[1];
				
				int[] secondClick = gui.getMoveGUI();
				x2 = secondClick[0];
				y2 = secondClick[1];
			
			
			//gets next move
			//need a better method but this will do for now
			
			
			/*int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			*/
			
			//testChessBoard = new ChessBoard(mainBoard);
			//testBoard = testChessBoard.getBoard();
			King king = new King();
			
			int playerColour = mainBoard[x1][y1].getColour();
			if(x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0)
			{
					mainChessBoard.move(x1, y1, x2, y2);
			}
			else
			{
				System.out.println("Not Valid Move On Test Board");
			}
			
			if(mainChessBoard.isStalemate((playerColour + 1) % 2))
			{
				System.out.println("Draw");
				break;
			}
		}
	}
	
	
	
	
}
