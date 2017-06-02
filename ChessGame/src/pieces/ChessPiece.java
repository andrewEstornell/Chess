package pieces;

public class ChessPiece
{
   private int colour;
   private String piece;
   private int[][] possibleMoves;
   
   //initalizes an instance of each chess piece
   private Knight knight = new Knight();
   private King king = new King();
   private Queen queen = new Queen();
   private Pawn pawn = new Pawn();
   private Bishop bishop  = new Bishop();
   private Rook rook = new Rook();
   private EmptySpace emptySpace = new EmptySpace();
 
   
   /**
   * Class constructor for a ChessPiece
   * @param piece the type of piece to represent (pawn, knight, rook, ...)
   * @param colour the color of the ChessPiece. white == 0, black == 1            
   */
   public ChessPiece(String piece, int colour)
   {
      this.piece = piece;
      this.colour = colour;
   }
   
   /**
   * Returns an ArrayList&lt;ArrayList&lt;Integer&gt;&gt; which contains all valid moves for a given chess piece
   *  x the x coordinate of the this chesspiece
   *  y the y coordinate of this chesspiece 
   * return an ArrayList&lt;ArrayList&lt;Integer&gt;&gt; that represent possible moves as ordered pairs
   */
   public int[][] getPossibleMoves(int x, int y)
   {
 
      
      
      ///// Make sure "Piece" is capitalized/////
      
      
      if(this.piece == "Knight")
      {
    	  this.possibleMoves = this.knight.allPossibleMovesForThisPiece(x, y);
      }
      else if(this.piece == "Pawn")
      {
    	  this.possibleMoves = this.pawn.allPossibleMovesForThisPiece(x, y);
      }
      
      return this.possibleMoves;
   }
   
   /**
   * @return the String representation of the type of piece this ChessPiece represents
   */
   public String getType()
   {
	   //"Piece".getType().getPossibleMoves(x,y)
	   //return the actual chess object i.e. "rook"
      return this.piece;
   }
   
   
   /**
   * @return the int representation of the color of this ChessPiece. With 1 representing black, and 0 representing white
   */
   public int getColour()
   {
      return this.colour;
   }
   
}
