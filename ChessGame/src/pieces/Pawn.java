package pieces;

import board.ChessBoard;

public class Pawn
{
	private ChessPiece[][] currentBoard;
	
	
	public int[][] allPossibleMovesForThisPiece(int y, int x)
	{
		ChessBoard chessBoard = new ChessBoard();
		currentBoard = chessBoard.getBoard();
		int maxNumbOfMoves = 27;
		
		int[][] pawnPossibleMoves = new int[maxNumbOfMoves][2];
		int i = 0;
		//two cases for pawn moves, since white pawns move up and black pawns move down
		
		//white
		if(currentBoard[x][y].getColour() == 0)
		{
			//checks that the first space in front of the pawn in open
			if(currentBoard[x][y - 1] == null)
			{
				pawnPossibleMoves[i][0] = x;
				pawnPossibleMoves[i][1] = y - 1;
				i++;
				if(x == 6 && currentBoard[x][y - 2] == null)
				{
					pawnPossibleMoves[i][0] = x;
					pawnPossibleMoves[i][1] = y - 2;
					i++;
				}
			}
			//pawn attack
			if(currentBoard[x - 1][y - 1] != null && currentBoard[x - 1][y - 1].getColour() == 1)
			{
				pawnPossibleMoves[i][0] = x - 1;
				pawnPossibleMoves[i][1] = y -1;
				i++;
			}
			if(currentBoard[x - 1][y + 1] != null && currentBoard[x - 1][y + 1].getColour() == 1)
			{
				pawnPossibleMoves[i][0] = x - 1;
				pawnPossibleMoves[i][1] = y + 1;
				i++;
			}
		}
		
		//black
		else if(currentBoard[x][y].getColour() == 1)
		{
			//checks that the first space in front of the pawn in open
			if(currentBoard[x][y + 1] == null)
			{
				pawnPossibleMoves[i][0] = x ;
				pawnPossibleMoves[i][1] = y + 1;
				i++;
				if(x == 1 && currentBoard[x][y + 2] == null)
				{
					pawnPossibleMoves[i][0] = x;
					pawnPossibleMoves[i][1] = y + 2;
					i++;
				}
			}
			//pawn attack
			if(currentBoard[x + 1][y - 1] != null && currentBoard[x + 1][y - 1].getColour() == 0)
			{
				pawnPossibleMoves[i][0] = x + 1;
				pawnPossibleMoves[i][1] = y -1;
				i++;
			}
			if(currentBoard[x + 1][y + 1] != null && currentBoard[x + 1][y + 1].getColour() == 0)
			{
				pawnPossibleMoves[i][0] = x + 1;
				pawnPossibleMoves[i][1] = y + 1;
				i++;
			}
		}
		else
		{
			System.out.print("No possible pawn moves");
		}
		
		
		return pawnPossibleMoves;
	}
}