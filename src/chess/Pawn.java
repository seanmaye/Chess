package chess;

public class Pawn extends Piece {
	private boolean isFirstMove;

	public Pawn(int x, int y, boolean color) {
		super(x, y, color);
		isFirstMove = true;

	}

	public boolean move(int dX, int dY) {
		if (Chess.turn != color) {
			return false;
		}
		
		if (dX==x && dY==y) {
			return false;
		}
		
		
		if (color) {
			if ((dX == x-2 && dY == y) && isFirstMove == true
					&& Board.board[dX][dY]instanceof Empty && Board.board[x-1][y] instanceof Empty) {
				//x = x - 2;
				isFirstMove = false;
				return true;
			} else if (dX == x-1 && dY == y
					&& Board.board[dX][dY] instanceof Empty) {
				//x = x - 1;
				isFirstMove = false;
				return true;
			} else if (((dX == x-1 && dY == y-1) || (dX == x-1 && dY == y-1))
					&& ((!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor() != color)))){
				isFirstMove = false;
				return true;
			} else {
				return false;
			}
		} else {
			if ((dX == x+2 && dY == y) && isFirstMove == true
					&& Board.board[dX][dY] instanceof Empty && Board.board[x+1][y] instanceof Empty) {
				//x = x + 2;
				isFirstMove = false;
				return true;
			} else if (dX == x+1 && dY == y
					&& Board.board[dX][dY] instanceof Empty) {
				//x = x + 1;
				isFirstMove = false;
				return true;
			} else if (((dX == x+1 && dY == y-1) || (dX == x+1 && dY == y+1))
					&& ((!(Board.board[dX][dY] instanceof Empty) && (Board.board[dX][dY].getColor() != color)))){
				isFirstMove = false;
				return true;
			} else {
				return false;
			}
		}


	}

	public String toString() {
		if (color) {
			return "wp";
		} else {
			return "bp";
		}
	}

}
