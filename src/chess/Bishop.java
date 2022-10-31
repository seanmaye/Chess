package chess;

public class Bishop extends Piece {

	public Bishop(int x, int y, boolean color) {
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
		
		return false;

	}

	public String toString() {
		if (color == true) {
			return "wB";
		} else {
			return "bB";
		}
	}

}
