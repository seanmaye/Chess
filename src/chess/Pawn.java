package chess;
/** Represents a pawn piece in the game of chess.   
 * @author Vanessa Chin
 * @author Sean Maye
 * @version 1.0
*/
public class Pawn extends Piece {
	/**
	*Keeps track of whether or not a pawn has made its first move
	*/
	private boolean isFirstMove;
	/**
	*Keeps the count of the number of moves the pawn made 
	*/
	private int move;

	/**
	* Creates the Pawn object
	* <p>
	* This method calls its super class piece 
	* @param  x  the x coordinate of the pawn
	* @param  y  the y coordinate of the pawn
	* @param  color the color of the pawn piece 
	* @see Piece 
	*/
	public Pawn(int x, int y, boolean color) {
		super(x, y, color);
		isFirstMove = true;
		move=0;
	}
	/**
	* Returns true if the move made by the pawn is legal.
	* This method always handles special pawn cases such as their 
	* ability to move 2 spaces on their first move and en passant 
	* The dX and dY arguments must be integers 
	* <p>
	* This method is overridden from its super class, piece
	* @param  dX the x coordinate of where the pawn would like to move
	* @param  dY the y coordinate of where the pawn would like to move
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
		
		
		if (color) {
			if(x==3 &&y-1 >=0&&Board.board[x][y-1]instanceof Pawn) {
				Pawn toEnpassant = (Pawn) Board.board[x][y-1];
				
				if (toEnpassant.move==1) {
					move++;
					if ((y-1) % 2 == 0) {
						Board.board[x][y-1] = new Empty(x, y-1, false);
					} else {
						Board.board[x][y-1] = new Empty(x, y-1, true);
					}
					if ((y-1)% 2 == 1) {
						Board.board[x][y-1] = new Empty(x, y-1, false);
					} else {
						Board.board[x][y-1] = new Empty(x, y-1, true);
					}
					return true;
				}else {
					return false;
				}
			}else if(x==3 && y+1<8&&Board.board[x][y+1]instanceof Pawn) {
				Pawn toEnpassant = (Pawn) Board.board[x][y+1];
				
				if (toEnpassant.move==1) {
					move++;
					if ((y+1) % 2 == 0) {
						Board.board[x][y+1] = new Empty(x, y+1, false);
					} else {
						Board.board[x][y+1] = new Empty(x, y+1, true);
					}
					if ((y+1)% 2 == 1) {
						Board.board[x][y+1] = new Empty(x, y+1, false);
					} else {
						Board.board[x][y+1] = new Empty(x, y+1, true);
					}
					return true;
				}else {
					return false;
				}
			}else if ((dX == x-2 && dY == y) && isFirstMove == true
					&& Board.board[dX][dY]instanceof Empty && Board.board[x-1][y] instanceof Empty) {
				//x = x - 2;
		 		isFirstMove = false;
		 		move++;
				return true;
			} else if (dX == x-1 && dY == y
					&& Board.board[dX][dY] instanceof Empty) {
				//x = x - 1;
				isFirstMove = false;
				move++;
				return true;
			} else if (((dX == x-1 && dY == y-1) || (dX == x-1 && dY == y+1))
					&& ((!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor() != color)))){
				isFirstMove = false;
				move++;
				return true;
			} else {
				return false;
			}
		} else {
			if(x==4 && y-1>=0 &&Board.board[x][y-1]instanceof Pawn) {
				Pawn toEnpassant = (Pawn) Board.board[x][y-1];
				
				if (toEnpassant.move==1) {
					move++;
					if ((y-1) % 2 == 0) {
						Board.board[x][y-1] = new Empty(x, y-1, true);
					} else {
						Board.board[x][y-1] = new Empty(x, y-1, false);
					}
					if ((y-1)% 2 == 1) {
						Board.board[x][y-1] = new Empty(x, y-1, true);
					} else {
						Board.board[x][y-1] = new Empty(x, y-1, false);
					}
					return true;
				}else {
					return false;
				}
			}else if(x==4 &&y+1<8&&Board.board[x][y+1]instanceof Pawn) {
				Pawn toEnpassant = (Pawn) Board.board[x][y+1];
				
				if (toEnpassant.move==1) {
					move++;
					if ((y+1) % 2 == 0) {
						Board.board[x][y+1] = new Empty(x, y+1, true);
						
					} else {
						Board.board[x][y+1] = new Empty(x, y+1, false);
					}
					if ((y+1)% 2 == 1) {
						Board.board[x][y+1] = new Empty(x, y+1, true);
					} else {
						Board.board[x][y+1] = new Empty(x, y+1, false);
						
					}
					return true;
				}else {
					return false;
				}
			}else if ((dX == x+2 && dY == y) && isFirstMove == true
					&& Board.board[dX][dY] instanceof Empty && Board.board[x+1][y] instanceof Empty) {
				//x = x + 2;
				isFirstMove = false;
				move++;
				return true;
			} else if (dX == x+1 && dY == y
					&& Board.board[dX][dY] instanceof Empty) {
				//x = x + 1;
				isFirstMove = false;
				move++;
				return true;
			} else if (((dX == x+1 && dY == y-1) || (dX == x+1 && dY == y+1))
					&& ((!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor() != color)))){
				isFirstMove = false;
				move++;
				return true;
				
			} else {
				return false;
			}
		}


	}
	
	/**
	* Returns string that will represent the piece on the board
	* @return      wp if the piece is white and bp if the piece is black
	*/
	public String toString() {
		
		if (color) {
			return "wp";
		} else {
			return "bp";
		}
		}

	}

