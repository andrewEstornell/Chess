package pieces;

import board.Game;



public class Knight
{
	
	private int [][] knightPossibleMoves;
	private int colour;

	
	public int[][] allPossibleMovesForThisPiece(int x, int y, ChessPiece[][] currentBoard)
	{
		this.knightPossibleMoves = new int[27][2];
		this.colour = currentBoard[x][y].getColour();
		
		int k = 0;
		if(x - 2 >= 0 && y - 1 >= 0)//Knight move pattern, L shape
		{
				
			if(currentBoard[x - 2][y - 1].getColour() != colour)//different colour means empty space or enemy
			{
				this.knightPossibleMoves[k][0] = x - 2;
				this.knightPossibleMoves[k][1] = y - 1;
				k++;
				//printout for debugging
				System.out.printf("%d, %d \n", x - 2, y - 1);
			}
		}
		if(x - 2 >= 0 && y + 1 <= 7)
		{
			if(currentBoard[x - 2][y + 1].getColour() != colour)
			{
				this.knightPossibleMoves[k][0] = x - 2;
				this.knightPossibleMoves[k][1] = y + 1;
				k++;
				System.out.printf("%d, %d \n", x - 2, y + 1);
			}
		}
		if(x - 1 >= 0 && y - 2 >= 0)
		{	
				if(currentBoard[x - 1][y - 2].getColour() != colour)
				{
					this.knightPossibleMoves[k][0] = x - 1;
					this.knightPossibleMoves[k][1] = y - 2;
					k++;
					System.out.printf("%d, %d \n", x - 1, y - 2);
				}
			}
			if(x - 1 >= 0 && y + 2 <= 7)
			{
				if(currentBoard[x - 1][y + 2].getColour() != colour)
				{
					this.knightPossibleMoves[k][0] = x - 1;
					this.knightPossibleMoves[k][1] = y + 2;
					k++;
					System.out.printf("%d, %d \n", x - 1, y + 2);
				}
			}
			if(x + 1 <= 7 && y - 2 >= 0)
			{
				if(currentBoard[x + 1][y - 2].getColour() != colour)
				{
					this.knightPossibleMoves[k][0] = x + 1;
					this.knightPossibleMoves[k][1] = y - 2;
					k++;
					System.out.printf("%d, %d \n", x + 1, y - 2);
				}
			}
			if(x + 1 <= 7 && y + 2 <= 7)
			{
				if(currentBoard[x + 1][y + 2].getColour() != colour)
				{
					this.knightPossibleMoves[k][0] = x + 1;
					this.knightPossibleMoves[k][1] = y + 2;
					k++;
					System.out.printf("%d, %d \n", x + 1, y + 2);
				}
			}
			if(x + 2 <= 7 && y - 1 >= 0)
			{
				if(currentBoard[x + 2][y - 1].getColour() != colour)
				{
					this.knightPossibleMoves[k][0] = x + 2;
					this.knightPossibleMoves[k][1] = y - 1;
					k++;
					System.out.printf("%d, %d \n", x + 2, y - 1);
				}
			}
			if(x + 2 <= 7 && y + 1 <= 7)
			{
				if(currentBoard[x + 2][y + 1].getColour() != colour)
				{
					this.knightPossibleMoves[k][0] = x + 2;
					this.knightPossibleMoves[k][1] = y + 1;
					k++;
					System.out.printf("%d, %d \n", x + 2, y + 1);
				}
			}
		
		return this.knightPossibleMoves;
	}
}
