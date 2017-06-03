package pieces;

import board.Game;



public class Knight
{
	
	private ChessPiece[][] currentBoard;
	private int [][] knightPossibleMoves;
	private int colour;

	
	public int[][] allPossibleMovesForThisPiece(int x, int y)
	{
		this.currentBoard = Game.mainChessBoard.getBoard();
		this.knightPossibleMoves = new int[27][2];
		this.colour = this.currentBoard[x][y].getColour();
		
		int k = 0;
		if(x - 2 >= 0 && y - 1 >= 0)//Knight move pattern, L shape
		{
				
			if(this.currentBoard[x - 2][y - 1].getColour() != colour)//different colour means empty space or enemy
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
			if(this.currentBoard[x - 2][y + 1].getColour() != colour)
			{
				this.knightPossibleMoves[k][0] = x - 2;
				this.knightPossibleMoves[k][1] = y + 1;
				k++;
				System.out.printf("%d, %d \n", x - 2, y + 1);
			}
		}
		if(x - 1 >= 0 && y - 2 >= 0)
		{	
				if(this.currentBoard[x - 1][y - 2].getColour() != colour)
				{
					this.knightPossibleMoves[k][0] = x - 1;
					this.knightPossibleMoves[k][1] = y - 2;
					k++;
					System.out.printf("%d, %d \n", x - 1, y - 2);
				}
			}
			if(x - 1 >= 0 && y + 2 <= 7)
			{
				if(this.currentBoard[x - 1][y + 2].getColour() != colour)
				{
					this.knightPossibleMoves[k][0] = x - 1;
					this.knightPossibleMoves[k][1] = y + 2;
					k++;
					System.out.printf("%d, %d \n", x - 1, y + 2);
				}
			}
			if(x + 1 <= 7 && y - 2 >= 0)
			{
				if(this.currentBoard[x + 1][y - 2].getColour() != colour)
				{
					this.knightPossibleMoves[k][0] = x + 1;
					this.knightPossibleMoves[k][1] = y - 2;
					k++;
					System.out.printf("%d, %d \n", x + 1, y - 2);
				}
			}
			if(x + 1 <= 7 && y + 2 <= 7)
			{
				if(this.currentBoard[x + 1][y + 2].getColour() != colour)
				{
					this.knightPossibleMoves[k][0] = x + 1;
					this.knightPossibleMoves[k][1] = y + 2;
					k++;
					System.out.printf("%d, %d \n", x + 1, y + 2);
				}
			}
			if(x + 2 <= 7 && y - 1 >= 0)
			{
				if(this.currentBoard[x + 2][y - 1].getColour() != colour)
				{
					this.knightPossibleMoves[k][0] = x + 2;
					this.knightPossibleMoves[k][1] = y - 1;
					k++;
					System.out.printf("%d, %d \n", x + 2, y - 1);
				}
			}
			if(x + 2 <= 7 && y + 1 <= 7)
			{
				if(this.currentBoard[x + 2][y + 1].getColour() != colour)
				{
					this.knightPossibleMoves[k][0] = x + 2;
					this.knightPossibleMoves[k][1] = y + 1;
					k++;
					System.out.printf("%d, %d \n", x + 2, y + 1);
				}
			}
		
		return this.knightPossibleMoves;
	}
	
	/**
	 * Ensures that moving this piece does not result in an illegal check
	 * @param x the x coordinate of the knight
	 * @param y the y coordinate of the knight
	 * @return true or false
	 */
	private boolean illegalDiscoverCheck(int x, int y)
	{
		//There is probably a better way to do this
		
		
		King king = new King();//create new king to get the king position method
		int[] positionOfKing = king.getKingPosition(this.currentBoard[x][y].getColour());//get the position of the king that has the same colour as the piece being moved
		
		if(positionOfKing[0] - x != 0 && positionOfKing[1] - y != 0 && !(Math.abs(positionOfKing[0] - x) == Math.abs(positionOfKing[1] - y)))//if they are not on the same row, column, or diagonal, moving this peice cannot result in an illegal discover check
		{
			return false;
		}
		
		
		return false;
	}
}
