package chess;

public class Rook extends Piece {

	public Rook(int x, int y, boolean color) {
		super(x, y, color);

	}

	@Override
	public boolean move(int dX, int dY) {
		if (Chess.turn != color) {
			return false;
		}
		
		if (dX==x && dY==y)
			return false;
		
		
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
			} else {
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
			return "wR";
		} else {
			return "bR";
		}
	}

}
