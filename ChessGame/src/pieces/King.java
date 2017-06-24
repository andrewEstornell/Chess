package pieces;

import board.Game;

public class King 
{
	private int[][] possibleKingMoves;
	
	/**
	 * 
	 * @param x x coordinate of this king
	 * @param y y coordinate of this king
	 * @param currentBoard user facing board state
	 * @return an array of all possible moves for this king
	 */
	public int[][] allPossibleMovesForThisPiece(int x, int y, ChessPiece[][] currentBoard)
	{
		
		int colourOfThisKing = currentBoard[x][y].getColour();
		int k = 0;
		this.possibleKingMoves = new int[30][2];
		for(int i = 0; i < 3; i++)//checks all squares around the king to see if they are valid moves
		{
			for(int j = 0; j < 3; j++)
			{
				if(x - 1 + i >= 0 && x - 1 + i <= 7)//checks that the square next to the king is part of the board
				{
					if(y - 1 + j >= 0 && y - 1 + j <= 7)//checks that the square next to the king is part of the board
					{
						if(currentBoard[x - 1 + i][y - 1 + j].getColour() != colourOfThisKing)
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
		
		
		
		//need to add the rest of the castling logic.
		if(colourOfThisKing == 0)
		{
			if(Game.whiteLongCastle && !this.squareIsUnderAttack(colourOfThisKing, currentBoard, 7, 2) && !this.squareIsUnderAttack(colourOfThisKing, currentBoard, 7, 3) && !this.squareIsUnderAttack(colourOfThisKing, currentBoard, 7, 4) )
			{
				this.possibleKingMoves[k][0] = 7;
				this.possibleKingMoves[k][1] = 2;
				k++;
			}
			if(Game.whiteShortCastle && !this.squareIsUnderAttack(colourOfThisKing, currentBoard, 7, 6) && !this.squareIsUnderAttack(colourOfThisKing, currentBoard, 7, 5) && !this.squareIsUnderAttack(colourOfThisKing, currentBoard, 7, 4))
			{
				this.possibleKingMoves[k][0] = 7;
				this.possibleKingMoves[k][1] = 6;
				k++;
			}
		}
		else if(colourOfThisKing == 1)
		{
			if(Game.blackLongCastle && !this.squareIsUnderAttack(colourOfThisKing, currentBoard, 0, 2) && !this.squareIsUnderAttack(colourOfThisKing, currentBoard, 0, 3) && !this.squareIsUnderAttack(colourOfThisKing, currentBoard, 0, 4))
			{
				this.possibleKingMoves[k][0] = 0;
				this.possibleKingMoves[k][1] = 2;
				k++;
			}
			if(Game.blackShortCastle && !this.squareIsUnderAttack(colourOfThisKing, currentBoard, 0, 6) && !this.squareIsUnderAttack(colourOfThisKing, currentBoard, 0, 5) && !this.squareIsUnderAttack(colourOfThisKing, currentBoard, 0, 4))
			{
				this.possibleKingMoves[k][0] = 0;
				this.possibleKingMoves[k][1] = 6;
				k++;
			}
		}
		return this.possibleKingMoves;
	}
	
	
	/**
	 * Tests if the king is in check
	 * @param colourOfKing colour of the king
	 * @param currentBoard user facing chess board
	 * @param x x coordinate of the square being checked for attacks
	 * @param y y coordinate of the square being checked for attacks
	 * @return true if in check, false if not in check
	 */
	public boolean squareIsUnderAttack(int colourOfKing, ChessPiece[][] currentBoard, int x, int y)
	{
		int i = 1;//counter
		
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
			if(currentBoard[x][y - i].getType().compareTo("EmptySpace") != 0)//Rook and queen only pieces that can attack row/column, if not rook or queen, king is not in check from this row/column
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
			if(x + 1 <= 0)
			{
				if(y - 1 >= 0)
				{
					if(currentBoard[x + 1][y - 1].getType().charAt(0) == 'P' && currentBoard[x + 1][y - 1].getColour() == 0)//checks if there is pawn to the bottom left or right of the black king
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
		if(colourOfKing == 0)
		{
			if(x - 1 >= 0)
			{
				if(y - 1 >= 0)
				{
					if(currentBoard[x - 1][y - 1].getType().charAt(0) == 'P' && currentBoard[x - 1][y - 1].getColour() == 1)//checks if there is pawn to the bottom left or right of the black king
					{
						//printout for debugging
						System.out.println(colourOfKing + " King attacked by " + currentBoard[x - 1][y - 1].getColour() + currentBoard[x - 1][y - 1].getType());
						return true;
					}
				}
				if(y + 1 <= 7)
				{
					 if(currentBoard[x - 1][y + 1].getType().charAt(0) == 'P' && currentBoard[x - 1][y + 1].getColour() == 1)
					 {
						//printout for debugging
						System.out.println(colourOfKing + " King attacked by " + currentBoard[x - 1][y + 1].getColour() + currentBoard[x - 1][y + 1].getType());
						return true;
					 }
				}
			}
		}
		
		//king checking king
		for(i = 0; i < 3; i++) // checks all 8 squares around the king for another king.
		{
			if(x - 1 + i <= 7 && x - 1 + i >= 0) // checks boundry of the board
			{
				for(int j = 0; j < 3; j++)
				{
					if(y - 1 + j <= 7 && y - 1 + j >=0)
					{
						if(currentBoard[x - 1 + i][y - 1 + j].getType().compareTo("King") == 0 && currentBoard[x - 1 + i][y - 1 + j].getColour() != colourOfKing)
						{
							return true; // kings cannot move into the range of other kings, so if this occurs then an illegal check has occurred
						}
					}
				}
			}
		}
		
		System.out.println("Nothing attacking the " + colourOfKing + " king");
		return false; // if nothing yields true in the above conditions than the king is not in check.
	}
	
	/**
	 * 
	 * @param x1 x coordinate of the moving piece
	 * @param y1 y coordinate of the moving piece
	 * @param x2 x coordinate the piece is moving to
	 * @param y2 y coordinate the piece is moving to
	 * @param colourOfKing colour of the king being tested for check
	 * @param testBoard a test board to run moves on, deep copy of the current user facing board
	 * @return return true if the players move places their own king in check, false otherwise 
	 */
	public boolean kingIsInCheckAfterThisMove(int x1, int y1, int x2, int y2, int colourOfKing, ChessPiece[][] testBoard)
	{
		// performs the proposed move
		ChessPiece tempPiece = Game.testBoard[x2][y2];
		Game.testBoard[x2][y2] = Game.testBoard[x1][y1];
		Game.testBoard[x1][y2] = new ChessPiece("EmptySpace", -1);
		
		
		if(this.squareIsUnderAttack(colourOfKing, Game.testBoard, getKingPosition(colourOfKing, Game.testBoard)[0], getKingPosition(colourOfKing, Game.testBoard)[1])) // checks for an illegal check
		{
			// reverts the moves if it is illegal
			Game.testBoard[x1][y1] = testBoard[x2][y2];
			Game.testBoard[x2][y2] = tempPiece;
			return true;
		}
		return false;
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
	
	
	/**
	 * 	If the king or rook has move, this function causes castling to not be entered into kingPossibleMoves 
	 * @param x1 x coordinate of a king or rook
	 * @param y1 y coordinate of a king or rook
	 */
	public void hasCastled(int x1, int y1)
	{
			if(x1 == 7 && y1 == 4)
			{
				Game.whiteShortCastle = false;
				Game.whiteLongCastle = false;
			}
			else if(x1 == 7 && y1 == 0)
			{
				Game.whiteLongCastle = false;
			}
			else if (x1 == 7 && y1 == 7)
			{
				Game.whiteShortCastle = false;
			}
			
			
			else if(x1 == 0 && y1 == 4)
			{
				Game.blackLongCastle = false;
				Game.blackShortCastle = false;
			}
			else if(x1 == 0 & y1 == 0)
			{
				Game.blackLongCastle = false;
			}
			else if(x1 == 0 && y1 == 7)
			{
				Game.blackShortCastle = false;
			}
	}
	
}
