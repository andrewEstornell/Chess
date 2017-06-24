package pieces;

public class Bishop 
{
	private int[][] bishopPossibleMoves;//stores all possible moves for this bishop
	private int colour;
	private int value;
	
	public int[][] allPossibleMovesForThisPiece(int x, int y, ChessPiece[][] currentBoard)//takes in the current position of the peice the user wants to mave and generates all possible moves
	{
		this.value = 3;
		this.bishopPossibleMoves = new int[27][2];//stores all moves this bishop can make
		this.colour = currentBoard[x][y].getColour();
		int i = 1;//start at 1 since this bishop cannot move to (x + 0,y + 0)
		int k = 0;//counting for bishopPossibleMoves
		
		
		//one loop per diagonal, (4 of them)
		//possibly a way to exploit symmetry to make more efficient
		
		while(x + i <=7 && y + i <= 7)//checks the diagonal, in this case top left to bottom right
		{
			if(currentBoard[x + i][y + i].getType().charAt(0) == 'E')//if the square is empty, this is a valid move
			{
				this.bishopPossibleMoves[k][0] = x + i;
				this.bishopPossibleMoves[k][1] = y + i;
				i++;
				k++;
				continue;
			}
			else if(currentBoard[x + i][y + i].getColour() != this.colour)//if the square holds an enemey then it is valid, but we need not check furtheer
			{
				this.bishopPossibleMoves[k][0] = x + i;
				this.bishopPossibleMoves[k][1] = y + i;
				k++;
				break;
			}
			else if(currentBoard[x + i][y + i].getColour() != this.colour)//if the square contains a friendly, then it is invalid and we need not check fruther
			{
				break;
			}
			i++;
		}
		
		i = 1;//reset counter
		
		
		while(x - i >= 0 && y + i <= 7)//checks the diagonal, in this case top left to bottom right
		{
			if(currentBoard[x - i][y + i].getType().charAt(0) == 'E')//if the square is empty, this is a valid move
			{
				this.bishopPossibleMoves[k][0] = x - i;
				this.bishopPossibleMoves[k][1] = y + i;
				i++;
				k++;
				continue;
			}
			else if(currentBoard[x - i][y + i].getColour() != this.colour)//if the square holds an enemey then it is valid, but we need not check furtheer
			{
				this.bishopPossibleMoves[k][0] = x - i;
				this.bishopPossibleMoves[k][1] = y + i;
				k++;
				break;
			}
			else if(currentBoard[x - i][y + i].getColour() != this.colour)//if the square contains a friendly, then it is invalid and we need not check fruther
			{
				break;
			}
			i++;
		}
		
		i = 1;//reset counter
		
		
		while(x + i <=7 && y - i >= 0)//checks the diagonal, in this case top left to bottom right
		{
			if(currentBoard[x + i][y - i].getType().charAt(0) == 'E')//if the square is empty, this is a valid move
			{
				this.bishopPossibleMoves[k][0] = x + i;
				this.bishopPossibleMoves[k][1] = y - i;
				i++;
				k++;
				continue;
			}
			else if(currentBoard[x + i][y - i].getColour() != this.colour)//if the square holds an enemy then it is valid, but we need not check furtheer
			{
				this.bishopPossibleMoves[k][0] = x + i;
				this.bishopPossibleMoves[k][1] = y - i;
				k++;
				break;
			}
			else if(currentBoard[x + i][y - i].getColour() != this.colour)//if the square contains a friendly, then it is invalid and we need not check fruther
			{
				break;
			}
			i++;
		}
		
		i = 1;//reset counter
		
		
		
		while(x - i >= 0 && y - i >= 0)//checks the diagonal, in this case top left to bottom right
		{
			if(currentBoard[x - i][y - i].getType().charAt(0) == 'E')//if the square is empty, this is a valid move
			{
				this.bishopPossibleMoves[k][0] = x - i;
				this.bishopPossibleMoves[k][1] = y - i;
				i++;
				k++;
				continue;
			}
			else if(currentBoard[x - i][y - i].getColour() != this.colour)//if the square holds an enemey then it is valid, but we need not check furtheer
			{
				this.bishopPossibleMoves[k][0] = x - i;
				this.bishopPossibleMoves[k][1] = y - i;
				k++;
				break;
			}
			else if(currentBoard[x - i][y - i].getColour() != this.colour)//if the square contains a friendly, then it is invalid and we need not check fruther
			{
				break;
			}
			i++;
		}
		

		return this.bishopPossibleMoves;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
