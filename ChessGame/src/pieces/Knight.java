package pieces;

import board.ChessBoard;



public class Knight
{
	
	private ChessPiece[][] currentBoard;
	
	public int[][] allPossibleMovesForThisPiece(int x, int y)
	{
		ChessBoard chessBoard = new ChessBoard();
		currentBoard = chessBoard.getBoard();
		int maxNumbOfMoves = 27;
		int[][] knightPossibleMoves = new int[maxNumbOfMoves][2];
		
		//checks all possible moves for the knight, there is a maximum of 8 for them
		//Leaving maxNumbOfMoves at 27 as it may intefear with he return value
		int i = 0;
		while(i < maxNumbOfMoves)
		{
			//checks that the knights move pattern in on the baord
			if(x - 2 >= 0 && y - 1 >= 0)
			{
				//if the space is empty the knight is free to move there
				if(currentBoard[x - 2][y - 1] == null)
				{
					knightPossibleMoves[i][0] = x - 2;
					knightPossibleMoves[i][1] = y - 1;
					i++;
				}//othersise the knight can only move there too attack
				else if( currentBoard[x - 2][y - 1].getColour() != currentBoard[x][y].getColour())
				{
					knightPossibleMoves[i][0] = x - 2;
					knightPossibleMoves[i][1] = y - 1;
					i++;
				}
			}
			if(x - 2 >= 0 && y + 1 <= 7)
			{
				if(currentBoard[x - 2][y + 1] == null)
				{
					knightPossibleMoves[i][0] = x - 2;
					knightPossibleMoves[i][1] = y + 1;
					i++;
				}
				else if(currentBoard[x - 2][y + 1].getColour() != currentBoard[x][y].getColour())
				{
					knightPossibleMoves[i][0] = x - 2;
					knightPossibleMoves[i][1] = y + 1;
					i++;
				}
			}
			if(x - 1 >= 0 && y - 2 >= 0)
			{
				if(currentBoard[x - 1][y - 2] == null)
				{
					knightPossibleMoves[i][0] = x - 1;
					knightPossibleMoves[i][1] = y - 2;
					i++;
				}
				else if(currentBoard[x - 1][y - 2].getColour() != currentBoard[x][y].getColour())
				{
					knightPossibleMoves[i][0] = x - 1;
					knightPossibleMoves[i][1] = y - 2;
					i++;
				}
			}
			if(x - 1 >= 0 && y + 2 <= 7)
			{
				if(currentBoard[x - 1][y + 2] == null)
				{
					knightPossibleMoves[i][0] = x - 1;
					knightPossibleMoves[i][1] = y + 2;
					i++;
				}
				else if(currentBoard[x - 1][y + 2].getColour() != currentBoard[x][y].getColour())
				{
					knightPossibleMoves[i][0] = x - 1;
					knightPossibleMoves[i][1] = y + 2;
					i++;
				}
			}
			if(x + 1 <= 7 && y - 2 >= 0)
			{
				if(currentBoard[x + 1][y - 2] == null)
				{
					knightPossibleMoves[i][0] = x + 1;
					knightPossibleMoves[i][1] = y - 2;
					i++;
				}
				else if(currentBoard[x + 1][y - 2].getColour() != currentBoard[x][y].getColour())
				{
					knightPossibleMoves[i][0] = x + 1;
					knightPossibleMoves[i][1] = y - 2;
					i++;
				}
			}
			if(x + 1 <= 7 && y + 2 <= 7)
			{
				if(currentBoard[x  + 1][y + 2] == null)
				{
					knightPossibleMoves[i][0] = x + 1;
					knightPossibleMoves[i][1] = y + 2;
					i++;
				}
				else if(currentBoard[x + 1][y + 2].getColour() != currentBoard[x][y].getColour())
				{
					knightPossibleMoves[i][0] = x + 1;
					knightPossibleMoves[i][1] = y + 2;
					i++;
				}
			}
			if(x + 2 <= 7 && y - 1 >= 0)
			{
				if(currentBoard[x + 2][y - 1] == null)
				{
					knightPossibleMoves[i][0] = x + 2;
					knightPossibleMoves[i][1] = y - 1;
					i++;
				}
				else if(currentBoard[x + 2][y - 1].getColour() != currentBoard[x][y].getColour())
				{
					knightPossibleMoves[i][0] = x + 2;
					knightPossibleMoves[i][1] = y - 1;
					i++;
				}
			}
			if(x + 2 <= 7 && y + 1 <= 7)
			{
				if(currentBoard[x + 2][y + 1] == null)
				{
					knightPossibleMoves[i][0] = x + 2;
					knightPossibleMoves[i][1] = y + 1;
					i++;
				}
				else if(currentBoard[x + 2][y + 1].getColour() != currentBoard[x][y].getColour())
				{
					knightPossibleMoves[i][0] = x + 2;
					knightPossibleMoves[i][1] = y + 1;
					i++;
				}
			}
			break;
		}
		
		return knightPossibleMoves;
	}
	
}
