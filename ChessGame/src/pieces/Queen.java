package pieces;

import board.Game;

public class Queen 
{
	private int[][] queenPossibleMoves;
	private ChessPiece[][] currentBoard;
	private int colour;
	
	/**
	 * 
	 * @param x x coordinate of this queen
	 * @param y y coordinate of this queen
	 * @return an array of all possible moves this queen can make;
	 */
	public int[][] allPossibleMovesForThisPiece(int x, int y)
	{
		this.currentBoard = Game.mainChessBoard.getBoard();
		this.queenPossibleMoves = new int[27][2];
		
		this.colour = currentBoard[x][y].getColour();
		int i = 1;//start at 1 since this queen cannot move to (x + 0,y + 0)
		int k = 0;//counting for queenPossibleMoves
		
		
		//one loop per diagonal, (4 of them)
		//possibly a way to exploit symmetry to make more efficient
		
		while(x + i <=7 && y + i <= 7)//checks the diagonal, in this case top left to bottom right
		{
			if(this.currentBoard[x + i][y + i].getType().charAt(0) == 'E')//if the square is empty, this is a valid move
			{
				this.queenPossibleMoves[k][0] = x + i;
				this.queenPossibleMoves[k][1] = y + i;
				i++;
				k++;
				continue;
			}
			else if(this.currentBoard[x + i][y + i].getColour() != this.colour)//if the square holds an enemey then it is valid, but we need not check furtheer
			{
				this.queenPossibleMoves[k][0] = x + i;
				this.queenPossibleMoves[k][1] = y + i;
				k++;
				break;
			}
			else if(this.currentBoard[x + i][y + i].getColour() != this.colour)//if the square contains a friendly, then it is invalid and we need not check fruther
			{
				break;
			}
			i++;
		}
		
		i = 1;//reset counter
		
		
		while(x - i >= 0 && y + i <= 7)//checks the diagonal, in this case top left to bottom right
		{
			if(this.currentBoard[x - i][y + i].getType().charAt(0) == 'E')//if the square is empty, this is a valid move
			{
				this.queenPossibleMoves[k][0] = x - i;
				this.queenPossibleMoves[k][1] = y + i;
				i++;
				k++;
				continue;
			}
			else if(this.currentBoard[x - i][y + i].getColour() != this.colour)//if the square holds an enemey then it is valid, but we need not check furtheer
			{
				this.queenPossibleMoves[k][0] = x - i;
				this.queenPossibleMoves[k][1] = y + i;
				k++;
				break;
			}
			else if(this.currentBoard[x - i][y + i].getColour() != this.colour)//if the square contains a friendly, then it is invalid and we need not check fruther
			{
				break;
			}
			i++;
		}
		
		i = 1;//reset counter
		
		
		while(x + i <=7 && y - i >= 0)//checks the diagonal, in this case top left to bottom right
		{
			if(this.currentBoard[x + i][y - i].getType().charAt(0) == 'E')//if the square is empty, this is a valid move
			{
				this.queenPossibleMoves[k][0] = x + i;
				this.queenPossibleMoves[k][1] = y - i;
				i++;
				k++;
				continue;
			}
			else if(this.currentBoard[x + i][y - i].getColour() != this.colour)//if the square holds an enemy then it is valid, but we need not check furtheer
			{
				this.queenPossibleMoves[k][0] = x + i;
				this.queenPossibleMoves[k][1] = y - i;
				k++;
				break;
			}
			else if(this.currentBoard[x + i][y - i].getColour() != this.colour)//if the square contains a friendly, then it is invalid and we need not check fruther
			{
				break;
			}
			i++;
		}
		
		i = 1;//reset counter
		
		while(x - i >= 0 && y - i >= 0)//checks the diagonal, in this case top left to bottom right
		{
			if(this.currentBoard[x - i][y - i].getType().charAt(0) == 'E')//if the square is empty, this is a valid move
			{
				this.queenPossibleMoves[k][0] = x - i;
				this.queenPossibleMoves[k][1] = y - i;
				i++;
				k++;
				continue;
			}
			else if(this.currentBoard[x - i][y - i].getColour() != this.colour)//if the square holds an enemey then it is valid, but we need not check furtheer
			{
				this.queenPossibleMoves[k][0] = x - i;
				this.queenPossibleMoves[k][1] = y - i;
				k++;
				break;
			}
			else if(this.currentBoard[x - i][y - i].getColour() != this.colour)//if the square contains a friendly, then it is invalid and we need not check fruther
			{
				break;
			}
			i++;
		}
		
		i = 1;//reset counter
		while(x + i <= 7)
		{
			if(this.currentBoard[x + i][y].getType().charAt(0) == 'E')//to an empty space is a valid move
			{
				this.queenPossibleMoves[k][0] = x + i;
				this.queenPossibleMoves[k][1] = y;
				i++;
				k++;
				continue;
			}
			else if (this.currentBoard[x + i][y].getColour() != this.colour)//different colour, can take, but cannot go further
			{
				this.queenPossibleMoves[k][0] = x + i;
				this.queenPossibleMoves[k][1] = y;
				k++;
				break;
			}
			else if(this.currentBoard[x + i][y].getColour() == this.colour)//same colour, cannot take, cannot go further
			{
				break;
			}
			else
			{
				System.out.println("ERROR: queen 1");
			}
		}
		i = 1;//reset counter
		while(x - i >= 0)
		{
			if(this.currentBoard[x - i][y].getType().charAt(0) == 'E')//to an empty space is a valid move
			{
				this.queenPossibleMoves[k][0] = x - i;
				this.queenPossibleMoves[k][1] = y;
				i++;
				k++;
				continue;
			}
			else if (this.currentBoard[x - i][y].getColour() != this.colour)//different colour, can take, but cannot go further
			{
				this.queenPossibleMoves[k][0] = x - i;
				this.queenPossibleMoves[k][1] = y;
				k++;
				break;
			}
			else if(this.currentBoard[x - i][y].getColour() == this.colour)//same colour, cannot take, cannot go further
			{
				break;
			}
			else
			{
				System.out.println("ERROR: queen moves 2");
			}
		}
		i = 1;//reset counter
		while(y + i <= 7)
		{
			if(this.currentBoard[x][y + i].getType().charAt(0) == 'E')//to an empty space is a valid move
			{
				this.queenPossibleMoves[k][0] = x;
				this.queenPossibleMoves[k][1] = y + i;
				i++;
				k++;
				continue;
			}
			else if (this.currentBoard[x][y + i].getColour() != this.colour)//different colour, can take, but cannot go further
			{
				this.queenPossibleMoves[k][0] = x;
				this.queenPossibleMoves[k][1] = y + i;
				k++;
				break;
			}
			else if(this.currentBoard[x][y + i].getColour() == this.colour)//same colour, cannot take, cannot go further
			{
				break;
			}
			else
			{
				System.out.println("ERROR: queen moves 3");
			}
		}
		i = 1;//reset counter
		while(y - i  >= 0)
		{
			if(this.currentBoard[x][y - i].getType().charAt(0) == 'E')//to an empty space is a valid move
			{
				this.queenPossibleMoves[k][0] = x;
				this.queenPossibleMoves[k][1] = y - i;
				i++;
				k++;
				continue;
			}
			else if (this.currentBoard[x][y - i].getColour() != this.colour)//different colour, can take, but cannot go further
			{
				this.queenPossibleMoves[k][0] = x;
				this.queenPossibleMoves[k][1] = y - i;
				k++;
				break;
			}
			else if(this.currentBoard[x][y - i].getColour() == this.colour)//same colour, cannot take, cannot go further
			{
				break;
			}
			else
			{
				System.out.println("ERROR: queen moves 4");
			}
		}
		
		return this.queenPossibleMoves;
	}


}
