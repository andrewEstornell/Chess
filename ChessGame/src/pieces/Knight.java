package pieces;

import board.ChessBoard;

public class Knight extends ChessBoard
{

	private ChessPiece[][] currentBoard;
	
	public int[][] allPossibleMovesForThisPiece(int x, int y)
	{
		currentBoard = this.getBoard();
		int maxNumbOfMoves = 27;
		int[][] knightPossibleMoves = new int[maxNumbOfMoves][2];
		
		//checks for all possible moves for the knight, there is a maximum of 8 for them
		//Leaving maxNumbOfMoves at 27 as it may intefear with he return value
		int i = 0;
		while(i < maxNumbOfMoves)
		{
			//checks that each possible knight move is on the board and is no occupied by a piece of the same colour
			if(x - 2 >= 0 && y - 1 >= 0 && currentBoard[x - 2][y - 1].getColour() != currentBoard[x][y].getColour())
			{
				knightPossibleMoves[i][0] = x - 2;
				knightPossibleMoves[i][1] = y - 1;
				i++;
			}
			if(x - 2 >= 0 && y + 1 <= 7 && currentBoard[x - 2][y + 1].getColour() != currentBoard[x][y].getColour())
			{
				knightPossibleMoves[i][0] = x - 2;
				knightPossibleMoves[i][1] = y + 1;
				i++;
			}
			if(x - 1 >= 0 && y - 2 >= 0 && currentBoard[x - 1][y - 2].getColour() != currentBoard[x][y].getColour())
			{
				knightPossibleMoves[i][0] = x - 1;
				knightPossibleMoves[i][1] = y - 2;
				i++;
			}
			if(x - 1 >= 0 && y + 2 <= 7 && currentBoard[x - 1][y + 2].getColour() != currentBoard[x][y].getColour())
			{
				knightPossibleMoves[i][0] = x - 1;
				knightPossibleMoves[i][1] = y + 2;
				i++;
			}
			if(x + 1 <= 7 && y - 2 >= 0 && currentBoard[x + 1][y - 2].getColour() != currentBoard[x][y].getColour())
			{
				knightPossibleMoves[i][0] = x + 1;
				knightPossibleMoves[i][1] = y - 2;
				i++;
			}
			if(x + 1 <= 7 && y + 2 <= 7 && currentBoard[x + 2][y + 2].getColour() != currentBoard[x][y].getColour())
			{
				knightPossibleMoves[i][0] = x + 1;
				knightPossibleMoves[i][1] = y + 2;
				i++;
			}
			if(x + 2 <= 7 && y - 1 >= 0 && currentBoard[x + 2][y - 1].getColour() != currentBoard[x][y].getColour())
			{
				knightPossibleMoves[i][0] = x + 2;
				knightPossibleMoves[i][1] = y - 1;
				i++;
			}
			if(x + 2 <= 7 && y + 1 <= 7 && currentBoard[x + 2][y + 1].getColour() != currentBoard[x][y].getColour())
			{
				knightPossibleMoves[i][0] = x + 2;
				knightPossibleMoves[i][1] = y + 1;
				i++;
			}
			break;
		}
		
		return knightPossibleMoves;
	}
	
}
