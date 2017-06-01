package board;

import java.util.Scanner;

import pieces.ChessPiece;

public class Game 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		
		ChessBoard chessBoard = new ChessBoard();
		ChessPiece[][] mainBoard = new ChessPiece[8][8]; 
		mainBoard = chessBoard.getBoard();
		
		//plays chess and displays it to the user via the termial
		while(true)
		{
			//prints out current state of the board
			for(int i = 0; i < 8; i ++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(mainBoard[i][j] == null)
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
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			
			chessBoard.move(x1, y1, x2, y2);
		}
	}
	
	
	
	
}
