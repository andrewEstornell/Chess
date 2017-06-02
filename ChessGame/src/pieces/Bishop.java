package pieces;

import board.ChessBoard;

public class Bishop 
{
	private ChessPiece[][] currentBoard;//used to check the state of board
	private int[][] bishopPossibleMoves;//stores all possible moves for this bishop
	private ChessBoard chessBoard;//creates a new chess board to access getBoard()
	private int colourOfThisPiece;
	
	public int[][] allPossibleMovesForThisPiece(int x, int y)//takes in the current position of the peice the user wants to mave and generates all possible moves
	{
		this.chessBoard = new ChessBoard();//Initializes the chess board
		this.currentBoard = chessBoard.getBoard();//stores current state of the board in curretnBoard
		this.bishopPossibleMoves = new int[27][2];//stores all moves this bishop can make
		
		
		int i = 1;//start at 1 since this bishop cannot move to (x + 0,y + 0)
		int j = 1;
		int k = 0;//counting for bishopPossibleMoves


			//check 4 for loops diaglonsals
		return this.bishopPossibleMoves;
	}
}
