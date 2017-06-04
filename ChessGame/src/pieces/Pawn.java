package pieces;

import board.ChessBoard;
import board.Game;

public class Pawn
{
	private ChessPiece[][] currentBoard;//used to check the state of board
	private int[][] pawnPossibleMoves;//stores all possible moves for this pawn
	private ChessBoard chessBoard;//creates a new chess board to access getBoard()
	
	
	public int[][] allPossibleMovesForThisPiece(int x, int y)
	{
		this.chessBoard = Game.mainChessBoard;
		this.currentBoard = chessBoard.getBoard();
		this.pawnPossibleMoves = new int[27][2];
		
		
		int i = 0;
		//two cases for pawn moves, since white pawns move up and black pawns move down
		
		
		if(this.currentBoard[x][y].getColour() == 0)//white
		{
			if(x - 1 >= 0)
			{
				if(this.currentBoard[x - 1][y].getColour() == -1)//checks that the first space in front of the pawn in open
				{
					this.pawnPossibleMoves[i][0] = x - 1;
					this.pawnPossibleMoves[i][1] = y;
					i++;
					if(x == 6 && this.currentBoard[x - 2][y].getColour() == -1)//if the pawn has not been moved and the first square is open, check the 2nd.
					{
						this.pawnPossibleMoves[i][0] = x - 2;
						this.pawnPossibleMoves[i][1] = y;
						i++;
					}
				}
			//pawn attack
				if(y - 1 >= 0)
				{
					if(this.currentBoard[x - 1][y - 1].getColour() == 1)//diagonal attack if enemy piece
					{
						this.pawnPossibleMoves[i][0] = x - 1;
						this.pawnPossibleMoves[i][1] = y -1;
						i++;
					}
				}
				if(y + 1 <= 7)
				{
					if(this.currentBoard[x - 1][y + 1].getColour() == 1)
					{
						this.pawnPossibleMoves[i][0] = x - 1;
						this.pawnPossibleMoves[i][1] = y + 1;
						i++;
					}
				}
			}
		}
		
		//black
		else if(this.currentBoard[x][y].getColour() == 1)
		{
			if(x + 1 <= 7)
			{
				if(this.currentBoard[x + 1][y].getColour() == -1)//checks that the first space in front of the pawn in open
				{
					this.pawnPossibleMoves[i][0] = x + 1;
					this.pawnPossibleMoves[i][1] = y;
					i++;
					if(x == 1 && this.currentBoard[x + 2][y].getColour() == -1)
					{
						this.pawnPossibleMoves[i][0] = x + 2;
						this.pawnPossibleMoves[i][1] = y;
						i++;
					}
				}
			
			
			//pawn attack
				if(y - 1 >= 0)
				{
					if(this.currentBoard[x + 1][y - 1].getColour() == 0)
					{
						this.pawnPossibleMoves[i][0] = x + 1;
						this.pawnPossibleMoves[i][1] = y -1;
						i++;
					}
				}
				if(y + 1 <= 7)
				{
					if(this.currentBoard[x + 1][y + 1].getColour() == 0)
					{
						this.pawnPossibleMoves[i][0] = x + 1;
						this.pawnPossibleMoves[i][1] = y + 1;
						i++;
					}
				}
			}
		}
		else
		{
			System.out.print("No possible pawn moves");
		}
		
		
		return this.pawnPossibleMoves;
	}
}