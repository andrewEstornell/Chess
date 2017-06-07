package pieces;

import board.Game;

public class Rook 
{
	private int[][] rookPossibleMoves;//stores all valid moves for the rook
	private int colour;//colour of the the rook
	
	
	public int[][] allPossibleMovesForThisPiece(int x, int y, ChessPiece[][] currentBoard)
	{
		
		this.colour = currentBoard[x][y].getColour();//gets colour of the rook
		this.rookPossibleMoves = new int[27][2];
		
		int i = 1;//counts through board spaces
		int k =0;//counts through rookPossibleMoves
		
		while(x + i <= 7)
		{
			if(currentBoard[x + i][y].getType().charAt(0) == 'E')//to an empty space is a valid move
			{
				this.rookPossibleMoves[k][0] = x + i;
				this.rookPossibleMoves[k][1] = y;
				i++;
				k++;
				continue;
			}
			else if (currentBoard[x + i][y].getColour() != this.colour)//different colour, can take, but cannot go further
			{
				this.rookPossibleMoves[k][0] = x + i;
				this.rookPossibleMoves[k][1] = y;
				k++;
				break;
			}
			else if(currentBoard[x + i][y].getColour() == this.colour)//same colour, cannot take, cannot go further
			{
				break;
			}
			else
			{
				System.out.println("ERROR: Rook 1");
			}
		}
		i = 1;//reset counter
		while(x - i >= 0)
		{
			if(currentBoard[x - i][y].getType().charAt(0) == 'E')//to an empty space is a valid move
			{
				this.rookPossibleMoves[k][0] = x - i;
				this.rookPossibleMoves[k][1] = y;
				i++;
				k++;
				continue;
			}
			else if (currentBoard[x - i][y].getColour() != this.colour)//different colour, can take, but cannot go further
			{
				this.rookPossibleMoves[k][0] = x - i;
				this.rookPossibleMoves[k][1] = y;
				k++;
				break;
			}
			else if(currentBoard[x - i][y].getColour() == this.colour)//same colour, cannot take, cannot go further
			{
				break;
			}
			else
			{
				System.out.println("ERROR: Rook moves 2");
			}
		}
		i = 1;//reset counter
		while(y + i <= 7)
		{
			if(currentBoard[x][y + i].getType().charAt(0) == 'E')//to an empty space is a valid move
			{
				this.rookPossibleMoves[k][0] = x;
				this.rookPossibleMoves[k][1] = y + i;
				i++;
				k++;
				continue;
			}
			else if (currentBoard[x][y + i].getColour() != this.colour)//different colour, can take, but cannot go further
			{
				this.rookPossibleMoves[k][0] = x;
				this.rookPossibleMoves[k][1] = y + i;
				k++;
				break;
			}
			else if(currentBoard[x][y + i].getColour() == this.colour)//same colour, cannot take, cannot go further
			{
				break;
			}
			else
			{
				System.out.println("ERROR: Rook moves 3");
			}
		}
		i = 1;//reset counter
		while(y - i  >= 0)
		{
			if(currentBoard[x][y - i].getType().charAt(0) == 'E')//to an empty space is a valid move
			{
				this.rookPossibleMoves[k][0] = x;
				this.rookPossibleMoves[k][1] = y - i;
				i++;
				k++;
				continue;
			}
			else if (currentBoard[x][y - i].getColour() != this.colour)//different colour, can take, but cannot go further
			{
				this.rookPossibleMoves[k][0] = x;
				this.rookPossibleMoves[k][1] = y - i;
				k++;
				break;
			}
			else if(currentBoard[x][y - i].getColour() == this.colour)//same colour, cannot take, cannot go further
			{
				break;
			}
			else
			{
				System.out.println("ERROR: Rook moves 4");
			}
		}
		
		return this.rookPossibleMoves;//returns array of all valid moves for the rook the user has selected
	}
}
