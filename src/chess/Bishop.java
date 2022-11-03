package chess;
/** Represents a bishop piece in the game of chess.   
 * @author Vanessa Chin
 * @author Sean Maye
 * @version 1.0
*/
public class Bishop extends Piece {

	/**
	* Creates the Bishop object
	* <p>
	* This method calls its super class piece 
	* @param  x  the x coordinate of the bishop
	* @param  y  the y coordinate of the bishop
	* @param  color the color of the bishop piece 
	* @see Piece 
	*/
	public Bishop(int x, int y, boolean color) {
		super(x, y, color);
	}

	
	/**
	* Returns true if the move made by the bishop is legal.
	* The dX and dY arguments must be integers 
	* <p>
	* This method is overridden from its super class, piece
	* @param  dX the x coordinate of where the bishop would like to move
	* @param  dY the y coordinate of where the bishop would like to move
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
		
		boolean hit  = false;
		boolean clear = true;
		
		for (int i = x+1, j = y+1; i<8 && j<8; i++, j++) {
			if (i==dX && j==dY) {
				hit = true;
				break;
			}
			if (!(Board.board[i][j] instanceof Empty)){
				clear = false;
			}
		}
		
		if (hit == true) {
			if (clear == true) {
				if(Board.board[dX][dY] instanceof Empty) {
					return true;
				} else if (!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor()!= color)){
					return true;
				}
			}
			return false;
		}
		
		
		
		clear = true;
		for (int i = x-1, j = y-1; i>=0 && j>=0; i--, j--) {
			if (i==dX && j==dY) {
				hit = true;
				break;
			}
			if (!(Board.board[i][j] instanceof Empty)){
				clear = false;
			}
		}
		
		if (hit == true) {
			if (clear == true) {
				if(Board.board[dX][dY] instanceof Empty) {
					return true;
				} else if (!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor()!= color)){
					return true;
				}
			}
			return false;
		}
		
		
		clear = true;
		for (int i = x+1, j = y-1; i<8 && j>=0; i++, j--) {
			if (i==dX && j==dY) {
				hit = true;
				break;
			}
			if (!(Board.board[i][j] instanceof Empty)){
				clear = false;
			}
		}
		
		if (hit == true) {
			if (clear == true) {
				if(Board.board[dX][dY] instanceof Empty) {
					return true;
				} else if (!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor()!= color)){
					return true;
				}
			}
			return false;
		}
		
		
		clear = true;
		for (int i = x-1, j = y+1; i>=0 && j<8; i--, j++) {
			if (i==dX && j==dY) {
				hit = true;
				break;
			}
			if (!(Board.board[i][j] instanceof Empty)){
				clear = false;
			}
		}
		
		if (hit == true) {
			if (clear == true) {
				if(Board.board[dX][dY] instanceof Empty) {
					return true;
				} else if (!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor()!= color)){
					return true;
				}
			}
			return false;
		}
		
		return false;

	}
	
	/**
	* Returns string that will represent the piece on the board
	* @return      wB if the piece is white and bB if the piece is black
	*/
	public String toString() {
		if (color == true) {
			return "wB";
		} else {
			return "bB";
		}
	}

}
