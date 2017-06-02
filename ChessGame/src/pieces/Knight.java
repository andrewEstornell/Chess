package pieces;

import board.ChessBoard;



public class Knight
{
	
	private ChessPiece[][] currentBoard;
	private int [][] knightPossibleMoves;
	private ChessBoard chessBoard;
	
	public int[][] allPossibleMovesForThisPiece(int x, int y)
	{
		this.chessBoard = new ChessBoard();
		this.currentBoard = chessBoard.getBoard();
		this.knightPossibleMoves = new int[27][2];
		
		//checks all possible moves for the knight, there is a maximum of 8 for them
		//Leaving maxNumbOfMoves at 27 as it may intefear with he return value
		int i = 0;
			//////this.knightPossibleMoves[][]/////
			System.out.println("colour is" + this.currentBoard[x][y].getColour());
			
			//checks that the knights move pattern in on the board
			if(x - 2 >= 0 && y - 1 >= 0)
			{
				
				if(this.currentBoard[x - 2][y - 1].getColour() != this.currentBoard[x][y].getColour())
				{
					this.knightPossibleMoves[i][0] = x - 2;
					this.knightPossibleMoves[i][1] = y - 1;
					i++;
					//printout for debugging
					System.out.printf("%d, %d \n", x - 2, y - 1);
				}
			}
			
			if(x - 2 >= 0 && y + 1 <= 7)
			{
				if(this.currentBoard[x - 2][y + 1].getColour() != this.currentBoard[x][y].getColour())
				{
					this.knightPossibleMoves[i][0] = x - 2;
					this.knightPossibleMoves[i][1] = y + 1;
					i++;
					System.out.printf("%d, %d \n", x - 2, y + 1);
				}
			}
			if(x - 1 >= 0 && y - 2 >= 0)
			{
				
				if(this.currentBoard[x - 1][y - 2].getColour() != this.currentBoard[x][y].getColour())
				{
					this.knightPossibleMoves[i][0] = x - 1;
					this.knightPossibleMoves[i][1] = y - 2;
					i++;
					System.out.printf("%d, %d \n", x - 1, y - 2);
				}
			}
			if(x - 1 >= 0 && y + 2 <= 7)
			{
				if(this.currentBoard[x - 1][y + 2].getColour() != this.currentBoard[x][y].getColour())
				{
					this.knightPossibleMoves[i][0] = x - 1;
					this.knightPossibleMoves[i][1] = y + 2;
					i++;
					System.out.printf("%d, %d \n", x - 1, y + 2);
				}
			}
			if(x + 1 <= 7 && y - 2 >= 0)
			{
				if(this.currentBoard[x + 1][y - 2].getColour() != this.currentBoard[x][y].getColour())
				{
					this.knightPossibleMoves[i][0] = x + 1;
					this.knightPossibleMoves[i][1] = y - 2;
					i++;
					System.out.printf("%d, %d \n", x + 1, y - 2);
				}
			}
			if(x + 1 <= 7 && y + 2 <= 7)
			{
				if(this.currentBoard[x + 1][y + 2].getColour() != this.currentBoard[x][y].getColour())
				{
					this.knightPossibleMoves[i][0] = x + 1;
					this.knightPossibleMoves[i][1] = y + 2;
					i++;
					System.out.printf("%d, %d \n", x + 1, y + 2);
				}
			}
			if(x + 2 <= 7 && y - 1 >= 0)
			{
				if(this.currentBoard[x + 2][y - 1].getColour() != this.currentBoard[x][y].getColour())
				{
					this.knightPossibleMoves[i][0] = x + 2;
					this.knightPossibleMoves[i][1] = y - 1;
					i++;
					System.out.printf("%d, %d \n", x + 2, y - 1);
				}
			}
			if(x + 2 <= 7 && y + 1 <= 7)
			{
				if(this.currentBoard[x + 2][y + 1].getColour() != this.currentBoard[x][y].getColour())
				{
					this.knightPossibleMoves[i][0] = x + 2;
					this.knightPossibleMoves[i][1] = y + 1;
					i++;
					System.out.printf("%d, %d \n", x + 2, y + 1);
				}
			}
		
		return this.knightPossibleMoves;
	}
	
}
