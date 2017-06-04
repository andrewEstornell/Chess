package pieces;

import board.Game;

public class King 
{
	private ChessPiece[][] currentBoard;
	private int[][] possibleKingMoves;
	
	/**
	 * 
	 * @param x x coordinate of this king
	 * @param y y coordinate of this king
	 * @return an array of all possible moves for this king
	 */
	public int[][] allPossibleMovesForThisPiece(int x, int y)
	{
		this.currentBoard = Game.mainChessBoard.getBoard();
		int colourOfThisKing = this.currentBoard[x][y].getColour();
		int k = 0;
		this.possibleKingMoves = new int[27][2];
		for(int i = 0; i < 3; i++)//checks all squares around the king to see if they are valid moves
		{
			for(int j = 0; j < 3; j++)
			{
				if(x - 1 + i >= 0 && x - 1 + i <= 7)//checks that the square next to the king is part of the board
				{
					if(y - 1 + j >= 0 && y - 1 + j <= 7)//checks that the square next to the king is part of the board
					{
						if(this.currentBoard[x - 1 + i][y - 1 + j].getColour() != colourOfThisKing)
						{
							this.possibleKingMoves[k][0] = x - 1 + i;
							this.possibleKingMoves[k][1] = y - 1 + j;
							k++;
							//print out moves for testing
							System.out.println((x - 1 + i) + " " + (y - 1 + j));
						}
					}
				}
			}
		}
		return this.possibleKingMoves;
	}
	
	
	
