package chess;
/** Represents a rook piece in the game of chess.   
 * @author Vanessa Chin
 * @author Sean Maye
 * @version 1.0
*/
public class Rook extends Piece {
	
	/**
	*Keeps track of whether or not a rook has made its first move
	*/
	public boolean moved;

	/**
	* Creates the Rook object
	* <p>
	* This method calls its super class piece 
	* @param  x  the x coordinate of the rook
	* @param  y  the y coordinate of the rook
	* @param  color the color of the rook piece 
	* @see Piece 
	*/
	public Rook(int x, int y, boolean color) {
		super(x, y, color);
		moved = false;

	}

	/**
	* Returns true if the move made by the rook is legal.
	* The dX and dY arguments must be integers 
	* <p>
	* This method is overridden from its super class, piece
	* @param  dX the x coordinate of where the rook would like to move
	* @param  dY the y coordinate of where the rook would like to move
	* @return      true if the move is legal and false if the move is illegal
	* @see Piece 
	*/
	public boolean move(int dX, int dY) {
		if (!King.isChecking&&Chess.turn != color) {
			return false;
		}
		
		if (dX==x && dY==y)
			return false;
		
		
		if (!(dX==x || dY==y)) {
			return false;
		}
		
		
		if (dX==x) {
			if (dY > y) {
				for (int j = y+1; j<dY; j++) {
					if (!(Board.board[dX][j] instanceof Empty)) {
						return false;
					}
				}
			} else { //(dY < y)
				for (int j = y-1; j>dY; j--) {
					if (!(Board.board[dX][j] instanceof Empty)) {
						return false;
					}
				}
			}
		}
			
				
		if (dY==y) {
			if (dX > x) {
				for (int i = x+1; i<dX; i++) {
					if (!(Board.board[i][dY] instanceof Empty)) {
						return false;
					}
				}
			} else { //(dX < x
				for (int i = x-1; i>dX; i--) {
					if (!(Board.board[i][dY] instanceof Empty)) {
						return false;
					}
				}
			}
		}
		
		if (Board.board[dX][dY] instanceof Empty) {
			return true;
		} else {
			if (Board.board[dX][dY].getColor()== color) {
				return false;
			} else {
				moved = true;
				return true;
			}
		}
	}
	
	/**
	* Returns string that will represent the piece on the board
	* @return      wR if the piece is white and bR if the piece is black
	*/
	public String toString() {
		if (color == true) {
			return "wR";
		} else {
			return "bR";
		}
	}

}
