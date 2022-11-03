package chess;
/** Represents a knight piece in the game of chess.   
 * @author Vanessa Chin
 * @author Sean Maye
 * @version 1.0
*/
public class Knight extends Piece {

	/**
	* Creates the Knight object
	* <p>
	* This method calls its super class piece 
	* @param  x  the x coordinate of the knight
	* @param  y  the y coordinate of the knight
	* @param  color the color of the knight piece 
	* @see Piece 
	*/
	public Knight(int x, int y, boolean color) {
		super(x, y, color);
	}

	
	
	
	/**
	* Returns true if the move made by the knight is legal. 
	* The dX and dY arguments must be integers.
	* <p>
	* This method is overridden from its super class, piece
	* @param  dX the x coordinate of where the knight would like to move
	* @param  dY the y coordinate of where the knight would like to move
	* @return      true if the move is legal and false if the move is illegal
	* @see Piece 
	*/
	public boolean move(int dX, int dY) {
		if (!King.isChecking&&Chess.turn != color) {
			return false;
		}
		
		if (dX==x && dY==y) {
			return false;
		}
		
		
		if (dX == x+2) {
			if (dY == y-1 || dY == y+1) {
				if (Board.board[dX][dY] instanceof Empty) {
					return true;
				} else if (!(Board.board[dX][dY] instanceof Empty) && Board.board[dX][dY].getColor() != color) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		if (dX == x+1) {
			if (dY == y-2 || dY == y+2) {
				if (Board.board[dX][dY] instanceof Empty) {
					return true;
				} else if (!(Board.board[dX][dY] instanceof Empty) && Board.board[dX][dY].getColor() != color) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		if (dX == x-1) {
			if (dY == y-2 || dY == y+2) {
				if (Board.board[dX][dY] instanceof Empty) {
					return true;
				} else if (!(Board.board[dX][dY] instanceof Empty) && Board.board[dX][dY].getColor() != color) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		if (dX == x-2) {
			if (dY == y-1 || dY == y+1) {
				if (Board.board[dX][dY] instanceof Empty) {
					return true;
				} else if (!(Board.board[dX][dY] instanceof Empty) && Board.board[dX][dY].getColor() != color) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;

	}
	/**
	* Returns string that will represent the piece on the board
	* @return      wN if the piece is white and bN if the piece is black
	*/
	public String toString() {
		if (color == true) {
			return "wN";
		} else {
			return "bN";
		}
	}

}