	/**
	 * Tests if the king is in check
	 * @param colourOfKing colour of the king
	 * @return true if in check, false if not in check
	 */
	public boolean kingIsInCheck(int colourOfKing)
	{
		this.currentBoard = Game.mainChessBoard.getBoard();//gets the state of the current board the user is interacting with
		int i = 1;//counter
		
		int x = getKingPosition(colourOfKing, currentBoard)[0];//x, y coordinate of king's current position
		int y = getKingPosition(colourOfKing, currentBoard)[1];
		
		while(x + i <= 7)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x + i][y].getColour() != colourOfKing && (currentBoard[x + i][y].getType().charAt(0) == 'R' || currentBoard[x + i][y].getType().charAt(0) == 'Q'))//if there is an enemy rook or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				//printout for debugging
				System.out.println("1st: " + colourOfKing + " King attacked by " + currentBoard[x + i][y].getColour() + currentBoard[x + i][y].getType());
				return true;//king is in check
			}
			if(currentBoard[x + i][y].getType().compareTo("EmptySpace") != 0)//Rook and queen only pieces that can attack row/column, if not rook or queen, king is not in check from this row/column
			{
				break;
			}
			i++;
		}
		i= 1;//reset counter
		while(x - i >= 0)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x - i][y].getColour() != colourOfKing && (currentBoard[x - i][y].getType().charAt(0) == 'R' || currentBoard[x - i][y].getType().charAt(0) == 'Q'))//if there is an enemy rook or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				//printout for debugging
				System.out.println("2nd: " + colourOfKing + " King attacked by " + currentBoard[x - i][y].getColour() + currentBoard[x - i][y].getType());
				return true;//king is in check
			}
			if(currentBoard[x - i][y].getType().compareTo("EmptySpace") != 0)//Rook and queen only pieces that can attack row/column, if not rook or queen, king is not in check from this row/column
			{
				break;
			}
			i++;
		}
		i = 1;//reset counter
		while(y + i <= 7)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x][y + i].getColour() != colourOfKing && (currentBoard[x][y + i].getType().charAt(0) == 'R' || currentBoard[x][y + i].getType().charAt(0) == 'Q'))//if there is an enemy rook or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				//printout for debugging
				System.out.println("3rd: " + colourOfKing + " King attacked by " + currentBoard[x][y + i].getColour() + currentBoard[x][y + i].getType());
				return true;//king is in check
			}
			if(currentBoard[x][y + i].getType().compareTo("EmptySpace") != 0)//Rook and queen only pieces that can attack row/column, if not rook or queen, king is not in check from this row/column
			{
				break;
			}
			i++;
		}
		i = 1;//reset counter
		while(y - i >= 0)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x][y - i].getColour() != colourOfKing && (currentBoard[x][y - i].getType().charAt(0) == 'R' || currentBoard[x][y - i].getType().charAt(0) == 'Q'))//if there is an enemy rook or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				//printout for debugging
				System.out.println("4th: " + colourOfKing + " King attacked by " + currentBoard[x][y - i].getColour() + currentBoard[x][y - i].getType());
				return true;//king is in check
			}
			if(currentBoard[x][y - 1].getType().compareTo("EmptySpace") != 0)//Rook and queen only pieces that can attack row/column, if not rook or queen, king is not in check from this row/column
			{
				break;
			}
			i++;
		}
		i = 1;//reset counter
		while(x + i <= 7 && y + i <= 7)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x + i][y + i].getColour() != colourOfKing && (currentBoard[x + i][y + i].getType().charAt(0) == 'B' || currentBoard[x + i][y + i].getType().charAt(0) == 'Q'))//if there is an enemy bishop or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				//printout for debugging
				System.out.println("5th: " + colourOfKing + " King attacked by " + currentBoard[x + i][y + i].getColour() + currentBoard[x + i][y + i].getType());
				return true;//king is in check
			}
			if(currentBoard[x + i][y + i].getType().compareTo("EmptySpace") != 0)//if any piece, other than a bishop or queen is directly in front of the king on this diagonal, then no check comes from this diagonal
			{
				break;
			}
			i++;
		}
		i = 1;//reset counter
		while(x + i <= 7 && y - i >= 0)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x + i][y - i].getColour() != colourOfKing && (currentBoard[x + i][y - i].getType().charAt(0) == 'B' || currentBoard[x + i][y - i].getType().charAt(0) == 'Q'))//if there is an enemy bishop or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				//printout for debugging
				System.out.println("6th: " + colourOfKing + " King attacked by " + currentBoard[x + i][y - i].getColour() + currentBoard[x + i][y - i].getType());
				return true;//king is in check
			}
			if(currentBoard[x + i][y - i].getType().compareTo("EmptySpace") != 0)//if any piece, other than a bishop or queen is directly in front of the king on this diagonal, then no check comes from this diagonal
			{
				break;
			}
			i++;
		}
		i = 1;//reset counter
		while(x - i >= 0 && y + i <= 7)//checks a row, column or diagonal for attacks on the king
		{
			if(currentBoard[x - i][y + i].getColour() != colourOfKing && (currentBoard[x - i][y + i].getType().charAt(0) == 'B' || currentBoard[x - i][y + i].getType().charAt(0) == 'Q'))//if there is an enemy bishop or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				//printout for debugging
				System.out.println("7th: " + colourOfKing + " King attacked by " + currentBoard[x - i][y + i].getColour() + currentBoard[x - i][y + i].getType());
				return true;//king is in check
			}
			if(currentBoard[x - i][y + i].getType().compareTo("EmptySpace") != 0)//if any piece, other than a bishop or queen is directly in front of the king on this diagonal, then no check comes from this diagonal
			{
				break;
			}
			i++;
		}
		i = 1;//reset counter
		while(x - i >= 0 && y - i >= 0)//checks a row, column or diagonal for attacks on the king
		{
			
			if(currentBoard[x - i][y - i].getColour() != colourOfKing && (currentBoard[x - i][y - i].getType().charAt(0) == 'B' || currentBoard[x - i][y - i].getType().charAt(0) == 'Q'))//if there is an enemy bishop or queen on the same column as the king and nothing is blocking it, the king is in check
			{
				//printout for debugging
				System.out.println("8th: " + colourOfKing + " King attacked by " + currentBoard[x - i][y - i].getColour() + currentBoard[x - i][y - i].getType());
				return true;//king is in check
			}
			if(currentBoard[x - i][y - i].getType().compareTo("EmptySpace") != 0)//if any piece, other than a bishop or queen is directly in front of the king on this diagonal, then no check comes from this diagonal
			{
				break;
			}
			i++;
		}
		
		//knight attacks
		if(x + 1 <= 7)//checks bounds of the board
		{
			if(y + 2 <= 7)
			{
				if(currentBoard[x + 1][y + 2].getColour() != colourOfKing && currentBoard[x + 1][y + 2].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
				{//printout for debugging
					System.out.println("9th: " + colourOfKing + " King attacked by " + currentBoard[x + 1][y + 2].getColour() + currentBoard[x + 1][y + 2].getType());
					return true;
				}
			}
			if(y - 2 >= 0)
			{
				if(currentBoard[x + 1][y - 2].getColour() != colourOfKing && currentBoard[x + 1][y - 2].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
				{
					//printout for debugging
					System.out.println("10th: " + colourOfKing + " King attacked by " + currentBoard[x + 1][y - 2].getColour() + currentBoard[x + 1][y - 2].getType());
					return true;
				}
			}
			if(x + 2 <= 7)
			{
				if(y + 1 <= 7)
				{
					if(currentBoard[x + 2][y + 1].getColour() != colourOfKing && currentBoard[x + 2][y + 1].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
					{
						//printout for debugging
						System.out.println("11th: " + colourOfKing + " King attacked by " + currentBoard[x + 2][y + 1].getColour() + currentBoard[x + 2][y + 1].getType());
						return true;
					}
				}
				if(y - 1 >= 0)
				{
					if(currentBoard[x + 2][y - 1].getColour() != colourOfKing && currentBoard[x + 2][y - 1].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
					{
						//printout for debugging
						System.out.println("12th: " + colourOfKing + " King attacked by " + currentBoard[x + 2][y - 1].getColour() + currentBoard[x + 2][y - 1].getType());
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
						//printout for debugging
						System.out.println("13th: " + colourOfKing + " King attacked by " + currentBoard[x - 1][y + 2].getColour() + currentBoard[x - 1][y + 2].getType());
						return true;
					}
				}
				if(y - 2 >= 0)
				{
					if(currentBoard[x - 1][y - 2].getColour() != colourOfKing && currentBoard[x - 1][y - 2].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
					{
						//printout for debugging
						System.out.println("14th: " + colourOfKing + " King attacked by " + currentBoard[x - 1][y - 2].getColour() + currentBoard[x - 1][y - 2].getType());
						return true;
					}
				}
				if(x - 2 >= 0)
				{
					if(y + 1 <= 7)
					{
						if(currentBoard[x - 2][y + 1].getColour() != colourOfKing && currentBoard[x - 2][y + 1].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
						{
							//printout for debugging
							System.out.println(colourOfKing + " King attacked by " + currentBoard[x - 2][y + 1].getColour() + currentBoard[x - 2][y + 1].getType());
							return true;
						}
					}
					if(y - 1 >= 0)
					{
						if(currentBoard[x - 2][y - 1].getColour() != colourOfKing && currentBoard[x - 2][y - 1].getType().charAt(1) == 'n')//checks if an enemy knight is in attacking range of the king
						{
							//printout for debugging
							System.out.println(colourOfKing + " King attacked by " + currentBoard[x - 2][y - 1].getColour() + currentBoard[x - 2][y - 1].getType());
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
						//printout for debugging
						System.out.println(colourOfKing + " King attacked by " + currentBoard[x + i][y].getColour() + currentBoard[x - 1][y - 1].getType());
						return true;
					}
				}
				if(y + 1 <= 7)
				{
					 if(currentBoard[x - 1][y + 1].getType().charAt(0) == 'P' && currentBoard[x - 1][y + 1].getColour() == 0)
					 {
						//printout for debugging
							System.out.println(colourOfKing + " King attacked by " + currentBoard[x - 1][y + 1].getColour() + currentBoard[x - 1][y + 1].getType());
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
						//printout for debugging
						System.out.println(colourOfKing + " King attacked by " + currentBoard[x + 1][y - 1].getColour() + currentBoard[x + 1][y - 1].getType());
						return true;
					}
				}
				if(y + 1 <= 7)
				{
					 if(currentBoard[x + 1][y + 1].getType().charAt(0) == 'P' && currentBoard[x + 1][y + 1].getColour() == 0)
					 {
						//printout for debugging
							System.out.println(colourOfKing + " King attacked by " + currentBoard[x + 1][y + 1].getColour() + currentBoard[x + 1][y + 1].getType());
						 return true;
					 }
				}
			}
		}
		
		//king checking king
		for(i = 0; i < 3; i++)//checks all 8 squares around the king for another king.
		{
			if(x - 1 + i <= 7 && x - 1 + i >= 0)//checks boundry of the board
			{
				for(int j = 0; j < 3; j++)
				{
					if(y - 1 + i <= 7 && x - 1 + i >=0)
					{
						if(currentBoard[x - 1 + i][y - 1 + j].getType().compareTo("King") == 0 && currentBoard[x - 1 + i][y - 1 + j].getColour() != colourOfKing)
						{
							return true;//kings cannot move into the range of other kings, so if this occurs then an illegal check has occurred
						}
					}
				}
			}
		}
		
		System.out.println("Nothing attacking the " + colourOfKing + " king");
		return false;//if nothing yields true in the above conditions than the king is not in check.
	}
	
	/**
	 * Getter method for the kings current position
	 * @param colourOfKing is the colour of this king
	 * @return the position this king is at
	 */
	public int[] getKingPosition(int kingColour, ChessPiece[][] kingPositionBoard)
	{
		int[] position = new int[2];
		
		
		
		int i = 0;
		boolean breakOut = false;//once the king is found, break out of both loops
		while(i < 8)//checks through the board to find the king of the correct colour
		{
			int j = 0;
			while(j < 8)
			{
				if(kingPositionBoard[i][j].getType().compareTo("King") == 0 && kingPositionBoard[i][j].getColour() == kingColour)
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
		
		return position;
		
	}
}
