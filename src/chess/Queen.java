package chess;
/** Represents a pawn piece in the game of chess.   
 * @author Vanessa Chin
 * @author Sean Maye
 * @version 1.0
*/
public class Queen extends Piece {
	/**
	* Creates the Queen object
	* <p>
	* This method calls its super class piece 
	* @param  x  the x coordinate of the queen
	* @param  y  the y coordinate of the queen
	* @param  color the color of the queen piece 
	* @see Piece 
	*/
	public Queen(int x, int y, boolean color) {
		super(x, y, color);
	}

	
	/**
	* Returns true if the move made by the queen is legal.
	* The dX and dY arguments must be integers 
	* <p>
	* This method is overridden from its super class, piece
	* @param  dX the x coordinate of where the queen would like to move
	* @param  dY the y coordinate of where the queen would like to move
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
		
		
		//bishop code
		if(dX!= x && dY!=y) {
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
		
		
		if (dX==x) {
			return true;
		}
		
		if (dY==y) {
			return true;
		}
		}
		
		//rook code
		if((dX==x && dY!=y) || (dX!=x && dY==y)) {
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
				return true;
			}
		}
		}
		return false;
	}
	
	/**
	* Returns string that will represent the piece on the board
	* @return      wQ if the piece is white and bQ if the piece is black
	*/
	public String toString() {
		if (color == true) {
			return "wQ";
		} else {
			return "bQ";
		}
	}

}
