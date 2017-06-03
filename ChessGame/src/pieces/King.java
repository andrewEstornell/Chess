package pieces;

import board.Game;

public class King 
{
	private ChessPiece[][] currentBoard;
	private int[][] possibleKingMoves;
	
	private int[] position;
	
	/**
	 * Tests if the king is in check
	 * @param colourOfKing colour of thee king
	 * @return true if in check, false if not in check
	 */
	public boolean kingIsInCheck(int colourOfKing)
	{
		this.currentBoard = Game.mainChessBoard.getBoard();//gets the state of the current board the user is interacting with
		int i = 1;//counters
		
		int x = getKingPosition(colourOfKing)[0];//x, y coordinate of king's current position
		int y = getKingPosition(colourOfKing)[1];
		
		while(x + i <= 7)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x + i][y].getColour() == colourOfKing)//if there is a friendly piece in front of the king, a check cannot be coming from this direction
			{
				break;
			}
			if(currentBoard[x + i][y].getColour() != colourOfKing && (currentBoard[x + i][y].getType().charAt(0) == 'R' || currentBoard[x + i][y].getType().charAt(0) == 'Q'))//if there is an enemy rook or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				return true;//king is in check
			}
			i++;
		}
		i= 1;//reset counter
		while(x - i >= 7)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x - i][y].getColour() == colourOfKing)//if there is a friendly piece in front of the king, a check cannot be coming from this direction
			{
				break;
			}
			if(currentBoard[x - i][y].getColour() != colourOfKing && (currentBoard[x - i][y].getType().charAt(0) == 'R' || currentBoard[x - i][y].getType().charAt(0) == 'Q'))//if there is an enemy rook or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				return true;//king is in check
			}
			i++;
		}
		i = 1;//reset counter
		while(y + i <= 7)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x][y + i].getColour() == colourOfKing)//if there is a friendly piece in front of the king, a check cannot be coming from this direction
			{
				break;
			}
			if(currentBoard[x][y + i].getColour() != colourOfKing && (currentBoard[x][y + i].getType().charAt(0) == 'R' || currentBoard[x][y + i].getType().charAt(0) == 'Q'))//if there is an enemy rook or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				return true;//king is in check
			}
			i++;
		}
		i = 1;//reset counter
		while(y - i >= 7)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x][y - i].getColour() == colourOfKing)//if there is a friendly piece in front of the king, a check cannot be coming from this direction
			{
				break;
			}
			if(currentBoard[x][y - i].getColour() != colourOfKing && (currentBoard[x][y - i].getType().charAt(0) == 'R' || currentBoard[x][y - i].getType().charAt(0) == 'Q'))//if there is an enemy rook or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				return true;//king is in check
			}
			i++;
		}
		i = 1;//reset counter
		while(x + i <= 7 && y + i <= 7)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x + i][y + i].getColour() == colourOfKing)//if there is a friendly piece in front of the king, a check cannot be coming from this direction
			{
				break;
			}
			if(currentBoard[x + i][y + i].getColour() != colourOfKing && (currentBoard[x + i][y + i].getType().charAt(0) == 'B' || currentBoard[x + i][y + i].getType().charAt(0) == 'Q'))//if there is an enemy bishop or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				return true;//king is in check
			}
			i++;
		}
		i = 1;//reset counter
		while(x + i <= 7 && y - i <= 7)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x + i][y - i].getColour() == colourOfKing)//if there is a friendly piece in front of the king, a check cannot be coming from this direction
			{
				break;
			}
			if(currentBoard[x + i][y - i].getColour() != colourOfKing && (currentBoard[x + i][y - i].getType().charAt(0) == 'B' || currentBoard[x + i][y - i].getType().charAt(0) == 'Q'))//if there is an enemy bishop or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				return true;//king is in check
			}
			i++;
		}
		i = 1;//reset counter
		while(x - i >= 0 && y + i <= 7)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x - i][y + i].getColour() == colourOfKing)//if there is a friendly piece in front of the king, a check cannot be coming from this direction
			{
				break;
			}
			if(currentBoard[x - i][y + i].getColour() != colourOfKing && (currentBoard[x - i][y + i].getType().charAt(0) == 'B' || currentBoard[x - i][y + i].getType().charAt(0) == 'Q'))//if there is an enemy bishop or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				return true;//king is in check
			}
			i++;
		}
		i = 1;//reset counter
		while(x - i >= 0 && y - i >= 0)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x - i][y - i].getColour() == colourOfKing)//if there is a friendly piece in front of the king, a check cannot be coming from this direction
			{
				break;
			}
			if(currentBoard[x - i][y - i].getColour() != colourOfKing && (currentBoard[x - i][y - i].getType().charAt(0) == 'R' || currentBoard[x - i][y - i].getType().charAt(0) == 'Q'))//if there is an enemy bishop or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				return true;//king is in check
			}
			i++;
		}
		
		//knight attacks
		if(x + 1 <= 7)//checks bounds of the board
		{
			if(y + 2 <= 7)
			{
				if(currentBoard[x + 1][y + 2].getColour() != colourOfKing && currentBoard[x + 1][y + 2].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
				{
					return true;
				}
			}
			if(y - 2 >= 0)
			{
				if(currentBoard[x + 1][y - 2].getColour() != colourOfKing && currentBoard[x + 1][y - 2].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
				{
					return true;
				}
			}
			if(x + 2 <= 7)
			{
				if(y + 1 <= 7)
				{
					if(currentBoard[x + 2][y + 1].getColour() != colourOfKing && currentBoard[x + 2][y + 1].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
					{
						return true;
					}
				}
				if(y - 1 >= 0)
				{
					if(currentBoard[x + 2][y - 1].getColour() != colourOfKing && currentBoard[x + 2][y - 1].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
					{
						return true;
					}
				}
			}
			if(x - 1 >= 0)//checks bounds of the board
			{
				if(y + 2 <= 7)
				{
					if(currentBoard[x - 1][y + 2].getColour() != colourOfKing && currentBoard[x - 1][y + 2].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
					{
						return true;
					}
				}
				if(y - 2 >= 0)
				{
					if(currentBoard[x - 1][y - 2].getColour() != colourOfKing && currentBoard[x - 1][y - 2].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
					{
						return true;
					}
				}
				if(x - 2 >= 0)
				{
					if(y + 1 <= 7)
					{
						if(currentBoard[x - 2][y + 1].getColour() != colourOfKing && currentBoard[x - 2][y + 1].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
						{
							return true;
						}
					}
					if(y - 1 >= 0)
					{
						if(currentBoard[x - 2][y - 1].getColour() != colourOfKing && currentBoard[x - 2][y - 1].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
						{
							return true;
						}
					}
				}
			}
		}
		
		//pawn attacks
		if(colourOfKing == 1)
		{
			if(x - 1 >= 0)
			{
				if(y - 1 >= 0)
				{
					if(currentBoard[x - 1][y - 1].getType().charAt(0) == 'P' && currentBoard[x - 1][y - 1].getColour() == 1)//checks if there is pawn to the bottom left or right of the black king
					{
						return true;
					}
				}
				if(y + 1 <= 7)
				{
					 if(currentBoard[x - 1][y + 1].getType().charAt(0) == 'P' && currentBoard[x - 1][y + 1].getColour() == 0)
					 {
						 return true;
					 }
				}
			}
		}
		if(colourOfKing == 0)
		{
			if(x + 1 <= 7)
			{
				if(y - 1 >= 0)
				{
					if(currentBoard[x + 1][y - 1].getType().charAt(0) == 'P' && currentBoard[x + 1][y - 1].getColour() == 1)//checks if there is pawn to the bottom left or right of the black king
					{
						return true;
					}
				}
				if(y + 1 <= 7)
				{
					 if(currentBoard[x + 1][y + 1].getType().charAt(0) == 'P' && currentBoard[x + 1][y + 1].getColour() == 0)
					 {
						 return true;
					 }
				}
			}
		}
		
		return false;//if nothing yields true in the above conditions than the king is not in check.
	}
	
	/**
	 * Getter method for the kings current position
	 * @param colourOfKing is the colour of this king
	 * @return the position this king is at
	 */
	public int[] getKingPosition(int colourOfKing)
	{
		this.currentBoard = Game.mainChessBoard.getBoard();
		this.position = new int[2];
		
		
		
		int i = 0;
		int j = 0;
		boolean breakOut = false;//once the king is found, break out of both loops
		while(i < 8)//checks through the board to find the king of the correct colour
		{
			while(j < 8)
			{
				if(currentBoard[i][j].getType().compareTo("King") == 0 && currentBoard[i][j].getColour() == colourOfKing)
				{
					position[0] = i;
					position[1] = j;
					breakOut = true;
					break;
				}
				j++;
			}
			if(breakOut)
			{
				break;
			}
			i++;
		}
		
		return this.position;
		
	}
}
