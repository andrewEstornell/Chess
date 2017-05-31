package board;
import java.util.ArrayList;

import pieces.ChessPiece;
public class ChessBoard
{
   private ChessPiece[][] board;
   private boolean checkmate;
   //Stores valid moves for a piece
   private int[][] moves;
   
   
   /**
   * Initializes an 8x8 array of ChessPiece's and models the board as the starting board state of a game of chess 
   */
   public ChessBoard()
   {
      this.board = new ChessPiece[8][8];
      this.checkmate = false;
      this.moves = new int[27][2];
      
      /*
      When you invoke this constructor, you're going to populate the ChessPiece 2d array 'board'
      with the default locations of the pieces. 
      */ 
      //creates white pieces
      this.board[0][0] = new ChessPiece("Rook", 1);
      this.board[0][1] = new ChessPiece("Knight", 1);
      this.board[0][2] = new ChessPiece("Bishop", 1);
      this.board[0][3] = new ChessPiece("King", 1);
      this.board[0][4] = new ChessPiece("Queen", 1);
      this.board[0][5] = new ChessPiece("Bishop", 1);
      this.board[0][6] = new ChessPiece("Knight", 1);
      this.board[0][7] = new ChessPiece("Rook", 1);
      this.board[1][0] = new ChessPiece("Pawn", 1);
      this.board[1][1] = new ChessPiece("Pawn", 1);
      this.board[1][2] = new ChessPiece("Pawn", 1);
      this.board[1][3] = new ChessPiece("Pawn", 1);
      this.board[1][4] = new ChessPiece("Pawn", 1);
      this.board[1][5] = new ChessPiece("Pawn", 1);
      this.board[1][6] = new ChessPiece("Pawn", 1);
      this.board[1][7] = new ChessPiece("Pawn", 1);
      
      
      //Creates White Pieces
      this.board[7][0] = new ChessPiece("Rook", 0);
      this.board[7][1] = new ChessPiece("Knight", 0);
      this.board[7][2] = new ChessPiece("Bishop", 0);
      this.board[7][3] = new ChessPiece("Queen", 0);
      this.board[7][4] = new ChessPiece("King", 0);
      this.board[7][5] = new ChessPiece("Bishop", 0);
      this.board[7][6] = new ChessPiece("Knight", 0);
      this.board[7][7] = new ChessPiece("Rook", 0);
      this.board[6][0] = new ChessPiece("Pawn", 0);
      this.board[6][1] = new ChessPiece("Pawn", 0);
      this.board[6][2] = new ChessPiece("Pawn", 0);
      this.board[6][3] = new ChessPiece("Pawn", 0);
      this.board[6][4] = new ChessPiece("Pawn", 0);
      this.board[6][5] = new ChessPiece("Pawn", 0);
      this.board[6][6] = new ChessPiece("Pawn", 0);
      this.board[6][7] = new ChessPiece("Pawn", 0);
   }
   
   /**
   * Attempts to move a chess piece to another location on the board. Returns true if successful. Otherwise false.
   * @param x1 the x coordinate of the piece attempting to move
   * @param y1 the y coordinate of the piece attempting to move
   * @param x2 the x coordinate of the moving piece's destination
   * @param y2 the x coordinate of the moving piece's destination
   * @return Returns true if the move is successful, and false otherwise
   */
   public boolean move(int x1, int y1, int x2, int y2)
   {
	   
	   board[x2][y2] = board[x1][y1];
	   board[x1][y1] = null;
	   
      /* 
      * if [x2,y2] not in board[x1,y1].getPossibleMoves(x1, y1) or board[x1,y1].getColour() == board[x2,y2].getColour()
      *     return false    
      * else:
      *     board[x2,y2] = board[x1,y1]
      *     board[x1,y1] = null
      *     moves.append([x1,y1,x2,y2])
      *     return true
      */
	   
	   
      
      return true; //placeholder so we can compile
   }
   
   //Hands off current state to client (debugging method only)
   public ChessPiece[][] getBoard()
   {
      return this.board;
   }
   
   /**
   *  Calculate if the game is in checkmate
   *  @return Returns true if the game is in checkmate, and false if not
   */
   public boolean isCheckmate()
   {
      //going to get really messy
      return this.checkmate; 
   }
   
   
   /**
   *  Determines if the game is in stalemate. 
   *  @return Returns true if it is in a stalemate, and false if not
   */
   public boolean isStalemate()
   {
      /*
      *  Every move is appended to an ArrayList in the form of [[x1,y1,x2,y2], [x1,y1,x2,y2]]
      *  Need to check if the same move is repeated 3 times
      *  Need to check if there are any possible moves
      *  Need to check for sufficent material. Example; king bishop vs king knight is stalemate
      *  and return true if the game is in stalemate, and false otherwise.
      */
      return false; //placeholder so we can compile
   }
}
