package chess;
/** Represents a pawn piece in the game of chess.   
 * @author Vanessa Chin
 * @author Sean Maye
 * @version 1.0
*/
public class King extends Piece {
	/**
	*Keeps track of whether or not a rook has made its first move
	*/
	public boolean moved;
	/**
	*Keeps track if king is castled to left side
	*/
	public boolean castleL;
	/**
	*Keeps track if king is castled to right side
	*/
	public boolean castleR;
	/**
	*Variable that reflects if pieces moved for the purpose of checking if the king is in check
	*/
	public static boolean isChecking;
	
	/**
	* Creates the King object
	* <p>
	* This method calls its super class piece 
	* @param  x  the x coordinate of the king
	* @param  y  the y coordinate of the king
	* @param  color the color of the king piece 
	* @see Piece 
	*/
	public King(int x, int y, boolean color) {
		super(x, y, color);
		moved = false;
		castleL = false;
		castleR = false;
	}

	/**
	* Returns true if the move made by the king is legal.
	* Handles Castling
	* The dX and dY arguments must be integers. 
	* <p>
	* This method is overridden from its super class, piece
	* @param  dX the x coordinate of where the king would like to move
	* @param  dY the y coordinate of where the king would like to move
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
		
		
		
		//castling
		if ((dX==x && dY==y-2) && Board.board[dX][0] instanceof Rook && Board.board[dX][0].getColor()==color) {
			Rook r = (Rook) Board.board[dX][0];
			if (moved==false && r.moved==false && !Chess.check) {
				if(Board.board[dX][y-1] instanceof Empty
						&& Board.board[dX][y-2] instanceof Empty
						&& Board.board[dX][y-3] instanceof Empty){
					castleL = true;
					moved = true;
					return true;
				}
			}
		}
		
		if ((dX==x && dY==y+2) && Board.board[dX][7] instanceof Rook && Board.board[dX][7].getColor()==color) {
			Rook r = (Rook) Board.board[dX][7];
			if (moved==false && r.moved==false && !Chess.check) {
				if(Board.board[dX][y+1] instanceof Empty
						&& Board.board[dX][y+2] instanceof Empty){
					castleR = true;
					moved = true;
					return true;
				}
			}
		}
		
			
		
		if ((dX==x || dX==x-1 || dX==x+1) && (dY==y || dY==y-1 || dY==y+1)) {
			if (Board.board[dX][dY] instanceof Empty){
				King k = new King(dX, dY, color);
				if(color) {
					Chess.wkx=dX;
					Chess.wky=dY;
				}else {
					Chess.bkx=dX;
					Chess.bky=dY;
				}
				if (k.inCheck()) {
					return false;
				}
				moved = true;
				return true;
			} else if (!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor() != color)) {
				King k = new King(dX, dY, color);
				if(color) {
					Chess.wkx=dX;
					Chess.wky=dY;
				}else {
					Chess.bkx=dX;
					Chess.bky=dY;
				}
				if (k.inCheck()) {
					return false;
				}
				moved = true;
				return true;
			}
		}
		
		return false;

	}
	
	
	
	/**
	* Updates the x and y variables that track the white and black king
	*/
	public void trackKingPos() {
		if (color) {
			Chess.wkx = x;
			Chess.wky = y;
		}
		else {
			Chess.bkx = x;
			Chess.bky = y;
		}
	}
	
	
	/**
	* Returns true if the king is in check
	* <p>
	* Checks each piece to see if it can make a valid move onto the king
	* @return      true if king is in check and false if king is not in check
	* @see Piece 
	*/
	public boolean inCheck() {
		Piece p;
		isChecking=true;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				p = Board.board[i][j];
				
				//empty square
				if (p instanceof Empty) {
					continue;
				}
				
				//p is same color, so no threat
				if (color == p.color) {
					continue;
				}
				
				//p is opposite color, threat
				if (p.move(x,y)) {
					isChecking=false;
					return true;
				}else {
				}
				
			}
		}
		isChecking=false;
		return false;
	}
	
	
	
	/**
	* Tests if the king is in checkmate
	* <p>
	* Checks each piece to see if it can make a valid move to bring the king out of checkmate
	* @return      true if king is in checmate and false if king is not in checkmate
	* @see Piece 
	*/
	/*public boolean inCheckmate() {
		for (int i = 0; i<8; i++) {
			for (int j = 0; j<8;j++) {
				Piece p = Board.board[i][j];
				System.out.println(p);
				if (p.outOfCheck(color)) {
					return false;
				}
			}
		}
		return true;
	}*/

	
	/**
	* Returns string that will represent the piece on the board
	* @return wK if the piece is white and bK if the piece is black
	*/
	public String toString() {
		if (color == true) {
			return "wK";
		} else {
			return "bK";
		}
	}

}
