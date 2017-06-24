package pieces;

public class Pawn
{
	private int[][] pawnPossibleMoves;//stores all possible moves for this pawn
	private int colour;
	
	
	public int[][] allPossibleMovesForThisPiece(int x, int y, ChessPiece[][] currentBoard)
	{
		this.pawnPossibleMoves = new int[27][2];
		this.colour = currentBoard[x][y].getColour();
		
		int i = 0;
		//two cases for pawn moves, since white pawns move up and black pawns move down
		
		
		if(this.colour == 0)//white
		{
			if(x - 1 >= 0)
			{
				if(currentBoard[x - 1][y].getColour() == -1)//checks that the first space in front of the pawn in open
				{
					this.pawnPossibleMoves[i][0] = x - 1;
					this.pawnPossibleMoves[i][1] = y;
					i++;
					if(x == 6 && currentBoard[x - 2][y].getColour() == -1)//if the pawn has not been moved and the first square is open, check the 2nd.
					{
						this.pawnPossibleMoves[i][0] = x - 2;
						this.pawnPossibleMoves[i][1] = y;
						i++;
					}
				}
			//pawn attack
				if(y - 1 >= 0)
				{
					if(currentBoard[x - 1][y - 1].getColour() == 1)//diagonal attack if enemy piece
					{
						this.pawnPossibleMoves[i][0] = x - 1;
						this.pawnPossibleMoves[i][1] = y -1;
						i++;
					}
				}
				if(y + 1 <= 7)
				{
					if(currentBoard[x - 1][y + 1].getColour() == 1)
					{
						this.pawnPossibleMoves[i][0] = x - 1;
						this.pawnPossibleMoves[i][1] = y + 1;
						i++;
					}
				}
			}
		}
		
		//black
		else if(colour == 1)
		{
			if(x + 1 <= 7)
			{
				if(currentBoard[x + 1][y].getColour() == -1)//checks that the first space in front of the pawn in open
				{
					this.pawnPossibleMoves[i][0] = x + 1;
					this.pawnPossibleMoves[i][1] = y;
					i++;
					if(x == 1 && currentBoard[x + 2][y].getColour() == -1)
					{
						this.pawnPossibleMoves[i][0] = x + 2;
						this.pawnPossibleMoves[i][1] = y;
						i++;
					}
				}
			
			
			//pawn attack
				if(y - 1 >= 0)
				{
					if(currentBoard[x + 1][y - 1].getColour() == 0)
					{
						this.pawnPossibleMoves[i][0] = x + 1;
						this.pawnPossibleMoves[i][1] = y -1;
						i++;
					}
				}
				if(y + 1 <= 7)
				{
					if(currentBoard[x + 1][y + 1].getColour() == 0)
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