package chess;

public class Queen extends Piece {

	public Queen(int x, int y, boolean color) {
		super(x, y, color);
	}

	@Override
	public boolean move(int dX, int dY) {
		if (Chess.turn != color) {
			return false;
		}
		
		if (dX==x && dY==y) {
			return false;
		}
		
		
		//bishop code
		boolean hit  = false;
		boolean clear = true;
		
		for (int i = x+1, j = y+1; i<dX && j<dY; i++, j++) {
			if (i==dX && j==dY) {
				hit = true;
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
		
		
		
		//rook code
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

	public String toString() {
		if (color == true) {
			return "wQ";
		} else {
			return "bQ";
		}
	}

}
