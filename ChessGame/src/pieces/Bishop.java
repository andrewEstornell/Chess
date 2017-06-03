package pieces;

import board.ChessBoard;
import board.Game;

public class Bishop 
{
	private ChessPiece[][] currentBoard;//used to check the state of board
	private int[][] bishopPossibleMoves;//stores all possible moves for this bishop
	private ChessBoard chessBoard;//creates a new chess board to access getBoard()
	private int colour;
	
	public int[][] allPossibleMovesForThisPiece(int x, int y)//takes in the current position of the peice the user wants to mave and generates all possible moves
	{
		this.chessBoard = Game.mainChessBoard;//Initializes the chess board
		this.currentBoard = chessBoard.getBoard();//stores current state of the board in curretnBoard
		this.bishopPossibleMoves = new int[27][2];//stores all moves this bishop can make
		
		this.colour = currentBoard[x][y].getColour();
		int i = 1;//start at 1 since this bishop cannot move to (x + 0,y + 0)
		int k = 0;//counting for bishopPossibleMoves
		
		
		//one loop per diagonal, (4 of them)
		//possibly a way to exploit symmetry to make more efficient
		
		while(x + i <=7 && y + i <= 7)//checks the diagonal, in this case top left to bottom right
		{
			if(this.currentBoard[x + i][y + i].getType().charAt(0) == 'E')//if the square is empty, this is a valid move
			{
				this.bishopPossibleMoves[k][0] = x + i;
				this.bishopPossibleMoves[k][1] = y + i;
				i++;
				k++;
				continue;
			}
			else if(this.currentBoard[x + i][y + i].getColour() != this.colour)//if the square holds an enemey then it is valid, but we need not check furtheer
			{
				this.bishopPossibleMoves[k][0] = x + i;
				this.bishopPossibleMoves[k][1] = y + i;
				k++;
				break;
			}
			else if(this.currentBoard[x + i][y + i].getColour() != this.colour)//if the square contains a friendly, then it is invalid and we need not check fruther
			{
				break;
			}
		}
		
		i = 1;//reset counter
		
		
		while(x - i >= 0 && y + i <= 7)//checks the diagonal, in this case top left to bottom right
		{
			if(this.currentBoard[x - i][y + i].getType().charAt(0) == 'E')//if the square is empty, this is a valid move
			{
				this.bishopPossibleMoves[k][0] = x - i;
				this.bishopPossibleMoves[k][1] = y + i;
				i++;
				k++;
				continue;
			}
			else if(this.currentBoard[x - i][y + i].getColour() != this.colour)//if the square holds an enemey then it is valid, but we need not check furtheer
			{
				this.bishopPossibleMoves[k][0] = x - i;
				this.bishopPossibleMoves[k][1] = y + i;
				k++;
				break;
			}
			else if(this.currentBoard[x - i][y + i].getColour() != this.colour)//if the square contains a friendly, then it is invalid and we need not check fruther
			{
				break;
			}
		}
		
		i = 1;//reset counter
		
		
		while(x + i <=7 && y - i >= 0)//checks the diagonal, in this case top left to bottom right
		{
			if(this.currentBoard[x + i][y - i].getType().charAt(0) == 'E')//if the square is empty, this is a valid move
			{
				this.bishopPossibleMoves[k][0] = x + i;
				this.bishopPossibleMoves[k][1] = y - i;
				i++;
				k++;
				continue;
			}
			else if(this.currentBoard[x + i][y - i].getColour() != this.colour)//if the square holds an enemy then it is valid, but we need not check furtheer
			{
				this.bishopPossibleMoves[k][0] = x + i;
				this.bishopPossibleMoves[k][1] = y - i;
				k++;
				break;
			}
			else if(this.currentBoard[x + i][y - i].getColour() != this.colour)//if the square contains a friendly, then it is invalid and we need not check fruther
			{
				break;
			}
		}
		
		i = 1;//reset counter
		
		
		
		while(x - i >= 0 && y - i >= 0)//checks the diagonal, in this case top left to bottom right
		{
			if(this.currentBoard[x - i][y - i].getType().charAt(0) == 'E')//if the square is empty, this is a valid move
			{
				this.bishopPossibleMoves[k][0] = x - i;
				this.bishopPossibleMoves[k][1] = y - i;
				i++;
				k++;
				continue;
			}
			else if(this.currentBoard[x - i][y - i].getColour() != this.colour)//if the square holds an enemey then it is valid, but we need not check furtheer
			{
				this.bishopPossibleMoves[k][0] = x - i;
				this.bishopPossibleMoves[k][1] = y - i;
				k++;
				break;
			}
			else if(this.currentBoard[x - i][y - i].getColour() != this.colour)//if the square contains a friendly, then it is invalid and we need not check fruther
			{
				break;
			}
		}
		

		return this.bishopPossibleMoves;
	}
}
