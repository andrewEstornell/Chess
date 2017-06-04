package pieces;

import board.Game;

public class Queen 
{
	private int[][] queenPossibleMoves;
	private ChessPiece[][] currentBoard;
	private int[][]rookFunction;
	private int[][]bishopFunction;
	private Rook rook = new Rook();
	private Bishop bishop = new Bishop();
	
	
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
		
		//queen has both rook and bishop move set so we can call both functions for the x, y of the queen
		rookFunction = rook.allPossibleMovesForThisPiece(x, y);
		int rookLength = rookFunction.length;
		bishopFunction = bishop.allPossibleMovesForThisPiece(x, y);
		int bishopLength = bishopFunction.length;
		
		int k = 0;//counter
		for(int i = 0; i < rookLength; i ++)//stores rook-like moves
		{
			queenPossibleMoves[k][0] = rookFunction[i][0];
			queenPossibleMoves[k][1] = rookFunction[i][1];
			k++;
		}
		for(int i = 0; i < bishopLength; i++)//stores bishop-like moves
		{
			queenPossibleMoves[k][0] = bishopFunction[i][0];
			queenPossibleMoves[k][1] = bishopFunction[i][1];
			k++;
		}
		
		return queenPossibleMoves;
	}


}
